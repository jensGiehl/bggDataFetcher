package de.agiehl.bgg.service.play;

import de.agiehl.bgg.config.PlayConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.play.Plays;
import de.agiehl.bgg.service.common.UrlBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Log
@AllArgsConstructor
public class PlayService {

	private final BggHttpClient httpFetch;

	private final PlayConfig config;

	public List<Plays> loadPlays(PlayQueryParameters parameters) {
		int totalPages;
		List<Plays> result = new ArrayList<>();
		do {
			String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), parameters);

			Plays plays = httpFetch.loadFromUrl(url, Plays.class);
			result.add(plays);

			totalPages = getTotalPages(plays);
			parameters.nextPage();

			log.info(String.format("Plays for User '%s' loaded (page %d of %d)", parameters.getUsernameOrId(), parameters.getPage(), totalPages));
		} while (parameters.getPage() <= totalPages);

		return result;
	}

	private int getTotalPages(Plays plays) {
		return new BigDecimal(plays.getTotal())
				.divide(BigDecimal.valueOf(config.getPlaysPerPage()), RoundingMode.UP)
				.intValue();
	}

}
