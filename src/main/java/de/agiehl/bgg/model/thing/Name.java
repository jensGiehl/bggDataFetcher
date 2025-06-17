package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Name {

  @JacksonXmlProperty(isAttribute = true)
  private String type;

  @JacksonXmlProperty(isAttribute = true)
  private Integer sortindex;

  @JacksonXmlProperty(isAttribute = true)
  private String value;
}
