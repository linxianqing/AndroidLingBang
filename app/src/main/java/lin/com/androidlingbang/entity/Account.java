package lin.com.androidlingbang.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author linxianqinwork@qq.com
 */
@Entity
public class Account {
  /**
   * 账户id
   */
  @Id(autoincrement = true)
  private Long id;
  /**
   * 用户标志
   */
  private String userssign;

  /**
   * Instantiates a new Account.
   */
  public Account() {
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", userssign='" + userssign + '\'' +
            '}';
  }

  @Generated(hash = 1542985971)
  public Account(Long id, String userssign) {
      this.id = id;
      this.userssign = userssign;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return this.id;
  }


  /**
   * Sets id.
   *
   * @param id
   *         the id
   */
  public void setId(Long id) {
    this.id = id;
  }


  /**
   * Gets userssign.
   *
   * @return the userssign
   */
  public String getUserssign() {
    return this.userssign;
  }


  /**
   * Sets userssign.
   *
   * @param userssign
   *         the userssign
   */
  public void setUserssign(String userssign) {
    this.userssign = userssign;
  }
}
