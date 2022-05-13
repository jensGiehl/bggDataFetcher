package de.agiehl.bgg.service.collection;

import de.agiehl.bgg.config.CollectionConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.collection.CollectionsItems;
import de.agiehl.bgg.model.collection.Subtypes;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Log
@AllArgsConstructor
public class CollectionService {

	private final BggHttpClient httpFetch;

	private final CollectionConfig config;

	public CollectionsItems loadCollectionOfBggUser(CollectionQueryParameters parameters) {
		return null;
	}

	public CollectionsItems loadCollectionOfBggUser(String username, Subtypes type) throws Exception {
		String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
		String url = "https://boardgamegeek.com/xmlapi2/collection?version=1&stats=1&showprivate=1&username="
				+ encodedUsername + "&subtype=" + type.name().toLowerCase();

		CollectionsItems items = httpFetch.loadFromUrl(url, CollectionsItems.class);

		log.info(() -> String.format("Collection for %s loaded", username));

		return items;
	}

	public Map<Subtypes, CollectionsItems> loadCollectionForAllSubtypesOfBggUser(String username) throws Exception {
		HashMap<Subtypes, CollectionsItems> result = new HashMap<>(Subtypes.values().length);

		for (Subtypes subtype : Subtypes.values()) {
			result.put(subtype, loadCollectionOfBggUser(username, subtype));
		}

		return result;
	}

}
