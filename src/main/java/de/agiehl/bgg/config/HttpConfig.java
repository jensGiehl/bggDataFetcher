package de.agiehl.bgg.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

@ToString
@Getter
@Builder
@AllArgsConstructor
public class HttpConfig {

    private final Duration httpTimeout;

    private final int maxRetries;


    public static HttpConfig defaultConfig() {
        return HttpConfig.builder().httpTimeout(Duration.ofSeconds(10)).maxRetries(10).build();
    }

}
