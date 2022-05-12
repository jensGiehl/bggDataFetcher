package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

@Builder
@Data
public class ThingConfig {

    public static final String URL = ROOT_API_URL + "/thing";

    private final String url;

    private final Integer maxIdsPerRequest;

    private final Boolean marketplace;

    private final Boolean versions;

    private final Boolean videos;

    private final Boolean stats;

    private final Boolean comments;

    private final Boolean ratingComments;

    public String getUrl(String ids) {
        return url +
                "?marketplace=" + getBoolValue(marketplace) +
                "&versions=" + getBoolValue(versions) +
                "&videos=" + getBoolValue(videos) +
                "&stats=" + getBoolValue(stats) +
                "&comments=" + getBoolValue(comments) +
                "&ratingcomments=" + getBoolValue(ratingComments) +
                "&id=" + ids;
    }

    private String getBoolValue(Boolean value) {
        return Boolean.TRUE.equals(value) ? "1" : "0";
    }

    public static ThingConfig getDefault() {
        return ThingConfig.builder()
                .url(URL)
                .maxIdsPerRequest(100)
                .marketplace(Boolean.TRUE)
                .versions(Boolean.TRUE)
                .videos(Boolean.FALSE)
                .stats(Boolean.TRUE)
                .comments(Boolean.FALSE)
                .ratingComments(Boolean.FALSE)
                .build();
    }

    public static ThingConfig getMinimalDefaultConfig() {
        return ThingConfig.builder()
                .url(URL)
                .maxIdsPerRequest(100)
                .marketplace(Boolean.FALSE)
                .versions(Boolean.FALSE)
                .videos(Boolean.FALSE)
                .stats(Boolean.FALSE)
                .comments(Boolean.FALSE)
                .ratingComments(Boolean.FALSE)
                .build();
    }

    public static ThingConfig getFullDefaultConfig() {
        return ThingConfig.builder()
                .url(URL)
                .maxIdsPerRequest(100)
                .marketplace(Boolean.TRUE)
                .versions(Boolean.TRUE)
                .videos(Boolean.TRUE)
                .stats(Boolean.TRUE)
                .comments(Boolean.TRUE)
                .ratingComments(Boolean.TRUE)
                .build();
    }
}
