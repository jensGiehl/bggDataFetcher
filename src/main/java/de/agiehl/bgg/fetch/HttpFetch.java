package de.agiehl.bgg.fetch;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
public class HttpFetch {

	private final Duration timeout;

	private final int maxRetries;

	private final HttpClient httpClient;

	private final XmlMapper xmlMapper;

	public HttpFetch(Duration timeout, int maxRetries) {
		this.timeout = timeout;
		this.maxRetries = maxRetries;
		this.httpClient = HttpClient.newBuilder()
				.connectTimeout(timeout)
				.cookieHandler(new CookieManager())
				.build();

		this.xmlMapper = new XmlMapper();
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public <T> T loadFromUrl(String url, Class<T> resultType) throws Exception {
		log.fine(() -> "Loading URL: " + url);

		HttpRequest request = HttpRequest.newBuilder() //
				.uri(new URI(url)) //
				.GET() //
				.timeout(timeout)//
				.build();

		HttpResponse<String> response;
		boolean retry;
		int retryCounter = 0;
		do {
			retry = false;
			response = httpClient.send(request, BodyHandlers.ofString());
			log.fine("HTTP Statuscode is: " + response.statusCode());

			if (retryBasedOnStatuscode(response) && retryCounter < maxRetries) {
				retry = true;
				retryCounter++;
				log.info("Waiting for Retry #" + retryCounter);
				Thread.sleep(Duration.ofSeconds(20).toMillis());
			}
		} while (retry);

		String responseBody = response.body();
		log.finest(() -> String.format("RAW Response from %s: %s", url, responseBody));

		return xmlMapper.readValue(responseBody, resultType);
	}

	public void fireAndForgotPost(String url, String body) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI(url))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(body))
				.build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		if (response.statusCode() != 200 && response.statusCode() != 204) {
			throw new PostException(response.statusCode(), response.body());
		}
	}

	private boolean retryBasedOnStatuscode(HttpResponse<String> response) {
		int statusCode = response.statusCode();
		return statusCode == 202 || statusCode == 429;
	}

}
