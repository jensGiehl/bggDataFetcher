package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {

    @JacksonXmlProperty(isAttribute = true)
    private Integer level;

    @JacksonXmlProperty(isAttribute = true)
    private String value;

    @JacksonXmlProperty(isAttribute = true)
    private Long numvotes;

}
