package de.agiehl.bgg.model.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ranks {

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Rank> rank = new ArrayList<>();

  public void setRank(List<Rank> rank) {
    this.rank.addAll(rank);
  }
}
