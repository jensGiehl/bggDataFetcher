package de.agiehl.bgg.service;

import de.agiehl.bgg.config.SearchConfig;
import de.agiehl.bgg.fetch.BggHttpClient;
import de.agiehl.bgg.model.search.SearchItems;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Log
@AllArgsConstructor
public class SearchService {

    private final BggHttpClient httpFetch;

    private final SearchConfig config;

    public SearchItems search(String searchQuery) {
        String encodedSearchQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        String url = config.getUrl() + "?query=" + searchQuery;

        return httpFetch.loadFromUrl(url, SearchItems.class);
    }

}
