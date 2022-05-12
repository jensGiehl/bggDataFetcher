package de.agiehl.bgg.model.search;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.agiehl.bgg.model.common.IntValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchItem {

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlElementWrapper(useWrapping = false)
    private SearchResultName name;

    @JacksonXmlElementWrapper(useWrapping = true)
    private IntValueObject yearpublished;
}
