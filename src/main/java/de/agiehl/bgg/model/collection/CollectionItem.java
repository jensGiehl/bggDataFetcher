package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.agiehl.bgg.model.common.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CollectionItem {

  @JacksonXmlProperty(isAttribute = true)
  private String objecttype;

  @JacksonXmlProperty(isAttribute = true)
  private Long objectid;

  @JacksonXmlProperty(isAttribute = true)
  private String subtype;

  @JacksonXmlProperty(isAttribute = true)
  private Long collid;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Name name;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String originalname;

  @JacksonXmlElementWrapper(useWrapping = true)
  private Integer yearpublished;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String image;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String thumbnail;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Stats stats;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Status status;

  @JacksonXmlElementWrapper(useWrapping = true)
  private Long numplays;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String comment;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Version version;

  @JacksonXmlElementWrapper(useWrapping = false)
  private PrivateInfo privateinfo;
}
