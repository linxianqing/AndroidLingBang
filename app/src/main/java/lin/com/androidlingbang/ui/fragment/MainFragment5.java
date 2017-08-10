package lin.com.androidlingbang.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import lin.com.androidlingbang.R;


/**
 * @author linxianqinwork@qq.com
 */
@Route(path = "/test/fragment")
public class MainFragment5 extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
          savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_item5, null);
    return view;
  }
}
