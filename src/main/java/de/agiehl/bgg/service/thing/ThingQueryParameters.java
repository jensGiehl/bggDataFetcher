package de.agiehl.bgg.service.thing;

import de.agiehl.bgg.service.common.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ThingQueryParameters {

    /**
     * Specifies the id of the thing(s) to retrieve.
     */
    @NonNull
    @Singular
    private List<Long> ids;

    /**
     * Specifies that, regardless of the type of thing asked for by id, the results are filtered by the {@link #types} specified.
     */
    @Singular
    private List<Type> types;

    /**
     * Returns version info for the item.
     */
    private Boolean versions;

    /**
     * Returns videos for the item.
     */
    private Boolean videos;

    /**
     * Returns ranking and rating stats for the item.
     */
    private Boolean stats;

    /**
     * Returns marketplace data.
     */
    private Boolean marketplace;

    /**
     * Returns all comments about the item. Also includes ratings when commented.
     */
    private Boolean comments;

    /**
     * Returns all ratings for the item. Also includes comments when rated.
     */
    private Boolean ratingComments;

}
