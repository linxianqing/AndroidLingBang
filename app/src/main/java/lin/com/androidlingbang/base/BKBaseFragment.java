package lin.com.androidlingbang.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by linxianqing on 2017/6/27.
 */

public abstract class BKBaseFragment extends BaseFragment {
  private Unbinder unbinder;



  @Override
  final protected void initBK() {
    unbinder = ButterKnife.bind(this, view);
  }

  @Override
  protected void DestroyBK() {
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
