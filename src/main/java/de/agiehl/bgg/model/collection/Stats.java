package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.agiehl.bgg.model.common.Rating;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stats {

	@JacksonXmlProperty(isAttribute = true)
	private Integer minplayers;

	@JacksonXmlProperty(isAttribute = true)
	private Integer maxplayers;

	@JacksonXmlProperty(isAttribute = true)
	private Integer minplaytime;

	@JacksonXmlProperty(isAttribute = true)
	private Integer maxplaytime;

	@JacksonXmlProperty(isAttribute = true)
	private Integer playingtime;

	@JacksonXmlProperty(isAttribute = true)
	private long numowned;

	@JacksonXmlElementWrapper(useWrapping = false)
	private Rating rating;

}
