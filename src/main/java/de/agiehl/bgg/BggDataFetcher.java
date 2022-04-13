package de.agiehl.bgg;

import de.agiehl.bgg.config.HttpConfig;
import de.agiehl.bgg.fetch.*;
import de.agiehl.bgg.model.Credentials;
import de.agiehl.bgg.model.collection.Items;
import de.agiehl.bgg.model.collection.Subtypes;
import de.agiehl.bgg.model.thing.Item;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.List;

@Getter
@Log
public class BggDataFetcher {

    private final HttpConfig httpConfig;

    private final BggHttpClient httpFetch;

    private final LoginService loginService;

    private final CollectionService loadCollectionService;

    private final ThingService thingService;

    public BggDataFetcher(HttpConfig httpConfig) {
        this.httpConfig = httpConfig;

        httpFetch = new BggHttpClient(httpConfig.getHttpTimeout(), httpConfig.getMaxRetries());

        loginService = new LoginService(httpFetch);
        loadCollectionService = new CollectionService(httpFetch);
        thingService = new ThingService(httpFetch);
    }


    public List<Item> loadThings(Long... ids) {
        return thingService.loadThings(ids);
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
