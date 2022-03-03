package de.agiehl.bgg.fetch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import de.agiehl.bgg.model.play.Plays;
import lombok.extern.java.Log;

@Log
public class LoadPlay {

	private static final int PLAYS_PER_PAGE = 100;

	public List<Plays> loadPlaysForBggUser(String username) throws Exception {
		String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());

		int page = 1;
		int totalPages = 1;
		List<Plays> result = new ArrayList<>();
		do {
			String url = "https://api.geekdo.com/xmlapi2/plays?username=" + encodedUsername + "&page=" + page;

			String content = new HttpFetch().loadFromUrl(url);

			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			Plays plays = xmlMapper.readValue(content, Plays.class);
			result.add(plays);

			totalPages = getTotalPages(plays);

			log.info(String.format("Plays for %s loaded (page %d of %d)", username, page, totalPages));
		} while (page <= totalPages);

		return result;
	}

	private int getTotalPages(Plays plays) {
		return new BigDecimal(plays.getTotal()).divide(BigDecimal.valueOf(PLAYS_PER_PAGE), RoundingMode.UP).intValue();
	}

}
