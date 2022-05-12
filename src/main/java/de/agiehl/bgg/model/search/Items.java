package de.agiehl.bgg.model.search;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "items")
public class Items {

    @JacksonXmlProperty(isAttribute = true)
    private Long total;

    @JacksonXmlProperty(isAttribute = true)
    private String termsofuse;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Item> item;
}
