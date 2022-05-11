package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ThingConfig {

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
                .url("https://api.geekdo.com/xmlapi2/thing")
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
