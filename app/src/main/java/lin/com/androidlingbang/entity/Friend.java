package lin.com.androidlingbang.entity;

/**
 * Created by lin on 17-8-1.
 */
public class Friend extends BaseEntity {
  /**
   * 图标
   */
  private Integer icon;
  /**
   * 大标题
   */
  private String headline;

  /**
   * 副标题
   */
  private String subheading;

  /**
   * 时间
   */
  private String time;

  /**
   * url
   */
  private String url;

  /**
   * Instantiates a new Friend.
   *
   * @param itemType
   *         the item type
   * @param spanSize
   *         the span size
   */
  public Friend(int itemType, int spanSize) {
    super(itemType, spanSize);
  }


  @Override
  public String toString() {
    return "Friend{" +
            "icon=" + icon +
            ", headline='" + headline + '\'' +
            ", subheading='" + subheading + '\'' +
            ", time='" + time + '\'' +
            ", url='" + url + '\'' +
            '}';
  }

  /**
   * Instantiates a new Friend.
   */
  public Friend() {
  }

  /**
   * Instantiates a new Friend.
   *
   * @param icon
   *         the icon
   * @param headline
   *         the headline
   * @param subheading
   *         the subheading
   * @param time
   *         the time
   * @param url
   *         the url
   */
  public Friend(Integer icon, String headline, String subheading, String time, String url) {

    this.icon = icon;
    this.headline = headline;
    this.subheading = subheading;
    this.time = time;
    this.url = url;
  }

  /**
   * Gets icon.
   *
   * @return the icon
   */
  public Integer getIcon() {
    return icon;
  }

  /**
   * Sets icon.
   *
   * @param icon
   *         the icon
   */
  public void setIcon(Integer icon) {
    this.icon = icon;
  }

  /**
   * Gets headline.
   *
   * @return the headline
   */
  public String getHeadline() {
    return headline;
  }

  /**
   * Sets headline.
   *
   * @param headline
   *         the headline
   */
  public void setHeadline(String headline) {
    this.headline = headline;
  }

  /**
   * Gets subheading.
   *
   * @return the subheading
   */
  public String getSubheading() {
    return subheading;
  }

  /**
   * Sets subheading.
   *
   * @param subheading
   *         the subheading
   */
  public void setSubheading(String subheading) {
    this.subheading = subheading;
  }

  /**
   * Gets time.
   *
   * @return the time
   */
  public String getTime() {
    return time;
  }

  /**
   * Sets time.
   *
   * @param time
   *         the time
   */
  public void setTime(String time) {
    this.time = time;
  }

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets url.
   *
   * @param url
   *         the url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
