package lin.com.androidlingbang.permissions;

/**
 * Created by linxianqing on 2017/6/28.
 */

public interface PermissionsResultListener {

  void onPermissionGranted();

  void onPermissionDenied();

}