package de.agiehl.bgg.model.fortrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Version {

    private String objecttype;

    private Long objectid;

    private String versionname;

    private String linkedname;

    private String name;

    private Integer yearpublished;

    private String href;

    private Image images;

}
