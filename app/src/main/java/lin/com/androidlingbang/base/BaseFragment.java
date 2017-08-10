package lin.com.androidlingbang.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.Unbinder;
import lin.com.androidlingbang.R;

/**
 * Created by linxianqing on 2017/6/22.
 */

public abstract class BaseFragment extends Fragment {
  protected Context mContext;
  protected View view;
  protected String TAG;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {
    view = inflater.inflate(getLayoutId(), container, false);
    mContext = getContext();
    init(savedInstanceState);
    return view;
  }

  @Override
  public void onResume() {
    super.onResume();
//    MobclickAgent.onPageStart(getPageName());//友盟
  }

  @Override
  public void onPause() {
    super.onPause();
//    MobclickAgent.onPageEnd(getPageName());
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    DestroyView();
  }


  protected void DestroyView() {
    DestroyBK();
  }

  protected abstract void DestroyBK();


  private Unbinder unbinder;

  protected abstract void initBK();

  protected abstract void initView();

  protected abstract void initData();

  protected abstract void initEvent();
  protected abstract void initToolbar();

  /**
   * 获取布局文件Id.
   *
   * @return layoutId
   */
  protected abstract int getLayoutId();

  protected void init(Bundle savedInstanceState) {
    TAG = getPageName();
    initBK();
    initView();
    initData();
    saveInstanceState(savedInstanceState);
    initEvent();
  }
  protected <V extends View> V getView(int id) {
    return (V) view.findViewById(id);
  }
  private TextView mTitle;

  protected void setToolbarTitle(String title) {
    mTitle = getView(R.id.title1);
    mTitle.setText(title);
  }
  protected void setToolbarTitle(int resId) {
    setToolbarTitle(getString(resId));
  }

  protected void saveInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState == null)
      return;
    Logger.d(TAG, "saveInstanceState: " + savedInstanceState);
  }
  protected String getPageName() {
    return this.getClass().getSimpleName();
  }


  public void toActivity(Class clazz) {
    startActivity(new Intent(getActivity(), clazz));
  }

  public void toActivityForResult(Class clazz, int statusCode) {
    startActivityForResult(new Intent(getActivity(), clazz), statusCode);
  }

}