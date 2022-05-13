package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "items")
public class CollectionsItems {

    @JacksonXmlProperty(isAttribute = true)
    private Long totalitems;

    @JacksonXmlProperty(isAttribute = true)
    private String termsofuse;

    @JacksonXmlProperty(isAttribute = true)
    private String pubdate;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CollectionItem> item;

}
