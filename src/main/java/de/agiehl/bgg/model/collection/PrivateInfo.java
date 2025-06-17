package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrivateInfo {

  @JacksonXmlProperty(isAttribute = true)
  private String pp_currency;

  @JacksonXmlProperty(isAttribute = true)
  private String pricepaid;

  @JacksonXmlProperty(isAttribute = true)
  private String cv_currency;

  @JacksonXmlProperty(isAttribute = true)
  private String currvalue;

  @JacksonXmlProperty(isAttribute = true)
  private Integer quantity;

  @JacksonXmlProperty(isAttribute = true)
  private String acquisitiondate;

  @JacksonXmlProperty(isAttribute = true)
  private String acquiredfrom;

  @JacksonXmlProperty(isAttribute = true)
  private String inventorylocation;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String privatecomment;
}
