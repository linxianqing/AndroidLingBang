package lin.com.androidlingbang.http;

/**
 * Created by linxianqing on 2017/7/26.
 */

public class HttpResult<T> {
  private int resultCode;
  private String resultMessage;

  private T data;
}