package de.agiehl.bgg.service.search;

import de.agiehl.bgg.config.SearchConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.search.SearchItems;
import de.agiehl.bgg.service.common.BggBooleanUtils;
import de.agiehl.bgg.service.common.Type;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log
@AllArgsConstructor
public class SearchService {

    private static final List<Type> BOARDGAME_TYPES = Arrays.asList(Type.BOARDGAME, Type.BOARDGAMEEXPANSION);

    private final BggHttpClient httpFetch;

    private final SearchConfig config;

    public SearchItems search(String searchQuery) {
        return search(SearchQueryParameters.builder().query(searchQuery).exact(false).build());
    }

    public SearchItems searchExact(String searchQuery) {
        return search(SearchQueryParameters.builder().query(searchQuery).exact(true).build());
    }

    public SearchItems searchBoardgames(String searchQuery) {
        return search(SearchQueryParameters.builder().query(searchQuery).exact(false).types(BOARDGAME_TYPES).build());
    }

    public SearchItems searchBoardgamesExact(String searchQuery) {
        return search(SearchQueryParameters.builder().query(searchQuery).exact(true).types(BOARDGAME_TYPES).build());
    }

    public SearchItems search(SearchQueryParameters queryParameters) {
        String encodedSearchQuery = URLEncoder.encode(queryParameters.getQuery(), StandardCharsets.UTF_8);
        String url = config.getUrl() +
                "?query=" + encodedSearchQuery +
                "&type=" + getTypeString(queryParameters) +
                "&exact=" + BggBooleanUtils.getInstance().toStringValue(queryParameters.isExact());

        return httpFetch.loadFromUrl(url, SearchItems.class);
    }

    private String getTypeString(SearchQueryParameters queryParameters) {
        return queryParameters.getTypes()
                .stream()
                .map(Type::name)
                .map(String::toLowerCase)
                .collect(Collectors.joining(","));
    }

}
