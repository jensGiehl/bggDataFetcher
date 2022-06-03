package de.agiehl.bgg.service.search;

import de.agiehl.bgg.service.common.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class SearchQueryParameters {

    /**
     * Returns all types of Items that match
     */
    @NonNull
    private String query;

    /**
     * Returns all items that match type
     */
    @Singular("type")
    private List<Type> type;

    /**
     * Limit results to items that match the {@link #query} exactly
     */
    private boolean exact;
}
