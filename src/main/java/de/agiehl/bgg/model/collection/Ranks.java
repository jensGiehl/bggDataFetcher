package de.agiehl.bgg.model.collection;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ranks {

	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Rank> rank;

}
