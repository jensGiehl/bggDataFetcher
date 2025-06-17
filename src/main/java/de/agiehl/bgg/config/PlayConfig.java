package de.agiehl.bgg.config;

import static de.agiehl.bgg.config.BggConfig.ROOT_API_URL;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayConfig {

  private final String url;

  private final int playsPerPage;

  public static PlayConfig getDefault() {
    return PlayConfig.builder().url(ROOT_API_URL + "/plays").playsPerPage(100).build();
  }
}
