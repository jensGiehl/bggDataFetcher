package de.agiehl.bgg.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BggConfig {

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

    public static BggConfig getDefault() {
        return BggConfig.builder().build();
    }
}
