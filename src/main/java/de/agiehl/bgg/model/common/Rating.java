package de.agiehl.bgg.model.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {

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

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject owned;

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject trading;

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject wanting;

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject wishing;

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject numcomments;

	@JacksonXmlElementWrapper(useWrapping = false)
	private IntValueObject numweights;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject averageweight;

}
