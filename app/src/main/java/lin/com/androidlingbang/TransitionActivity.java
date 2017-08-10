package lin.com.androidlingbang;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lin.com.androidlingbang.base.FinallyActivity;
import lin.com.androidlingbang.dao.UserDao;
import lin.com.androidlingbang.entity.User;
import lin.com.androidlingbang.http.Result;
import lin.com.androidlingbang.util.ARouterUtil;
import lin.com.androidlingbang.util.Constant;
import lin.com.androidlingbang.util.EntityManager;
import lin.com.androidlingbang.util.HttpUtil;
import lin.com.androidlingbang.util.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 过渡Activity
 * 用来显示广告,请求网络数据 初始化数据,
 * Created by linxianqing on 2017/6/7.
 */
public class TransitionActivity extends FinallyActivity {

  /**
   * The M tv jump home.
   */
  @BindView(R.id.tv_jump_home)
  TextView mTvJumpHome;
  /**
   * The M activity transition.
   */
  @BindView(R.id.activity_transition)
  RelativeLayout mActivityTransition;
  /**
   * The Iv pic.
   */
  @BindView(R.id.iv_pic)
  ImageView ivPic;

  /**
   * 解决点击事件后重复加载问题
   */
  private boolean flag = false;
  /**
   * Disposable
   */
  private static Disposable mDisposable;


  @Override
  protected void initData() {

  }

  @Override
  protected void initView() {
    hideToolbar();
    User user = getUser();
    if (user == null) {
      EntityManager.getInstance().getUserDao().insert(new User(Long.valueOf(1), null));
      user = getUser();
    }

    if (user.getToken() == null) {
      ARouterUtil.toUrl("/lingbang/dologin");
      this.finish();
    } else {      //存在跳转首页
      //有tooken 发送后台进行验证
      Call<Result<User>> call = HttpUtil.getApiService().verifyTooken(user);
      call.enqueue(new Callback<Result<User>>() {
        @Override
        public void onResponse(@Nullable Call<Result<User>> call, @Nullable Response<Result<User>> response) {
          try {
            callMethod(response);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

        @Override
        public void onFailure(@Nullable Call<Result<User>> call, @Nullable Throwable t) {

        }
      });
    }
  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void getExtraParams() {

  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_transition;
  }


  /**
   * 调用方法
   *
   * @param response
   *         响应结果
   *
   * @throws IOException
   *         Exception
   */
  private void callMethod(Response<Result<User>> response) throws IOException {
    Result<User> user = response.body();
    int code = 0;
    if (user != null) {
      code = user.getCode();
    }
    if (code == Result.CLIENT_ERROR) {
      ToastUtils.showShortToast(user.getMsg());
    } else if (code == Result.OK) {
      //开发模式关闭屏幕广告 直接跳转首页
      if (BuildConfig.IS_DEBUG) {
        jumpHome();
        cancel();
      } else {
        ad(Constant.HREE);
      }
    }
  }

  /**
   * 获取用户数据
   *
   * @return 用户数据
   */
  private User getUser() {
    UserDao userDao = EntityManager.getInstance().getUserDao();
    return userDao.load((long) 1);
  }

  /**
   * 广告.
   *
   * @param adTime
   *         广告时间
   */
  private void ad(int adTime) {
    String jump = this.getString(R.string.jump);
    String s = this.getString(R.string.s);

    Observable.interval(0, 1, TimeUnit.SECONDS) //0延迟  每隔1秒触发
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())//操作UI主要在UI线程
            .take(adTime + 1) //设置循环次数
            .map(aLong -> adTime - aLong) //从60-1
            .subscribe(new Observer<Long>() {
              @Override
              public void onError(Throwable e) {
                e.printStackTrace();
                Logger.i("error");
              }

              @Override
              public void onComplete() {

              }

              @Override
              public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
              }

              @Override
              public void onNext(Long aLong) { //每隔一秒执行
                StringBuilder sb = new StringBuilder();
                StringBuilder str = sb.append(jump).append(aLong).append(s);
                String s1 = str.toString();
                mTvJumpHome.setText(s1);
                if (aLong == 0) {
                  jumpHome();
                  cancel();
                }
              }
            });
    mTvJumpHome.setOnClickListener(v -> {
      jumpHome();
      cancel();
    });
  }


  /**
   * 跳转首页
   */
  private void jumpHome() {
    if (!flag) {
      flag = true;
      ARouterUtil.toUrl("/linbang/main");
      this.finish();                  //销毁当前activity 否则会回退到广告页
    }
  }

  /**
   * 取消订阅
   */
  public static void cancel() {
    if (mDisposable != null && !mDisposable.isDisposed()) {
      mDisposable.dispose();
    }
  }
}
