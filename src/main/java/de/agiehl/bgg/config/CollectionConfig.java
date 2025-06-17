package de.agiehl.bgg.config;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CollectionConfig {

  private final String url;

  public static CollectionConfig getDefault() {
    return CollectionConfig.builder().url(ROOT_API_URL + "/collection").build();
  }
}
