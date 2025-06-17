package de.agiehl.bgg.model.search;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "items")
public class SearchItems {

  @JacksonXmlProperty(isAttribute = true)
  private Long total;

  @JacksonXmlProperty(isAttribute = true)
  private String termsofuse;

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<SearchItem> item;
}
