package de.agiehl.bgg.model.play;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Players {

	@JacksonXmlProperty(isAttribute = true)
	private String username;

	@JacksonXmlProperty(isAttribute = true)
	private Integer userid;

	@JacksonXmlProperty(isAttribute = true)
	private String name;

	@JacksonXmlProperty(isAttribute = true)
	private String startposition;

	@JacksonXmlProperty(isAttribute = true)
	private String color;

	@JacksonXmlProperty(isAttribute = true)
	private Double score;

	@JacksonXmlProperty(isAttribute = true, localName = "new")
	private Short isNew;

	@JacksonXmlProperty(isAttribute = true)
	private Integer rating;

	@JacksonXmlProperty(isAttribute = true)
	private Short win;

}
