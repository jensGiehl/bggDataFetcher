package de.agiehl.bgg.model.fortrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Textfield {

    private TextfieldObject comment;
    private TextfieldObject conditiontext;
    private TextfieldObject wantpartslist;
    private TextfieldObject haspartslist;
    private TextfieldObject wishlistcomment;
    private TextfieldObject customname;
}
