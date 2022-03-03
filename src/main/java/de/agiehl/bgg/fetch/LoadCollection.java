package de.agiehl.bgg.fetch;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import de.agiehl.bgg.model.collection.Items;
import de.agiehl.bgg.model.collection.Subtypes;
import lombok.extern.java.Log;

@Log
public class LoadCollection {

	public Items loadCollectionOfBggUser(String username, Subtypes type) throws Exception {
		String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
		String url = "https://api.geekdo.com/xmlapi2/collection?version=1&stats=1&showprivate=1&username="
				+ encodedUsername + "&subtype=" + type.name().toLowerCase();

		String content = new HttpFetch().loadFromUrl(url);

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		log.info(() -> String.format("Collection for %s loaded", username));

		return xmlMapper.readValue(content, Items.class);
	}

	public List<Items> loadCollectionForAllSubtypesOfBggUser(String username) throws Exception {
		List<Items> result = new ArrayList<>();

		for (Subtypes subtype : Subtypes.values()) {
			result.add(loadCollectionOfBggUser(username, subtype));
		}

		return result;
	}

}
