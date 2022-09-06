package de.agiehl.bgg.service.collections;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollectionsQueryParameters {

    @Builder.Default
    private boolean includeversions = true;

    private Long objectid;

    @Builder.Default
    private String objecttype = "thing";

    @Builder.Default
    private int pageid = 1;

    @Builder.Default
    private int showcount = 50;

    private String status;

}
