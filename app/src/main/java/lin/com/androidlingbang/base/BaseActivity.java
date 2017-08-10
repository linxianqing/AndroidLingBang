package lin.com.androidlingbang.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.util.ActivityManager;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by linxianqing on 2017/6/12.
 */
public abstract class BaseActivity extends AppCompatActivity implements EasyPermissions
        .PermissionCallbacks {
  protected static String TAG;
  private ImageView back;
  private TextView tv;
  private LinearLayout rootLayout;
  private Toolbar toolbar;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_base);
    initToolbar();
    init(savedInstanceState);
  }

  private void initToolbar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    back = (ImageView) findViewById(R.id.img_back);
    tv = (TextView) findViewById(R.id.title);
  }

  @Override
  public void setContentView(int layoutId) {
    setContentView(View.inflate(this, layoutId, null));
  }

  @Override
  public void setContentView(View view) {
    rootLayout = (LinearLayout) findViewById(R.id.root_layout);
    if (rootLayout == null) return;
    rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
    initToolbar();
  }

  /**
   * 隐藏头部back
   */
  protected void hideBack() {
    if (back != null) {
      back.setVisibility(View.GONE);
    }
  }

  /**
   * 隐藏头部toolbar
   */
  protected void hideToolbar() {
    if (toolbar != null) {
      toolbar.setVisibility(View.GONE);
    }
  }

  protected void setBackBtn() {
    if (back != null) {
      back.setVisibility(View.VISIBLE);
      back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
    } else {
      Logger.t(TAG).e("back is null ,please check out");
    }
  }

  /**
   * 设置当前 Activity 标题
   *
   * @param title
   */
  protected void setTitle(String title) {
    if (tv != null) {
      tv.setVisibility(View.VISIBLE);
      tv.setText(title);
    }
  }

  /**
   * 得到标签.
   *
   * @return tag
   */
  protected String getTag() {
    return this.getClass().getSimpleName();
  }

  protected void init(Bundle savedInstanceState) {
    TAG = getTag();
    setContentView(getLayoutId());
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//通过程序改变屏幕显示的方向
    ActivityManager.getInstance().addActivity(this);
    getExtraParams();
    initBK();
    initData();
    initView();
    saveInstanceState(savedInstanceState);
    initEvent();
  }

  /**
   * 初始化BK.
   */
  protected abstract void initBK();

  /**
   * 初始化数据.
   */
  protected abstract void initData();

  /**
   * 初始化布局.
   */
  protected abstract void initView();

  /**
   * 初始化事件.
   */
  protected abstract void initEvent();


  /**
   * 保存实例状态.
   */
  protected void saveInstanceState(Bundle savedInstanceState) {

    if (savedInstanceState == null) {
      return;
    }
    Logger.t(TAG).i("saveInstanceState: " + savedInstanceState);
  }


  /**
   * 获取从上一页面传递的参数.
   */
  protected abstract void getExtraParams();

  public void toActivity(Class clazz) {
    startActivity(new Intent(this, clazz));

  }

  /**
   * 获取布局文件Id.
   *
   * @return layoutId
   */
  protected abstract int getLayoutId();


}
