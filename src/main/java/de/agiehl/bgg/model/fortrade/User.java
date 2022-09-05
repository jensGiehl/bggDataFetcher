package de.agiehl.bgg.model.fortrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String username;

    private String avatar;

    private String avatarfile;

    private String country;

    private String city;

    private String state;

    private String avatarurlMd;

    private List<Microbadges> microbadges;

    private String flagimgurl;

}
