package de.agiehl.bgg.model.collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Status {

  @JacksonXmlProperty(isAttribute = true)
  private Short own;

  @JacksonXmlProperty(isAttribute = true)
  private Short prevowned;

  @JacksonXmlProperty(isAttribute = true)
  private Short fortrade;

  @JacksonXmlProperty(isAttribute = true)
  private Short want;

  @JacksonXmlProperty(isAttribute = true)
  private Short wanttoplay;

  @JacksonXmlProperty(isAttribute = true)
  private Short wanttobuy;

  @JacksonXmlProperty(isAttribute = true)
  private Short wishlist;

  @JacksonXmlProperty(isAttribute = true)
  private Short preordered;

  @JacksonXmlProperty(isAttribute = true)
  private String lastmodified;

  @JacksonXmlProperty(isAttribute = true)
  private Short wishlistpriority;

  public boolean isOwn() {
    return own == 1;
  }

  public boolean isPreviousOwned() {
    return prevowned == 1;
  }

  public boolean isForTrade() {
    return fortrade == 1;
  }

  public boolean isWantInTrade() {
    return want == 1;
  }

  public boolean isWantToPlay() {
    return wanttoplay == 1;
  }

  public boolean isWantToBuy() {
    return wanttobuy == 1;
  }

  public boolean isOnWishlist() {
    return wishlist == 1;
  }

  public boolean isPreOrdered() {
    return preordered == 1;
  }

  public boolean isWantedOrWished() {
    return isWantInTrade() || isWantToBuy() || isOnWishlist();
  }
}
