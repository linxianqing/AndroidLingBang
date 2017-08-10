package lin.com.androidlingbang.util;

import com.blankj.utilcode.util.Utils;

import lin.com.androidlingbang.dao.DaoMaster;
import lin.com.androidlingbang.dao.DaoSession;

/**
 * greenDao管理类
 */
public class DaoManager {
  private static DaoManager mInstance;
  private DaoMaster mDaoMaster;
  private DaoSession mDaoSession;

  private DaoManager() {
    DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Utils.getContext(), "my-db",
            null);
    DaoMaster mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
    mDaoSession = mDaoMaster.newSession();
  }

  public DaoMaster getMaster() {
    return mDaoMaster;
  }

  public DaoSession getSession() {
    return mDaoSession;
  }

  public static DaoManager getInstance() {
    if (mInstance == null) {
      mInstance = new DaoManager();
    }
    return mInstance;
  }
}