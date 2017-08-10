package lin.com.androidlingbang.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.io.IOException;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.dao.UserDao;
import lin.com.androidlingbang.entity.User;
import lin.com.androidlingbang.http.Result;
import lin.com.androidlingbang.util.ARouterUtil;
import lin.com.androidlingbang.util.EntityManager;
import lin.com.androidlingbang.util.HttpUtil;
import lin.com.androidlingbang.util.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
@Route(path = "/lingbang/dologin")
public class LoginActivity extends AppCompatActivity {
  /**
   * 用户名
   */
  private AutoCompleteTextView mUsername;
  /**
   * 密码
   */
  private EditText mPassword;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mUsername = (AutoCompleteTextView) findViewById(R.id.username);
    mPassword = (EditText) findViewById(R.id.password);

    Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
    mSignInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        attemptLogin();
      }
    });
  }

  /**
   * 尝试登录
   */
  private void attemptLogin() {
    doLogin();
  }

  /**
   * 登录方法
   */
  private void doLogin() {
    Call<Result<User>> call = HttpUtil.getApiService().doLogin(
            new User(mUsername.getText().toString(), mPassword.getText().toString()));
    call.enqueue(new Callback<Result<User>>() {
      @Override
      public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
        try {
          callMethod(response);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<Result<User>> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }

  /**
   * 请求方法
   *
   * @param response
   *         返回值
   *
   * @throws IOException
   *         错误
   */
  private void callMethod(Response<Result<User>> response) throws IOException {
    Result<User> user = response.body();
    if (user.getCode() == Result.OK) {
      switch (user.getMsg()) {
        case "登录成功":
          String tooken = user.getData().getToken();
          UserDao userDao = EntityManager.getInstance().getUserDao();
          userDao.update(new User((long) 1, tooken));
          ARouterUtil.toUrl("/linbang/main");
          this.finish();
          break;
      }
      ToastUtils.showShortToast(user.getMsg());
    } else if (user.getCode() == Result.CLIENT_ERROR) {
      ToastUtils.showShortToast(user.getMsg());
    } else {
      ToastUtils.showShortToast("请求发送失败");
    }

  }
}
