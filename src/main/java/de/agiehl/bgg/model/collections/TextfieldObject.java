package de.agiehl.bgg.model.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextfieldObject {

    private String value;

    private String tstamp;

    private String rendered;

}
