package de.agiehl.bgg.service.thing;

import de.agiehl.bgg.config.ThingConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.thing.Item;
import de.agiehl.bgg.model.thing.Items;
import de.agiehl.bgg.service.common.UrlBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

/**
 * Retrieves information about various "things". For more details, refer to the BoardGameGeek XML
 * API2 documentation: <a href="https://boardgamegeek.com/wiki/page/BGG_XML_API2#toc4">BGG XML
 * API2</a>
 */
@Log
@AllArgsConstructor
public class ThingService {

  private final BggHttpClient httpFetch;

  private final ThingConfig config;

  public List<Item> loadThings(ThingQueryParameters queryParameters) {
    List<List<Long>> chunkedIdLists =
        chunkedList(queryParameters.getId(), config.getMaxIdsPerRequest());
    log.log(
        Level.INFO,
        "Loadings {0} IDs in {1} chunks.",
        new Object[] {queryParameters.getId().size(), chunkedIdLists.size()});

    List<Item> resultItems = new ArrayList<>();
    for (List<Long> ids : chunkedIdLists) {
      queryParameters.setId(ids);
      String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), queryParameters);

      Items items = httpFetch.loadFromUrl(url, Items.class);
      resultItems.addAll(items.getItem());
    }

    return resultItems;
  }

  public List<List<Long>> chunkedList(List<Long> source, int length) {
    if (length <= 0) {
      throw new IllegalArgumentException("Invalid chunk size " + length);
    }

    int size = source.size();

    if (size <= 0) {
      return Collections.emptyList();
    }

    int fullChunks = (size - 1) / length;

    return IntStream.range(0, fullChunks + 1)
        .mapToObj(n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length))
        .toList();
  }
}
