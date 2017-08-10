//package lin.com.androidlingbang.data;
//
//import android.content.Context;
//
//import org.greenrobot.greendao.query.QueryBuilder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import lin.com.androidlingbang.base.BaseDao;
//import lin.com.androidlingbang.entity.Account;
//
///**
// * Created by linxianqing on 2017/7/21.
// */
//
//public class AccountManager extends BaseDao<Account> {
//  public AccountManager(Context context) {
//    super(context);
//  }
//
//  /***************************数据库查询*************************/
//
//  /**
//   * 通过ID查询对象
//   * @param id
//   * @return
//   */
//  private Account loadById(long id){
//
//    return daoSession.getAccountDao().load(id);
//  }
//
//  /**
//   * 获取某个对象的主键ID
//   * @param Account
//   * @return
//   */
//  private long getID(Account Account){
//
//    return daoSession.getAccountDao().getKey(Account);
//  }
//
//  /**
//   * 通过名字获取Customer对象
//   * @return
//   */
//  private List<Account> getAccountByName(String key){
//    QueryBuilder queryBuilder =  daoSession.getAccountDao().queryBuilder();
//    queryBuilder.where(T.Properties.Name.eq(key));
//    int size = queryBuilder.list().size();
//    if (size > 0){
//      return queryBuilder.list();
//    }else{
//      return null;
//    }
//  }
//
//  /**
//   * 通过名字获取Customer对象
//   * @return
//   */
//  private List<Long> getIdByName(String key){
//    List<Account> Accounts = getAccountByName(key);
//    List<Long> ids = new ArrayList<Long>();
//    int size = Accounts.size();
//    if (size > 0){
//      for (int i = 0;i < size;i++){
//        ids.add(Accounts.get(i).getId());
//      }
//      return ids;
//    }else{
//      return null;
//    }
//  }
//
//  /***************************数据库删除*************************/
//
//  /**
//   * 根据ID进行数据库的删除操作
//   * @param id
//   */
//  private void deleteById(long id){
//
//    daoSession.getAccountDao().deleteByKey(id);
//  }
//
//
//  /**
//   * 根据ID同步删除数据库操作
//   * @param ids
//   */
//  private void deleteByIds(List<Long> ids){
//
//    daoSession.getAccountDao().deleteByKeyInTx(ids);
//  }
//
//  /***********************************
//   * 在次添加一些Account特有的数据库操作语句
//   * ************************************/
//
//}