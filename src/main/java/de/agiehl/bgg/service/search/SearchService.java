package de.agiehl.bgg.service.search;

import de.agiehl.bgg.config.SearchConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.search.SearchItems;
import de.agiehl.bgg.service.common.UrlBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

/** Conducts a search on boardgamegeek.com. */
@Log
@AllArgsConstructor
public class SearchService {

  private final BggHttpClient httpFetch;

  private final SearchConfig config;

  public SearchItems search(SearchQueryParameters queryParameters) {
    String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), queryParameters);

    return httpFetch.loadFromUrl(url, SearchItems.class);
  }
}
