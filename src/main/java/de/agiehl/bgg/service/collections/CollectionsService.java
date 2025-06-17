package de.agiehl.bgg.service.collections;

import de.agiehl.bgg.config.CollectionsConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.collections.BggCollections;
import de.agiehl.bgg.service.common.UrlBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class CollectionsService {

  private final BggHttpClient httpFetch;

  private final CollectionsConfig config;

  public BggCollections loadForTrade(CollectionsQueryParameters parameters) {
    String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), parameters);

    BggCollections forTradeItems = httpFetch.loadJsonFromUrl(url, BggCollections.class);

    while (forTradeItems.getItems().size() < forTradeItems.getConfig().getNumitems()) {
      parameters.setPageid(parameters.getPageid() + 1);
      url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), parameters);
      forTradeItems
          .getItems()
          .addAll(httpFetch.loadJsonFromUrl(url, BggCollections.class).getItems());
    }

    log.info(() -> String.format("For Trade for '%s' loaded", parameters.getObjectid()));

    return forTradeItems;
  }
}
