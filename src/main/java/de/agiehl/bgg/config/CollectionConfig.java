package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

@Builder
@Data
public class CollectionConfig {

    private final String url;

    private final Boolean versions;

    private final Boolean stats;

    private final Boolean showPrivate;

    public String getBaseUrl() {
        return url +
                "?version=" + getBoolValue(versions) +
                "&stats=" + getBoolValue(stats) +
                "&showprivate=" + getBoolValue(showPrivate);
    }

    private String getBoolValue(Boolean value) {
        return Boolean.TRUE.equals(value) ? "1" : "0";
    }

    public static CollectionConfig getDefault() {
        return CollectionConfig.builder()
                .url(ROOT_API_URL + "/collection")
                .versions(Boolean.TRUE)
                .stats(Boolean.TRUE)
                .showPrivate(Boolean.TRUE)
                .build();
    }

}
