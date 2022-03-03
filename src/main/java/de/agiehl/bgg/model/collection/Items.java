package de.agiehl.bgg.model.collection;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "items")
public class Items {

	@JacksonXmlProperty(isAttribute = true)
	private long totalitems;

	@JacksonXmlProperty(isAttribute = true)
	private String termsofuse;

	@JacksonXmlProperty(isAttribute = true)
	private String pubdate;

	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Item> item;

}
