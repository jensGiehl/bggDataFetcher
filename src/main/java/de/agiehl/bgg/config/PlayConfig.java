package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayConfig {

    private final String url;

    private final int playsPerPage;

    public static PlayConfig getDefault() {
        return PlayConfig.builder()
                .url("https://api.geekdo.com/xmlapi2/plays")
                .playsPerPage(100)
                .build();
    }
}
