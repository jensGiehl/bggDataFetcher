package de.agiehl.bgg.service.thing;

import de.agiehl.bgg.config.ThingConfig;
import de.agiehl.bgg.httpclient.BggHttpClient;
import de.agiehl.bgg.model.thing.Item;
import de.agiehl.bgg.model.thing.Items;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Log
@AllArgsConstructor
public class ThingService {

    private final BggHttpClient httpFetch;

    private final ThingConfig config;

    public List<Item> loadThings(Long... ids) {
        log.log(Level.FINE, "Loading {0} things", ids.length);

        return chunkedList(Arrays.asList(ids), 100)
                .map(listOfIds -> listOfIds.stream().map(String::valueOf).collect(joining(",")))
                .map(this::loadThingsForIds)
                .flatMap(items -> items.getItem().stream())
                .collect(toList());
    }

    private Items loadThingsForIds(String idsAsString) {
        log.log(Level.INFO, "Loading following things: {0}", idsAsString);
        String url = config.getUrl(idsAsString);

        return httpFetch.loadFromUrl(url, Items.class);
    }

    public static <T> Stream<List<T>> chunkedList(List<T> source, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid chunk size " + length);
        }

        int size = source.size();

        if (size <= 0) {
            return Stream.empty();
        }

        int fullChunks = (size - 1) / length;

        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }

}
