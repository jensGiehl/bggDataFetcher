package de.agiehl.bgg.service.collection;

import de.agiehl.bgg.service.common.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CollectionQueryParameters {

    /**
     * Name of the user to request the collection for.
     */
    @NonNull
    private String username;

    /**
     * Returns version info for each item in your collection.
     */
    private Boolean version;

    /**
     * Specifies which collection you want to retrieve.
     */
    @Builder.Default
    private Type subType = Type.BOARDGAME;

    /**
     * Specifies which subtype you want to exclude from the results.
     */
    private Type excludeSubtype;

    /**
     * Filter collection to specifically listed item(s).
     */
    private List<Long> id;

    /**
     * Returns more abbreviated results.
     */
    private Boolean brief;

    /**
     * Returns expanded rating/ranking info for the collection.
     */
    private Boolean stats;

    /**
     * Filter for owned games.
     */
    private Boolean own;

    /**
     * Filter for whether an item has been rated.
     */
    private Boolean rated;

    /**
     * Filter for whether an item has been played.
     */
    private Boolean played;

    /**
     * Filter for items that have been commented.
     */
    private Boolean comment;

    /**
     * Filter for items marked for trade.
     */
    private Boolean trade;

    /**
     * Filter for items wanted in trade.
     */
    private Boolean want;

    /**
     * Filter for items on the wishlist.
     */
    private Boolean wishlist;

    /**
     * Filter for wishlist priority.
     */
    private Integer wishlistPriority;

    /**
     * Filter for pre-ordered games Returns only items of the specified priority.
     */
    private Boolean preOrdered;

    /**
     * Filter for items marked as wanting to play.
     */
    private Boolean wantToPlay;

    /**
     * Filter for ownership flag.
     */
    private Boolean wantToBuy;

    /**
     * Filter for games marked previously owned.
     */
    private Boolean previouslyOwned;

    /**
     * Filter on whether there is a comment in the Has Parts field of the item.
     */
    private Boolean hasParts;

    /**
     * Filter on whether there is a comment in the Wants Parts field of the item.
     */
    private Boolean wantParts;

    /**
     * Filter on minimum personal rating assigned for that item in the collection.
     */
    private Integer minRating;

    /**
     * Filter on maximum personal rating assigned for that item in the collection.
     */
    private Integer rating;

    /**
     * Filter on minimum BGG rating for that item in the collection.
     * Note: 0 is ignored... you can use -1 though, for example min -1 and max 1 to get items w/no bgg rating.
     */
    private Integer minBggRating;

    /**
     * Filter on maximum BGG rating for that item in the collection.
     */
    private Integer bggrating;

    /**
     * Filter by minimum number of recorded plays.
     */
    private Long minplays;

    /**
     * Filter by maximum number of recorded plays.
     */
    private Long maxplays;

    /**
     * Filter to show private collection info.
     * Only works when viewing your own collection, and you are logged in.
     */
    private Boolean showprivate;

    /**
     * Restrict the collection results to the single specified collection id.
     * Collid is returned in the results of normal queries as well.
     */
    private Long collectionId;

    /**
     * Restricts the collection results to only those whose status (own, want, fortrade, etc.)
     * has changed or been added since the date specified (does not return results for deletions).
     */
    private LocalDateTime modifiedSince;

}
