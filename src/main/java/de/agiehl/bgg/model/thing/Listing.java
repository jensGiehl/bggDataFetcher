package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import de.agiehl.bgg.model.common.ValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Listing {

    @JacksonXmlElementWrapper(useWrapping = false)
    private ValueObject listdate;

    @JacksonXmlElementWrapper(useWrapping = false)
    private Price price;

    @JacksonXmlElementWrapper(useWrapping = false)
    private ValueObject condition;

    @JacksonXmlElementWrapper(useWrapping = false)
    private ValueObject notes;

    @JacksonXmlElementWrapper(useWrapping = false)
    private ListingLink link;
}
