package de.agiehl.bgg.model.thing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.agiehl.bgg.model.common.IntValueObject;
import de.agiehl.bgg.model.common.Version;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

  @JacksonXmlProperty(isAttribute = true)
  private String type;

  @JacksonXmlProperty(isAttribute = true)
  private Long id;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String thumbnail;

  @JacksonXmlElementWrapper(useWrapping = true)
  private String image;

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Name> name = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = true)
  private String description;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject yearpublished;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject minplayers;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject maxplayers;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject playingtime;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject minplaytime;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject maxplaytime;

  @JacksonXmlElementWrapper(useWrapping = true)
  private IntValueObject minage;

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Link> link = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Poll> poll = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  private Version versions;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Statistics statistics;

  @JacksonXmlElementWrapper(useWrapping = false)
  private Marketplacelistings marketplacelistings;

  public void setPoll(List<Poll> poll) {
    this.poll.addAll(poll);
  }

  public void setName(List<Name> name) {
    this.name.addAll(name);
  }

  public void setLink(List<Link> link) {
    this.link.addAll(link);
  }
}
