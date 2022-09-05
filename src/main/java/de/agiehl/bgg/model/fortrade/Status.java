package de.agiehl.bgg.model.fortrade;

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

}
