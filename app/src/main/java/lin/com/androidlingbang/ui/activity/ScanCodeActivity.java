package lin.com.androidlingbang.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import lin.com.androidlingbang.R;

/**
 * The type Scan code activity.
 */
public class ScanCodeActivity extends AppCompatActivity {
  private CaptureFragment captureFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scan_code);
    captureFragment = new CaptureFragment();
    // 为二维码扫描界面设置定制化界面
    CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
    captureFragment.setAnalyzeCallback(analyzeCallback);
    getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();

    initView();
  }

  /**
   * The constant isOpen.
   */
  public static boolean isOpen = false;

  private void initView() {
    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear1);
    linearLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!isOpen) {
          CodeUtils.isLightEnable(true);
          isOpen = true;
        } else {
          CodeUtils.isLightEnable(false);
          isOpen = false;
        }

      }
    });
  }


  /**
   * 二维码解析回调函数
   */
  CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
    @Override
    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
      Intent resultIntent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
      bundle.putString(CodeUtils.RESULT_STRING, result);
      resultIntent.putExtras(bundle);
      ScanCodeActivity.this.setResult(RESULT_OK, resultIntent);
      ScanCodeActivity.this.finish();
    }

    @Override
    public void onAnalyzeFailed() {
      Intent resultIntent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
      bundle.putString(CodeUtils.RESULT_STRING, "");
      resultIntent.putExtras(bundle);
      ScanCodeActivity.this.setResult(RESULT_OK, resultIntent);
      ScanCodeActivity.this.finish();
    }
  };
}
