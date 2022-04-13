package de.agiehl.bgg.model.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Ranks {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rank> rank = new ArrayList<>();

    public void setRank(List<Rank> rank) {
        this.rank.addAll(rank);
    }
}
