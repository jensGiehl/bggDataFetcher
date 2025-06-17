package de.agiehl.bgg;

import de.agiehl.bgg.config.BggConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.collection.CollectionItem;
import de.agiehl.bgg.model.collection.CollectionsItems;
import de.agiehl.bgg.model.collections.BggCollections;
import de.agiehl.bgg.model.play.Plays;
import de.agiehl.bgg.model.search.SearchItems;
import de.agiehl.bgg.model.thing.Item;
import de.agiehl.bgg.service.collection.CollectionQueryParameters;
import de.agiehl.bgg.service.collection.CollectionService;
import de.agiehl.bgg.service.collections.CollectionsQueryParameters;
import de.agiehl.bgg.service.collections.CollectionsService;
import de.agiehl.bgg.service.login.LoginCredentials;
import de.agiehl.bgg.service.login.LoginService;
import de.agiehl.bgg.service.play.PlayQueryParameters;
import de.agiehl.bgg.service.play.PlayService;
import de.agiehl.bgg.service.search.SearchQueryParameters;
import de.agiehl.bgg.service.search.SearchService;
import de.agiehl.bgg.service.thing.ThingQueryParameters;
import de.agiehl.bgg.service.thing.ThingService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.java.Log;

@Log
public class BggDataFetcher {

  private final BggHttpClient httpClient;

  private final LoginService loginService;

  private final CollectionService loadCollectionService;

  private final ThingService thingService;

  private final PlayService playService;

  private final SearchService searchService;

  private final CollectionsService collectionsService;

  public BggDataFetcher() {
    this(BggConfig.getDefault());
  }

  public BggDataFetcher(BggConfig bggConfig) {
    httpClient = new BggHttpClient(bggConfig.getHttpConfig());

    loginService = new LoginService(httpClient, bggConfig.getLoginConfig());
    loadCollectionService = new CollectionService(httpClient, bggConfig.getCollectionConfig());
    thingService = new ThingService(httpClient, bggConfig.getThingConfig());
    playService = new PlayService(httpClient, bggConfig.getPlayConfig());
    searchService = new SearchService(httpClient, bggConfig.getSearchConfig());
    collectionsService = new CollectionsService(httpClient, bggConfig.getCollectionsConfig());
  }

  public BggCollections loadCollections(Long objectid, String status) {
    return collectionsService.loadForTrade(
        CollectionsQueryParameters.builder().status(status).objectid(objectid).build());
  }

  public SearchItems search(String searchQuery) {
    return searchService.search(SearchQueryParameters.builder().query(searchQuery).build());
  }

  public SearchItems search(SearchQueryParameters parameters) {
    return searchService.search(parameters);
  }

  public List<Plays> loadPlaysForUser(String bggUsername) {
    return playService.loadPlays(PlayQueryParameters.builder().usernameOrId(bggUsername).build());
  }

  public List<Plays> loadPlays(PlayQueryParameters parameters) {
    return playService.loadPlays(parameters);
  }

  public List<Item> loadThings(Long... ids) {
    return thingService.loadThings(ThingQueryParameters.builder().id(Arrays.asList(ids)).build());
  }

  public List<Item> loadThings(ThingQueryParameters parameters) {
    return thingService.loadThings(parameters);
  }

  public List<Item> loadThingsWhichUserWantToHave(String bggUsername) {
    List<Long> boardgameIdsWhichUserWants =
        loadCollectionForUser(bggUsername).getItem().stream()
            .filter(item -> item.getStatus().isWantedOrWished())
            .map(CollectionItem::getObjectid)
            .toList();

    log.info(
        String.format(
            "Found %d Things that user %s wants", boardgameIdsWhichUserWants.size(), bggUsername));

    return loadThings(boardgameIdsWhichUserWants.toArray(new Long[] {}));
  }

  public BggDataFetcher login(LoginCredentials credentials) {
    loginService.login(credentials);
    return this;
  }

  public CollectionsItems loadCollectionForUser(String bggUsername) {
    return loadCollectionService.loadCollection(
        CollectionQueryParameters.builder().username(bggUsername).build());
  }

  public CollectionsItems loadCollection(CollectionQueryParameters parameters) {
    return loadCollectionService.loadCollection(parameters);
  }

  public CollectionService collection() {
    return loadCollectionService;
  }

  public ThingService thing() {
    return thingService;
  }

  public PlayService play() {
    return playService;
  }

  public SearchService search() {
    return searchService;
  }

  public CollectionsService collections() {
    return collectionsService;
  }
}
