package lin.com.androidlingbang.util;


import lin.com.androidlingbang.dao.AccountDao;
import lin.com.androidlingbang.dao.UserDao;

public class EntityManager {
  private static EntityManager entityManager;
  public AccountDao mAccountDao;
  public UserDao mUserDao;

  /**
   * 创建Account表实例
   */
  public AccountDao getAccountDao() {
    mAccountDao = DaoManager.getInstance().getSession().getAccountDao();
    return mAccountDao;
  }
  /**
   * 创建User表实例
   */
  public UserDao getUserDao() {
    mUserDao = DaoManager.getInstance().getSession().getUserDao();
    return mUserDao;
  }

  /**
   * 创建单例
   */
  public static EntityManager getInstance() {
    if (entityManager == null) {
      entityManager = new EntityManager();
    }
    return entityManager;
  }
}  