package lin.com.androidlingbang;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import lin.com.androidlingbang.base.FinallyActivity;
import lin.com.androidlingbang.ui.fragment.MainFragment1;
import lin.com.androidlingbang.ui.fragment.MainFragment2;
import lin.com.androidlingbang.ui.fragment.MainFragment3;
import lin.com.androidlingbang.ui.fragment.MainFragment4;
import lin.com.androidlingbang.ui.helper.BottomNavigationViewHelper;
import lin.com.androidlingbang.util.Constant;
import lin.com.androidlingbang.util.Permissions;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static lin.com.androidlingbang.R.id.viewPager;

/**
 * The type Main activity.
 */
@Route(path = "/linbang/main")
public class MainActivity extends FinallyActivity implements ViewPager.OnPageChangeListener {
  /**
   * 请求CAMERA权限码
   */
  public static final int REQUEST_CAMERA_PERM = 101;

  /**
   * The M view pager.
   */
  @BindView(viewPager)
  ViewPager mViewPager;
  /**
   * The M navigation.
   */
  @BindView(R.id.navigation)
  BottomNavigationView mNavigation;
  /**
   * The M container.
   */
  @BindView(R.id.container)
  LinearLayout mContainer;
  /**
   * 首页
   */
  private MainFragment1 fragment1 = new MainFragment1();
  /**
   * 口碑
   */
  private MainFragment2 fragment2 = new MainFragment2();
  /**
   * 朋友
   */
  private MainFragment3 fragment3 = new MainFragment3();
  /**
   * 我的
   */
  private MainFragment4 fragment4 = new MainFragment4();


  @Override
  protected void initData() {
    initPermissions(); //初始化权限
  }

  @Override
  protected void initView() {
    hideToolbar();
    //添加viewPager事件监听（很容易忘）
    mViewPager.addOnPageChangeListener(this);
    BottomNavigationViewHelper.disableShiftMode(mNavigation);    //去掉BottomNavigationView的动画效果
    mNavigation.setOnNavigationItemSelectedListener(
            new MainActivityOnNavigationItemSelectedListener());
    mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int position) {
        switch (position) {
          case Constant.ZERO:
            return fragment1;
          case Constant.ONE:
            return fragment2;
          case Constant.TWO:
            return fragment3;
          case Constant.HREE:
            return fragment4;
          default:
            break;
        }
        return null;
      }

      @Override
      public int getCount() {
        return Constant.FOUR;
      }
    });
  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void getExtraParams() {

  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_main;
  }


  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

  }

  @Override
  public void onPageSelected(int position) {
    //页面滑动的时候，改变BottomNavigationView的Item高亮
    mNavigation.getMenu().getItem(position).setChecked(true);
  }

  @Override
  public void onPageScrollStateChanged(int state) {

  }

  /**
   * 导航点击事件:点击进行切换页面.
   */
  class MainActivityOnNavigationItemSelectedListener implements
          BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      //点击BottomNavigationView的Item项，切换ViewPager页面
      //menu/navigation.xml里加的android:orderInCategory属性就是下面item.getOrder()取的值
      mViewPager.setCurrentItem(item.getOrder());
      return true;
    }
  }

  //---------------权限控制 start-----------------------

  /**
   * 初始化权限
   */
  private void initPermissions() {
    cameraTask(); //获取相机权限
  }

  /**
   * 相机任务
   */
  @AfterPermissionGranted(Permissions.REQUEST_CAMERA_PERM)
  public void cameraTask() {
    if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) { // 有权限,做的事情!
      Toast.makeText(this, "获得相机权限", Toast.LENGTH_LONG).show();
    } else {   // 否则要求一个许可
      EasyPermissions.requestPermissions(this, "没有获得相机权限", Permissions.REQUEST_CAMERA_PERM,
              Manifest.permission.CAMERA);
    }
  }
  //---------------权限控制 end-----------------------

}
