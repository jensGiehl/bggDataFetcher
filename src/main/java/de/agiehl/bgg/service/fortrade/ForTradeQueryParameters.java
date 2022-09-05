package de.agiehl.bgg.service.fortrade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForTradeQueryParameters {

    @Builder.Default
    private boolean includeversions = true;

    private Long objectid;

    @Builder.Default
    private String objecttype = "thing";

    @Builder.Default
    private int pageid = 1;

    @Builder.Default
    private int showcount = 500;

    @Builder.Default
    private String status = "fortrade";

}
