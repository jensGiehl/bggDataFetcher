package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Name {

	@JacksonXmlProperty(isAttribute = true)
	private long sortindex;

	@JacksonXmlText
	private String name;

}
