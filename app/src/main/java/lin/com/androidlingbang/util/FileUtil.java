package lin.com.androidlingbang.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by linxianqing on 2017/7/11.
 */

public class FileUtil {

  private FileUtil() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * 根据文件名得到json
   * @param context 上下文
   * @param fileName 文件名
   * @return
   */
  public static String getJson(Context context, String fileName) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      AssetManager assetManager = context.getAssets();
      BufferedReader bf = new BufferedReader(new InputStreamReader(
              assetManager.open(fileName)));
      String line;
      while ((line = bf.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
      Logger.e(e.toString());
    }
    return stringBuilder.toString();
  }
}
