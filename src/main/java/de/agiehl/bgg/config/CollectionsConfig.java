package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CollectionsConfig {

    private final String url;

    public static CollectionsConfig getDefault() {
        return CollectionsConfig.builder()
                .url("https://api.geekdo.com/api/collections")
                .build();
    }

}
