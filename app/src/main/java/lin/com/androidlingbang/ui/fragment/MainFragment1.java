package lin.com.androidlingbang.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import lin.com.androidlingbang.R;
import lin.com.androidlingbang.adapter.MenuEntityAdapter;
import lin.com.androidlingbang.base.BKBaseFragment;
import lin.com.androidlingbang.data.DataServer;
import lin.com.androidlingbang.entity.MenuEntity;
import lin.com.androidlingbang.ui.activity.QrCodeGenerActivity;
import lin.com.androidlingbang.ui.activity.ScanCodeActivity;
import lin.com.androidlingbang.ui.activity.SearchActivity;
import lin.com.androidlingbang.util.ARouterUtil;

/**
 * @author :    linxianqin
 *         date:       17-8-3 下午4:56
 *         email:      linxianqinwork@qq.com
 */

@Route(path = "/lingbang/main")
public class MainFragment1 extends BKBaseFragment {

  /**
   * The constant REQUEST_CODE.
   */
  public static final int REQUEST_CODE = 111;
  /**
   * The M bbbbbb.
   */
  @BindView(R.id.bbbbbb)
  ImageView mBbbbbb;
  /**
   * The M f item 1 app bar.
   */
  @BindView(R.id.f_item1_app_bar)
  AppBarLayout mFItem1AppBar;
  /**
   * The M img shaomiao.
   */
  @BindView(R.id.img_shaomiao)
  ImageView mImgShaomiao;
  /**
   * The M img fukuang.
   */
  @BindView(R.id.img_fukuang)
  ImageView mImgFukuang;
  /**
   * The M img search.
   */
  @BindView(R.id.img_search)
  ImageView mImgSearch;
  /**
   * The M img zhaoxiang.
   */
  @BindView(R.id.img_zhaoxiang)
  ImageView mImgZhaoxiang;
  /**
   * The M recycler view 1.
   */
  @BindView(R.id.m_RecyclerView1)
  RecyclerView mRecyclerView1;
  /**
   * The M fi 1 toolbar 1.
   */
  @BindView(R.id.f_i1_toolbar1)
  View mFI1Toolbar1;
  /**
   * The M fi 1 toolbar 2.
   */
  @BindView(R.id.f_i1_toolbar2)
  View mFI1Toolbar2;
  /**
   * The M jump search.
   */
  @BindView(R.id.jump_search)
  ImageView mJumpSearch;
  /**
   * The M scan code.
   */
  @BindView(R.id.scan_code)
  RelativeLayout mScanCode;
  /**
   * The M qr code generated.
   */
  @BindView(R.id.qr_code_generated)
  RelativeLayout mQrCodeGenerated;

  /**
   * 文件名
   */
  private String fileName = "menulist.json";
  /**
   * 数据
   */
  private List<MenuEntity> data = new ArrayList<MenuEntity>();

  @Override
  protected void initView() {
    ui();
    initRecyclerView();
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void initToolbar() {
    setToolbarTitle(getString(R.string.home));
  }


  @Override
  protected int getLayoutId() {
    return R.layout.fragment_item1;
  }

  /**
   * ui操作
   */
  private void ui() {
    mFItem1AppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
      @Override
      public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//        System.out.println("当前偏移" + verticalOffset);
        if (verticalOffset == 0) {
          //张开
          mFI1Toolbar1.setVisibility(View.VISIBLE); //可见
          mFI1Toolbar2.setVisibility(View.GONE); //隐藏
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
          setToolbar2Alpha(255);
          //收缩
          mFI1Toolbar1.setVisibility(View.GONE);
          mFI1Toolbar2.setVisibility(View.VISIBLE);
        } else if (verticalOffset <= (-110)) {
          //收缩toolbar
          mFI1Toolbar1.setVisibility(View.GONE);
          mFI1Toolbar2.setVisibility(View.VISIBLE);
          if (verticalOffset <= (-360)) {
            setToolbar2Alpha(100);
          }
          scrollToPosition();
        }
      }
    });
  }

  /**
   * 初始化RecyclerView
   */
  private void initRecyclerView() {
    data = DataServer.getHomeMenuEntityData();
    mRecyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 4));

    BaseQuickAdapter homeAdapter = new MenuEntityAdapter(getActivity(), data);
    homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    homeAdapter.isFirstOnly(false); //关闭只加载一次,每次操作都加载动画
    //设置 宽度
    homeAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
      @Override
      public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return data.get(position).getSpanSize();
      }
    });
    mRecyclerView1.setAdapter(homeAdapter);

    homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {

      @Override
      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ARouterUtil.toUrl(data.get(position).getUrl());
      }
    });
  }

  /**
   * 让RecyclerView滚动到指定位置.
   */
  private void scrollToPosition() {
    ((LinearLayoutManager) mRecyclerView1.getLayoutManager())
            .scrollToPositionWithOffset(
                    0, 0);
  }

  /**
   * 设置闭合时各控件的透明度.
   *
   * @param alpha
   *         透明度
   */
  public void setToolbar2Alpha(int alpha) {
    mImgShaomiao.getDrawable().setAlpha(alpha);
    mImgFukuang.getDrawable().setAlpha(alpha);
    mImgSearch.getDrawable().setAlpha(alpha);
    mImgZhaoxiang.getDrawable().setAlpha(alpha);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    /**
     * 处理二维码扫描结果
     */
    Logger.t("二维码").i(String.valueOf(requestCode));
    if (requestCode == REQUEST_CODE) {
      //处理扫描结果（在界面上显示）
      if (null != data) {
        Bundle bundle = data.getExtras();
        if (bundle == null) {
          return;
        }
        if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
          String result = bundle.getString(CodeUtils.RESULT_STRING);
          Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
        } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
          Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
        }
      }
    }
  }

  /**
   * On cli.
   *
   * @param v
   *         the v
   */
  @OnClick({R.id.jump_search, R.id.scan_code, R.id.qr_code_generated})
  public void onCli(View v) {
    switch (v.getId()) {
      case R.id.jump_search:    //跳转搜索
        toActivity(SearchActivity.class);
        break;
      case R.id.scan_code:      //扫码
        toActivityForResult(ScanCodeActivity.class, REQUEST_CODE);
        break;
      case R.id.qr_code_generated:    //二维码生成
        ARouterUtil.toUrl("/linbang/qr_code_gener");
        break;
      default:
        break;
    }
  }

}
