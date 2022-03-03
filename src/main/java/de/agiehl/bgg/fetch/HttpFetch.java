package de.agiehl.bgg.fetch;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import lombok.extern.java.Log;

@Log
public class HttpFetch {

	public String loadFromUrl(String url) throws Exception {
		log.fine(() -> "Loading URL: " + url);

		HttpRequest request = HttpRequest.newBuilder() //
				.uri(new URI(url)) //
				.GET() //
				.timeout(Duration.ofSeconds(10))//
				.build();

		HttpClient client = HttpClient.newHttpClient();

		HttpResponse<String> response;
		boolean retry = false;
		int retryCounter = 0;
		do {
			retry = false;
			response = client.send(request, BodyHandlers.ofString());
			log.fine("HTTP Statuscode is: " + response.statusCode());

			if (retryBasedOnStatuscode(response) && retryCounter < 10) {
				retry = true;
				retryCounter++;
				log.info("Waiting for Retry #" + retryCounter);
				Thread.sleep(Duration.ofSeconds(20).toMillis());
			}
		} while (retry);

		return response.body();
	}

	private boolean retryBasedOnStatuscode(HttpResponse<String> response) {
		int statusCode = response.statusCode();
		return statusCode == 202 || statusCode == 429;
	}

}
