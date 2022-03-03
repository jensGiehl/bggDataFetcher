package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Version {

	@JacksonXmlElementWrapper(useWrapping = false)
	private VersionItem item;

}
