package lin.com.androidlingbang.http;

import io.reactivex.Observable;
import lin.com.androidlingbang.entity.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 配置请求参数的接口
 */
public interface ApiService {
  @GET("webservice/Base/UserInfo.asmx/Login6")
    //请求方式为GET，参数为webservice/Base/UserInfo.asmx/Login6，
  Observable<String> logining(@Query("username") String username,
          @Query("password") String password);  //传入username 、password两个参数.

  //

  /**
   * 聚合数据 以?拼接url 使用示例
   * http://v.juhe.cn/historyWeather/province?key=50279569f3cac6d0bfdae059f2d23524
   *
   * http://v.juhe.cn/ 为baseUrl baseUrl必须以/结尾   否则报错
   *
   * key=50279569f3cac6d0bfdae059f2d23524 == @Query("key").
   */
  @GET("historyWeather/province?")
  Call<ResponseBody> getTopMovie(@Query("key") String key);

  //  @FormUrlEncoded
  @POST("users/doLogin/")
//  @Headers({"Content-Type:application/json", "Accept: application/json"})
//  @Headers({"apikey:81bf9da930c7f9825a3c3383f1d8d766" ,"Content-Type:application/json"})
//  Call<ResponseBody> doLogin(@FieldMap Map<String, Object> params);
  Call<Result<User>> doLogin(@Body User user);

  @POST("users/verify/")
  Call<Result<User>> verifyTooken( @Body User user);

}

