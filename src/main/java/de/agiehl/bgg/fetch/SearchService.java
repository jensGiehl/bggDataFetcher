package de.agiehl.bgg.fetch;

import de.agiehl.bgg.config.SearchConfig;
import de.agiehl.bgg.model.search.Items;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Log
@AllArgsConstructor
public class SearchService {

    private final BggHttpClient httpFetch;

    private final SearchConfig config;

    public Items search(String searchQuery) {
        String encodedSearchQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        String url = config.getUrl() + "?query=" + searchQuery;

        return httpFetch.loadFromUrl(url, Items.class);
    }

}
