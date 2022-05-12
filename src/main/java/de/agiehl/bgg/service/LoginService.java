package de.agiehl.bgg.service;

import de.agiehl.bgg.config.LoginConfig;
import de.agiehl.bgg.fetch.BggHttpClient;
import de.agiehl.bgg.model.Credentials;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class LoginService {

    private final BggHttpClient httpClient;

    private final LoginConfig config;

    public void login(Credentials cred) {
        String url = "https://boardgamegeek.com/login/api/v1";
        String json = String.format("{\"credentials\":{\"username\":\"%s\",\"password\":\"%s\"}}", cred.getUsername(),
                cred.getPassword());

        httpClient.postContent(url, json);
    }

}
