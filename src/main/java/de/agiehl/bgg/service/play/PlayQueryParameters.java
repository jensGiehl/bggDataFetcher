package de.agiehl.bgg.service.play;

import de.agiehl.bgg.service.common.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
public class PlayQueryParameters {

    /**
     * Name of the player you want to request play information for. Data is returned in backwards-chronological form.
     */
    @NonNull
    private String usernameOrId;

    /**
     * Type of the item you want to request play information for.
     */
    private PlayType type;

    /**
     * Returns only plays of the specified date or later.
     */
    private LocalDate minDate;

    /**
     * Returns only plays of the specified date or earlier.
     */
    private LocalDate maxdate;

    /**
     * Limits play results to the specified type
     */
    private Type subType;


    public enum PlayType {
        THING, FAMILY
    }

}
