package de.agiehl.bgg.config;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ThingConfig {

  public static final String URL = ROOT_API_URL + "/thing";

  private final String url;

  private final Integer maxIdsPerRequest;

  public static ThingConfig getDefault() {
    return ThingConfig.builder().url(URL).maxIdsPerRequest(100).build();
  }
}
