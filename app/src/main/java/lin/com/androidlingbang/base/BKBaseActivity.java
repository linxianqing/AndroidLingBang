package lin.com.androidlingbang.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * The type Bk base activity.
 *
 * @author :    linxianqin
 * date:        17-8-3 下午5:17 email:
 * linxianqinwork@qq.com
 */
public abstract class BKBaseActivity extends BaseActivity {

  private Unbinder unbinder;

  /**
   * 将initView()方法声明为final,不允许子类对该方法进行覆写已防止子类未调用super.initView()方法对view控件进行绑定
   */
  @Override
  protected void initBK() {
    unbinder = ButterKnife.bind(this);
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
