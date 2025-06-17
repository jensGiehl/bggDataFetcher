package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Results {

  @JacksonXmlProperty(isAttribute = true)
  private String numplayers;

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Result> result;
}
