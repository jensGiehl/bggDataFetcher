package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Status {

	@JacksonXmlProperty(isAttribute = true)
	private Short own;

	@JacksonXmlProperty(isAttribute = true)
	private Short prevowned;

	@JacksonXmlProperty(isAttribute = true)
	private Short fortrade;

	@JacksonXmlProperty(isAttribute = true)
	private Short want;

	@JacksonXmlProperty(isAttribute = true)
	private Short wanttoplay;

	@JacksonXmlProperty(isAttribute = true)
	private Short wanttobuy;

	@JacksonXmlProperty(isAttribute = true)
	private Short wishlist;

	@JacksonXmlProperty(isAttribute = true)
	private Short preordered;

	@JacksonXmlProperty(isAttribute = true)
	private String lastmodified;

}
