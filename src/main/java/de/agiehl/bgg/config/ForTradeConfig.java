package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ForTradeConfig {

    private final String url;

    public static ForTradeConfig getDefault() {
        return ForTradeConfig.builder()
                .url("https://api.geekdo.com/api/collections")
                .build();
    }

}
