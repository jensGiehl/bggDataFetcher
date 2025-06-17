package de.agiehl.bgg.service.login;

import de.agiehl.bgg.config.LoginConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

/**
 * This service offers user authentication for accessing private information. Login is required to
 * access private information.
 */
@Log
@AllArgsConstructor
public class LoginService {

  private final BggHttpClient httpClient;

  private final LoginConfig config;

  public void login(LoginCredentials cred) {
    String url = config.getUrl();
    String json =
        String.format(
            "{\"credentials\":{\"username\":\"%s\",\"password\":\"%s\"}}",
            cred.getUsername(), cred.getPassword());

    httpClient.postContent(url, json);
  }
}
