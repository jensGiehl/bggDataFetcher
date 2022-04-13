package de.agiehl.bgg;

import de.agiehl.bgg.config.HttpConfig;
import de.agiehl.bgg.fetch.*;
import de.agiehl.bgg.model.Credentials;
import de.agiehl.bgg.model.collection.Items;
import de.agiehl.bgg.model.collection.Subtypes;
import de.agiehl.bgg.model.thing.Item;
import lombok.Getter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Getter
@Log
public class BggDataFetcher {

    private final HttpConfig httpConfig;

    private final HttpFetch httpFetch;

    private final Login loginService;

    private final LoadCollection loadCollectionService;

    private final ThingService thingService;

    public BggDataFetcher(HttpConfig httpConfig) {
        this.httpConfig = httpConfig;

        httpFetch = new HttpFetch(httpConfig.getHttpTimeout(), httpConfig.getMaxRetries());

        loginService = new Login(httpFetch);
        loadCollectionService = new LoadCollection(httpFetch);
        thingService = new ThingService(httpFetch);
    }


    public List<Item> loadThings(Long... ids) {
        return thingService.loadThings(ids);
    }

    public BggDataFetcher login(Credentials credentials) {
        try {
            loginService.login(credentials);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Items loadCollectionFromUser(String bggUsername, Subtypes type) {
        try {
            return loadCollectionService.loadCollectionOfBggUser(bggUsername, type);
        } catch (Exception e) {
            throw new BggFetchException(String.format("Couldn't load collection for user '%s'!", bggUsername), e);
        }
    }

    public Items loadBoardgameCollectionForUser(String bggUsername) {
        try {
            return loadCollectionService.loadCollectionOfBggUser(bggUsername, Subtypes.BOARDGAME);
        } catch (Exception e) {
            throw new BggFetchException(String.format("Couldn't load boardgame collection for user '%s'!", bggUsername), e);
        }
    }

}
