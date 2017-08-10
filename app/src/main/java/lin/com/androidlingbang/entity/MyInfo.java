package lin.com.androidlingbang.entity;

/**
 * Created by linxianqing on 2017/7/31.
 */

public class MyInfo extends BaseEntity {
  /**
   * 头像图片,图标
   */
  private Integer icon;
  /**
   * 用户名称
   */
  private String username;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 跳转url
   */
  private String jumpUrl;

  private String headline;
  private String subtitle;


  @Override
  public String toString() {
    return "MyInfo{" +
            "icon=" + icon +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", jumpUrl='" + jumpUrl + '\'' +
            ", headline='" + headline + '\'' +
            ", subtitle='" + subtitle + '\'' +
            '}';
  }

  public MyInfo(int itemType, int spanSize) {
    super(itemType,spanSize);
  }

  public Integer getIcon() {
    return icon;
  }

  public void setIcon(Integer icon) {
    this.icon = icon;
  }



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getJumpUrl() {
    return jumpUrl;
  }

  public void setJumpUrl(String jumpUrl) {
    this.jumpUrl = jumpUrl;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }


  public MyInfo(Integer icon,  String username, String email, String jumpUrl,
          String headline, String subtitle) {
    this.icon = icon;

    this.username = username;
    this.email = email;
    this.jumpUrl = jumpUrl;
    this.headline = headline;
    this.subtitle = subtitle;

  }
}
