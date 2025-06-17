package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginConfig {

  private final String url;

  public static LoginConfig getDefault() {
    return LoginConfig.builder().url("https://boardgamegeek.com/login/api/v1").build();
  }
}
