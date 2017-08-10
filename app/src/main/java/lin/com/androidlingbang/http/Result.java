package lin.com.androidlingbang.http;


/**
 * Created by linxianqing on 2017/7/26.
 *
 * @param <T>
 *         the type parameter
 */
public class Result<T> {
  /**
   * 请求成功
   */
  public static final int OK = 200;
  /**
   * 客户端请求参数有误
   */
  public static final int CLIENT_ERROR = 400;
  /**
   * 服务器错误
   */
  public static final int SERVER_ERROR = 500;

  /**
   * 状态码
   */
  private int code;
  /**
   * 消息
   */
  private String msg;
  /**
   * 数据
   */
  private T data;

  @Override
  public String toString() {
    return "Result{" +
            "code=" + code +
            ", msg='" + msg + '\'' +
            ", data=" + data +
            '}';
  }

  /**
   * Instantiates a new Result.
   */
  public Result() {
  }

  /**
   * Instantiates a new Result.
   *
   * @param code
   *         the code
   * @param msg
   *         the msg
   * @param data
   *         the data
   */
  public Result(int code, String msg, T data) {

    this.code = code;
    this.msg = msg;
    this.data = data;

  }

  /**
   * Gets code.
   *
   * @return the code
   */

  public int getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code
   *         the code
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * Gets msg.
   *
   * @return the msg
   */
  public String getMsg() {
    return msg;
  }

  /**
   * Sets msg.
   *
   * @param msg
   *         the msg
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data
   *         the data
   */
  public void setData(T data) {
    this.data = data;
  }

}
