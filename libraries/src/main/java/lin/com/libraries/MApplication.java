package lin.com.libraries;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 整个应用程序Applicaiton
 *
 * @author 曾繁添
 * @version 1.0
 */
public abstract class MApplication extends CrashApplication {

  /** 对外提供整个应用生命周期的Context. **/
  private static Context instance;
  /** 渠道ID. **/
  public static String channelId = "Ajava";
  /** 应用程序版本versionName. **/
  public static String version = "error";
  /** 设备ID. **/
  public static String deviceId = "error";
  /** 整个应用全局可访问数据集合. **/
  private static Map<String, Object> gloableData = new HashMap<String, Object>();
  /***寄存整个应用Activity.**/
  private final Stack<WeakReference<Activity>> activitys = new Stack<WeakReference<Activity>>();
  /** 日志输出标志. **/
  protected final String tag = this.getClass().getSimpleName();

  /**
   * 对外提供Application Context.
   */
  public static Context gainContext() {
    return instance;
  }

  /**
   * .
   */
  public void onCreate() {
    super.onCreate();
    instance = this;
    //    init();
  }

  /*******************************************************Application数据操作API.
   * （开始）********************************************************/

  /**
   * 往Application放置数据（最大不允许超过5个）.
   *
   * @param strKey   存放属性Key
   * @param strValue 数据对象
   */
  public static void assignData(String strKey, Object strValue) {
    if (gloableData.size() > 5) {
      throw new RuntimeException("超过允许最大数");
    }
    gloableData.put(strKey, strValue);
  }

  /**
   * 从Applcaiton中取数据.
   *
   * @param strKey 存放数据Key
   * @return 对应Key的数据对象
   */
  public static Object gainData(String strKey) {
    return gloableData.get(strKey);
  }

  /*
   * 从Application中移除数据
   */
  public static void removeData(String key) {
    if (gloableData.containsKey(key)) gloableData.remove(key);
  }

  /*******************************************************Application数据操作API
   * （结束）********************************************************/


  /*******************************************Application中存放的Activity操作（压栈/出栈）API
   * （开始）*****************************************/

  /**
   * 将Activity压入Application栈
   *
   * @param task 将要压入栈的Activity对象
   */
  public void pushTask(WeakReference<Activity> task) {
    activitys.push(task);
  }

  /**
   * 将传入的Activity对象从栈中移除
   */
  public void removeTask(WeakReference<Activity> task) {
    activitys.remove(task);
  }

  /**
   * 根据指定位置从栈中移除Activity
   *
   * @param taskIndex Activity栈索引
   */
  public void removeTask(int taskIndex) {
    if (activitys.size() > taskIndex) {
      activitys.remove(taskIndex);
    }
  }

  /**
   * 将栈中Activity移除至栈顶
   */
  public void removeToTop() {
    int end = activitys.size();
    int start = 1;
    for (int i = end - 1; i >= start; i--) {
      Activity mActivity = activitys.get(i).get();
      if (null != mActivity && !mActivity.isFinishing()) {
        mActivity.finish();
      }
    }
  }

  /**
   * 移除全部（用于整个应用退出）
   */
  public void removeAll() {
    //finish所有的Activity
    for (WeakReference<Activity> task : activitys) {
      Activity mActivity = task.get();
      if (null != mActivity && !mActivity.isFinishing()) {
        mActivity.finish();
      }
    }
  }

  /**
   * 退出整个APP，关闭所有activity/清除缓存等等
   */
  public abstract void exit();

  /*******************************************Application中存放的Activity操作（压栈/出栈）API
   * （结束）*****************************************/
}
