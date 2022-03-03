package de.agiehl.bgg.model.collection;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VersionItem {

	@JacksonXmlProperty(isAttribute = true)
	private String type;

	@JacksonXmlProperty(isAttribute = true)
	private long id;

	@JacksonXmlElementWrapper(useWrapping = true)
	private String thumbnail;

	@JacksonXmlElementWrapper(useWrapping = true)
	private String image;

	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Link> link;

	@JacksonXmlElementWrapper(useWrapping = false)
	private VersionName name;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject yearpublished;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject productcode;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject width;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject length;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject depth;

	@JacksonXmlElementWrapper(useWrapping = false)
	private ValueObject weight;

}
