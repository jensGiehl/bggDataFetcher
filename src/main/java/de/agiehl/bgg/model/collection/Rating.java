package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {

	@JacksonXmlProperty(isAttribute = true)
	private String value;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject usersrated;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject average;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject bayesaverage;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject stddev;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject median;

	@JacksonXmlElementWrapper(useWrapping = false)
	private Ranks ranks;

}
