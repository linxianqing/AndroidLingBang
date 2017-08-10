package lin.com.androidlingbang.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by linxianqing on 2017/7/25.
 */
@Entity
public class User {
  @Id(autoincrement = true)
  private Long id;
  private String username;
  private String password;
  private String token;


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", token='" + token + '\'' +
            '}';
  }

  public User() {

  }
  @Generated(hash = 1607074747)
  public User(Long id, String username, String password, String token) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.token = token;
  }

  public User(Long id,String token) {
    this.id = id;
    this.token = token;
  }

  public User(String username, String password, String token) {
    this.username = username;
    this.password = password;
    this.token = token;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
