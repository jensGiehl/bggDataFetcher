package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Status {

	@JacksonXmlProperty(isAttribute = true)
	private short own;

	@JacksonXmlProperty(isAttribute = true)
	private short prevowned;

	@JacksonXmlProperty(isAttribute = true)
	private short fortrade;

	@JacksonXmlProperty(isAttribute = true)
	private short want;

	@JacksonXmlProperty(isAttribute = true)
	private short wanttoplay;

	@JacksonXmlProperty(isAttribute = true)
	private short wanttobuy;

	@JacksonXmlProperty(isAttribute = true)
	private short wishlist;

	@JacksonXmlProperty(isAttribute = true)
	private short preordered;

	@JacksonXmlProperty(isAttribute = true)
	private String lastmodified;

}
