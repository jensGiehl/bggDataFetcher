package de.agiehl.bgg.model.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValueObject {

	@JacksonXmlProperty(isAttribute = true)
	private String value;

}
