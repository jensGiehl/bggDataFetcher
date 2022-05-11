package de.agiehl.bgg.fetch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.agiehl.bgg.config.HttpConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

@Log
public class BggHttpClient {

	private final HttpConfig config;

	private final HttpClient httpClient;

	private final XmlMapper xmlMapper;

	public BggHttpClient(HttpConfig config) {
		this.config = config;

		this.httpClient = HttpClient.newBuilder()
				.connectTimeout(config.getConnectionTimeout())
				.cookieHandler(new CookieManager())
				.build();

		this.xmlMapper = new XmlMapper();
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public <T> T loadFromUrl(String url, Class<T> resultType) {
		log.fine(() -> "Loading URL: " + url);

		HttpRequest request = HttpRequest.newBuilder() //
				.uri(getUri(url)) //
				.GET() //
				.timeout(config.getRequestTimeout())//
				.build();

		HttpResponse<String> response = retryRequest(request);

		String responseBody = response.body();
		log.finest(() -> String.format("RAW Response from %s: %s", url, responseBody));

		return mapXmlResult(resultType, responseBody);
	}

	private <T> T mapXmlResult(Class<T> resultType, String responseBody) {
		try {
			return xmlMapper.readValue(responseBody, resultType);
		} catch (JsonProcessingException e) {
			throw new BggHttpClientException("Error while converting result into " + resultType.getName() + ". Response Body: " + responseBody, e);
		}
	}

	private HttpResponse<String> retryRequest(HttpRequest request) {
		HttpResponse<String> response;
		boolean retry;
		int retryCounter = 0;
		do {
			retry = false;
			response = getHttpResponse(request);
			log.fine("HTTP Statuscode is: " + response.statusCode());

			if (retryBasedOnStatuscode(response) && retryCounter < config.getMaxRetries()) {
				retry = true;
				retryCounter++;
				log.info("Waiting for Retry #" + retryCounter);
				waitForNextRetry();
			}
		} while (retry);
		return response;
	}

	private void waitForNextRetry() {
		try {
			Thread.sleep(Duration.ofSeconds(20).toMillis());
		} catch (InterruptedException e) {
			throw new BggHttpClientException("Error while waiting for next retry", e);
		}
	}

	private HttpResponse<String> getHttpResponse(HttpRequest request) {
		try {
			return httpClient.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new BggHttpClientException("Error while loading URI: " + request.uri().toASCIIString(), e);
		}
	}

	public void postContent(String url, String body) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(getUri(url))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(body))
				.build();

		HttpResponse<String> response = getHttpResponse(request);
		int statusCode = response.statusCode();
		if (statusCode != HttpStatuscode.OK.code && statusCode != HttpStatuscode.NO_CONTENT.code) {
			throw new BggHttpClientException(
					String.format("Error while POST content to %s. Statuscode: %d  Body: %s", url, statusCode, response.body())
			);
		}
	}

	private URI getUri(String url) {
		try {
			return new URI(url);
		} catch (URISyntaxException e) {
			throw new BggHttpClientException("Error to create URI from " + url, e);
		}
	}

	private boolean retryBasedOnStatuscode(HttpResponse<String> response) {
		int statusCode = response.statusCode();
		return statusCode == HttpStatuscode.ACCEPTED.getCode() || statusCode == HttpStatuscode.TOO_MANY_REQUESTS.getCode();
	}

	@AllArgsConstructor
	@Getter
	private enum HttpStatuscode {
		OK(200), ACCEPTED(202), TOO_MANY_REQUESTS(429), NO_CONTENT(204);

		private final int code;
	}

}
