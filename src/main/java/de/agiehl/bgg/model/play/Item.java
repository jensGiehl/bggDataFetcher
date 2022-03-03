package de.agiehl.bgg.model.play;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

	@JacksonXmlProperty(isAttribute = true)
	private String name;

	@JacksonXmlProperty(isAttribute = true)
	private String objecttype;

	@JacksonXmlProperty(isAttribute = true)
	private Integer objectid;

	@JacksonXmlProperty(isAttribute = false)
	private Subtypes subtypes;

}
