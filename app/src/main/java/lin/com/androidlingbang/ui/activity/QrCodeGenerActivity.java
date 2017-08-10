package lin.com.androidlingbang.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import lin.com.androidlingbang.R;
import lin.com.androidlingbang.util.Constant;

/**
 * @author :    linxianqin
 * date:        17-8-3 下午5:16
 * email:       linxianqinwork@qq.com
 */

@Route(path = "/linbang/qr_code_gener")
public class QrCodeGenerActivity extends AppCompatActivity {

  /**
   * The M iv 1.
   */
  @BindView(R.id.iv1)
  ImageView mIv1;
  /**
   * The M tv 1.
   */
  @BindView(R.id.tv1)
  TextView mTv1;
  /**
   * The M mBitmap
   */
  private Bitmap mBitmap = null;

  /**
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_qr_code_gener);
    initView();
  }

  /**
   * 初始化组件
   */
  private void initView() {
    //text参数需要从接口中获取替换,先写死
    String text = "java开发";
    //生成二维码
    mBitmap = CodeUtils.createImage(text, Constant.WIDTH, Constant.HEIGHT, null);
    mIv1.setImageBitmap(mBitmap);
  }

}
