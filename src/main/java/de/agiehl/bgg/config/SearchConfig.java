package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

@Builder
@Data
public class SearchConfig {

    private final String url;

    public static SearchConfig getDefault() {
        return SearchConfig.builder()
                .url(ROOT_API_URL + "/search")
                .build();
    }

}
