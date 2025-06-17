package de.agiehl.bgg.model.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

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
