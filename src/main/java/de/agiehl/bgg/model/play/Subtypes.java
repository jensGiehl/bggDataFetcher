package de.agiehl.bgg.model.play;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subtypes {

	@JacksonXmlElementWrapper(localName = "subtype", useWrapping = false)
	private List<Subtype> subtype;

}
