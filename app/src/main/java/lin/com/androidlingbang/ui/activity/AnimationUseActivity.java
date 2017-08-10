package lin.com.androidlingbang.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import lin.com.androidlingbang.R;

/**
 * Created by linxianqing on 2017/7/5.
 */

@Route(path = "/test/activity")
public class AnimationUseActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.animationuseactivity_test);
  }

}