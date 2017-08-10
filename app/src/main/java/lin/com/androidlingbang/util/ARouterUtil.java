package lin.com.androidlingbang.util;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by linxianqing on 2017/7/14.
 */

public class ARouterUtil {

  private ARouterUtil() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * 跳转地址.
   * @param url 地址字符串
   */
  public static void toUrl(String url) {
    ARouter.getInstance()
            .build(url)
            .navigation();
  }
}
