package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Marketplacelistings {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Listing> listing;
}
