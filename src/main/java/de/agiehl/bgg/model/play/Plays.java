package de.agiehl.bgg.model.play;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "plays")
public class Plays {

  @JacksonXmlProperty(isAttribute = true)
  private String username;

  @JacksonXmlProperty(isAttribute = true)
  private Integer userid;

  @JacksonXmlProperty(isAttribute = true)
  private Integer total;

  @JacksonXmlProperty(isAttribute = true)
  private Integer page;

  @JacksonXmlElementWrapper(localName = "play", useWrapping = false)
  private List<Play> play = new ArrayList<>();

  public void setPlay(List<Play> play) {
    this.play.addAll(play);
  }
}
