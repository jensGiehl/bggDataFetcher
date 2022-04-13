package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListingLink {

    @JacksonXmlProperty(isAttribute = true)
    private String href;

    @JacksonXmlProperty(isAttribute = true)
    private String title;
}
