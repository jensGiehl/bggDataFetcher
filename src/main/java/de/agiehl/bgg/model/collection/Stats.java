package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stats {

	@JacksonXmlProperty(isAttribute = true)
	private int minplayers;

	@JacksonXmlProperty(isAttribute = true)
	private int maxplayers;

	@JacksonXmlProperty(isAttribute = true)
	private int minplaytime;

	@JacksonXmlProperty(isAttribute = true)
	private int maxplaytime;

	@JacksonXmlProperty(isAttribute = true)
	private int playingtime;

	@JacksonXmlProperty(isAttribute = true)
	private long numowned;

	@JacksonXmlElementWrapper(useWrapping = false)
	private Rating rating;

}
