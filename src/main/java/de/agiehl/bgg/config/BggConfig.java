package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BggConfig {

    public static final String ROOT_API_URL = "https://boardgamegeek.com/xmlapi2";

    @Builder.Default
    private CollectionConfig collectionConfig = CollectionConfig.getDefault();

    @Builder.Default
    private HttpConfig httpConfig = HttpConfig.getDefault();

    @Builder.Default
    private LoginConfig loginConfig = LoginConfig.getDefault();

    @Builder.Default
    private PlayConfig playConfig = PlayConfig.getDefault();

    @Builder.Default
    private ThingConfig thingConfig = ThingConfig.getDefault();

    @Builder.Default
    private SearchConfig searchConfig = SearchConfig.getDefault();

    public static BggConfig getDefault() {
        return BggConfig.builder().build();
    }
}
