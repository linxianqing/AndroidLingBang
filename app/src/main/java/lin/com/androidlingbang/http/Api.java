//package lin.com.androidlingbang.http;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import retrofit2.Retrofit;
//
//public class Api {
//  //单例模式获取ApiService
//  private volatile static Api INSTANCE;
//  private final ApiService apiService;
//  //头部验证信息
//  Interceptor headerInterceptor =new Interceptor() {
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//      Request build = chain.request().newBuilder()
//              .addHeader("Content-Type", "application/x-www-form-urlencoded")//配置头部信息
//              .build();
//      return chain.proceed(build);
//    }
//  };
//
//  private Api(){
//    //配置OKhttp请求参数
//    OkHttpClient okHttp= new OkHttpClient.Builder()
//            .readTimeout(7676, TimeUnit.MILLISECONDS)
//            .connectTimeout(7676, TimeUnit.MILLISECONDS)
//            .addInterceptor(headerInterceptor)    //添加头部信息
//            .build();
//
//    Retrofit retrofit = new Retrofit.Builder()
//            //关联OKhttp
//            .client(okHttp)
//            //设置请求回来的数据为Gson
//            //.addConverterFactory(GsonConverterFactory.create())
//            //设置service接口可以作为Observable返回
//
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            //设置请求回来的数据为String，可以添加其他的适配器Gson.xml等7种,自动转化
//            .addConverterFactory(ScalarsConverterFactory.create())
//            //添加基础url
//            .baseUrl("http://"+"192.168.10.66:8081/")
//            .build();
//    //建立apiService
//    apiService = retrofit.create(ApiService.class);
//  }
//
//  /**
//   * 单例模式获取网络请求基类retrofit的service
//   * @return 单例ApiService
//   */
//  public static ApiService getInstance() {
//    if (INSTANCE == null) {
//      synchronized (Api.class) {
//        if (INSTANCE == null) {
//          INSTANCE = new Api();
//        }
//      }
//    }
//    return INSTANCE.apiService;
//  }
//}
