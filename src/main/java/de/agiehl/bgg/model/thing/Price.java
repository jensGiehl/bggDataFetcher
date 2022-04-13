package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Price {

    @JacksonXmlProperty(isAttribute = true)
    private String currency;

    @JacksonXmlProperty(isAttribute = true)
    private String value;
}
