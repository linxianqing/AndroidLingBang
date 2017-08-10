package lin.com.androidlingbang.util;

import android.support.annotation.NonNull;

import lin.com.androidlingbang.http.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Http util.
 *
 * @author linxianqinwork @qq.com
 */
public final class HttpUtil {
  private HttpUtil() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * The Interceptor.
   */
  static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
  /**
   * 基础url
   */
  private static String baseUrl = "http://192.168.43.44:3000/";

  /**
   * 建立日志拦截器
   *
   * @return the logging interceptor
   */
  public static HttpLoggingInterceptor getLoggingInterceptor() {
    return interceptor;
  }

  /**
   * Gets ok http client.
   *
   * @return the ok http client
   */
  @NonNull
  public static OkHttpClient getOkHttpClient() {
    return new OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
//            .addInterceptor(sInterceptor)
            .build();
  }

  /**
   * Gets api service.
   *
   * @return the api service
   */
  @NonNull
  public static ApiService getApiService() {
    return HttpUtil.getRetrofit1(getOkHttpClient()).create(ApiService.class);
  }

  /**
   * Gets retrofit 1.
   *
   * @param client
   *         the client
   *
   * @return the retrofit 1
   */
  @NonNull
  public static Retrofit getRetrofit1(OkHttpClient client) {

    return new Retrofit.Builder()
            .baseUrl(baseUrl)
            //在此之前2.0.0，默认的转换器是一个gson转换器，但是2.0.0默认的转换器是ResponseBody。
            //  https://stackoverflow.com/questions/32367469/unable-to-create-converter-for-my-class-in-android-retrofit-library
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
  }

  /**
   * Gets retrofit.
   *
   * @param client
   *         the client
   * @param url
   *         the url
   *
   * @return the retrofit
   */
  @NonNull
  public static Retrofit getRetrofit(OkHttpClient client, String url) {
    return new Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .build();
  }

}
