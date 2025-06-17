package de.agiehl.bgg.model.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionsItems {

  private Long collid;

  private Long versionid;

  private Version version;

  private String objecttype;

  private Long objectid;

  private Long imageid;

  private Long publisherid;

  private Long languageid;

  private Integer year;

  private String other;

  private String barcode;

  private User user;

  private String objectname;

  private String sunglasses;

  private Status status;

  private String statusTstamp;

  private Integer wishlistpriority;

  private Textfield textfield;

  private String rating;

  private String ratingTstamp;

  private String tstamp;

  private String postdate;

  private String lastmodified;

  private String commentTstamp;

  private String reviewTstamp;
}
