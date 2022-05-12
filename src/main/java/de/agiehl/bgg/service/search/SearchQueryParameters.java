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

    @NonNull
    private String query;

    @Singular
    private List<Type> types;

    private boolean exact;
}
