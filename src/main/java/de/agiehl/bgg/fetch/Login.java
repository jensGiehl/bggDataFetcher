package de.agiehl.bgg.fetch;

import de.agiehl.bgg.model.Credentials;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URISyntaxException;

@Log
@AllArgsConstructor
public class Login {

	private final HttpFetch httpClient;

	public void login(Credentials cred) throws URISyntaxException, IOException, InterruptedException {
		String url = "https://boardgamegeek.com/login/api/v1";
		String json = String.format("{\"credentials\":{\"username\":\"%s\",\"password\":\"%s\"}}", cred.getUsername(),
				cred.getPassword());

		httpClient.fireAndForgotPost(url, json);
	}

}
