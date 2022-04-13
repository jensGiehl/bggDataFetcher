package de.agiehl.bgg.fetch;

import de.agiehl.bgg.model.thing.Item;
import de.agiehl.bgg.model.thing.Items;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Log
@AllArgsConstructor
public class ThingService {

    private final HttpFetch httpFetch;

    public List<Item> loadThings(Long... ids) {
        return chunkedList(Arrays.asList(ids), 100)
                .map(listOfIds -> listOfIds.stream().map(String::valueOf).collect(joining(",")))
                .map(this::loadThingsForIds)
                .flatMap(items -> items.getItem().stream())
                .collect(toList());
    }

    private Items loadThingsForIds(String idsAsString) {
        String url = "https://api.geekdo.com/xmlapi2/thing?marketplace=1&versions=1&videos=0&stats=1&comments=0&ratingcomments=0&id=" + idsAsString;

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
