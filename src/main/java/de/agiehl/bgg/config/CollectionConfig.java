package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

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
                .url("https://boardgamegeek.com/xmlapi2/collection")
                .versions(Boolean.TRUE)
                .stats(Boolean.TRUE)
                .showPrivate(Boolean.TRUE)
                .build();
    }

}
