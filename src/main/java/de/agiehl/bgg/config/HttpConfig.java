package de.agiehl.bgg.config;

import java.time.Duration;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpConfig {

  private final Duration connectionTimeout;

  private final Duration requestTimeout;

  private final Duration waitBetweenRetires;

  private final int maxRetries;

  public static HttpConfig getDefault() {
    return HttpConfig.builder()
        .connectionTimeout(Duration.ofSeconds(10))
        .requestTimeout(Duration.ofSeconds(60))
        .maxRetries(15)
        .waitBetweenRetires(Duration.ofSeconds(20))
        .build();
  }
}
