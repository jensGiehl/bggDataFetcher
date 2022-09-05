package de.agiehl.bgg.service.fortrade;

import de.agiehl.bgg.config.ForTradeConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.fortrade.ForTrade;
import de.agiehl.bgg.service.common.UrlBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class ForTradeService {

    private final BggHttpClient httpFetch;

    private final ForTradeConfig config;

    public ForTrade loadForTrade(ForTradeQueryParameters parameters) {
        String url = UrlBuilder.getInstance().createUrlFromObject(config.getUrl(), parameters);

        ForTrade forTradeItems = httpFetch.loadJsonFromUrl(url, ForTrade.class);

        log.info(() -> String.format("For Trade for '%s' loaded", parameters.getObjectid()));

        return forTradeItems;
    }

}
