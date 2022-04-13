package de.agiehl.bgg.model.play;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Play {

    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty(isAttribute = true)
    private LocalDate date;

	@JacksonXmlProperty(isAttribute = true)
	private Integer quantity;

	@JacksonXmlProperty(isAttribute = true)
	private Integer length;

	@JacksonXmlProperty(isAttribute = true)
	private Short incomplete;

	@JacksonXmlProperty(isAttribute = true)
	private Short nowinstats;

	@JacksonXmlProperty(isAttribute = true)
	private String location;

    @JacksonXmlProperty(isAttribute = false)
    private Item item;

    @JacksonXmlProperty(isAttribute = false)
    private String comments;

    @JacksonXmlElementWrapper(localName = "players", useWrapping = true)
    private List<Players> players = new ArrayList<>();

    public void setPlayers(List<Players> players) {
        this.players.addAll(players);
    }
}
