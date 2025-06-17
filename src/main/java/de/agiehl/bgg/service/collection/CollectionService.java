package de.agiehl.bgg.service.collection;

import de.agiehl.bgg.config.CollectionConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.collection.CollectionsItems;
import de.agiehl.bgg.service.common.UrlBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

/**
 * Retrieves information about a user's collection. For more details, refer to the BoardGameGeek XML
 * API2 documentation: <a href="https://boardgamegeek.com/wiki/page/BGG_XML_API2#toc12">BGG XML
 * API2</a>
 */
@Log
@AllArgsConstructor
public class CollectionService {

  private final BggHttpClient httpFetch;

  private final CollectionConfig config;

  public CollectionsItems loadCollection(CollectionQueryParameters parameters) {
    String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), parameters);

    CollectionsItems items = httpFetch.loadFromUrl(url, CollectionsItems.class);

    log.info(() -> String.format("Collection for User '%s' loaded", parameters.getUsername()));

    return items;
  }
}
