package de.agiehl.bgg.model.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

  private Boolean own;

  private Boolean fortrade;

  private Boolean wanttobuy;

  private Boolean wanttoplay;

  private Boolean wishlist;

  private Boolean prevowned;

  private Boolean want;

  private Boolean preordered;
}
