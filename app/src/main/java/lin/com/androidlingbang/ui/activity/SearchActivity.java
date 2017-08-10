package lin.com.androidlingbang.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;

import lin.com.androidlingbang.R;

/**
 * The type Search activity.
 *
 * @author linxianqinwork @qq.com
 */
@Route(path = "/lingbang/Search")
public class SearchActivity extends AppCompatActivity {
  /**
   * 回退
   */
  private ImageView back;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    back = (ImageView) findViewById(R.id.back);
    back.setOnClickListener(new SearchClickListener(back.getId()));
  }

  /**
   * 按钮点击监听.
   */
  class SearchClickListener implements View.OnClickListener {
    /**
     * 按钮id
     */
    private int buttonId;

    /**
     * Instantiates a new Search click listener.
     *
     * @param buttonId
     *         the button id
     */
    SearchClickListener(int buttonId) {
      this.buttonId = buttonId;
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()) {
        //返回上一个activity
        case R.id.back:
          finish(); //当你调用此方法的时候，系统只是将最上面的Activity移出了栈，
          break;
        case R.id.qr_code_generated:
          break;
        case R.id.jump_search:
          break;
//        case R.id.more:
//          break;
        default:
          break;
      }
    }
  }
}
