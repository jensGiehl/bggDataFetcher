package de.agiehl.bgg;

import de.agiehl.bgg.config.BggConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.httpclient.BggHttpClientException;
import de.agiehl.bgg.model.Credentials;
import de.agiehl.bgg.model.collection.Items;
import de.agiehl.bgg.model.collection.Subtypes;
import de.agiehl.bgg.model.play.Plays;
import de.agiehl.bgg.model.search.SearchItems;
import de.agiehl.bgg.model.thing.Item;
import de.agiehl.bgg.service.*;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.List;

@Getter
@Log
public class BggDataFetcher {

    private final BggHttpClient httpClient;

    private final LoginService loginService;

    private final CollectionService loadCollectionService;

    private final ThingService thingService;

    private final PlayService playService;

    private final SearchService searchService;

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
    }

    public SearchItems search(String searchQuery) {
        return searchService.search(searchQuery);
    }

    public List<Plays> loadPlayForUser(String bggUsername) {
        try {
            return playService.loadPlaysForBggUser(bggUsername);
        } catch (Exception e) {
            throw new BggHttpClientException(String.format("Couldn't load plays for user '%s'", bggUsername), e);
        }
    }

    public List<Item> loadThings(Long... ids) {
        return thingService.loadThings(ids);
    }

    public List<Item> loadThingsWhichUserWantToHave(String bggUsername) {
        List<Long> boardgameIdsWhichUserWants = loadBoardgameCollectionForUser(bggUsername)
                .getItem()
                .stream()
                .filter(item -> item.getStatus().isWantedOrWished())
                .map(de.agiehl.bgg.model.collection.Item::getObjectid)
                .toList();

        log.info(String.format("Found %d Things that user %s wants", boardgameIdsWhichUserWants.size(), bggUsername));

        return loadThings(boardgameIdsWhichUserWants.toArray(new Long[]{}));
    }

    public BggDataFetcher login(Credentials credentials) {
        try {
            loginService.login(credentials);
            return this;
        } catch (BggHttpClientException e) {
            throw new BggHttpClientException("Login for '" + credentials.getUsername() + "' failed!", e);
        }
    }

    public Items loadCollectionFromUser(String bggUsername, Subtypes type) {
        try {
            return loadCollectionService.loadCollectionOfBggUser(bggUsername, type);
        } catch (Exception e) {
            throw new BggHttpClientException(String.format("Couldn't load collection for user '%s'!", bggUsername), e);
        }
    }

    public Items loadBoardgameCollectionForUser(String bggUsername) {
        try {
            return loadCollectionService.loadCollectionOfBggUser(bggUsername, Subtypes.BOARDGAME);
        } catch (Exception e) {
            throw new BggHttpClientException(String.format("Couldn't load boardgame collection for user '%s'!", bggUsername), e);
        }
    }

}
