package de.agiehl.bgg.model.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Microbadges {

    private Long badgeid;

    private Long userid;

    private String tstamp;

    private String active;

    private String url;

    private String slot;

    private Long id;

    private String name;

    private String filename;

    private String extension;

    private String animated;

    private String version;

    private String badgestatus;

    private String desc;

    private String mouseover;

    private String cost;

    @JsonProperty("private")
    private String privateFlag;

    private String customurl;

    private String baseurl;

    private String group;

    private String subgroup;

    private Long groupid;

    private String coupon;

    private String username;

    private Integer numsold;

    private String newfn;
}
