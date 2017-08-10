package lin.com.androidlingbang.ui.fragment;

import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.base.BKBaseFragment;
import lin.com.androidlingbang.entity.MenuEntity;


/**
 * @author linxianqinwork@qq.com
 */
public class MainFragment2 extends BKBaseFragment {
  /**
   * 数据源
   */
  private List<MenuEntity> data = new ArrayList<MenuEntity>();
  private WebView webView;

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_item2;
  }


  @Override
  protected void initView() {
    webView = (WebView) view.findViewById(R.id.webView);
    webView.loadUrl("http://baidu.com");
    //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
        view.loadUrl(url);
        return true;
      }
    });
    //启用支持javascript
    WebSettings settings = webView.getSettings();
    settings.setJavaScriptEnabled(true);
//    initRecyclerView();
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void initToolbar() {

  }
}
