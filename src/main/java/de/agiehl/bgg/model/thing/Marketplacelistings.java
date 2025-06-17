package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Marketplacelistings {

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Listing> listing;
}
