package lin.com.androidlingbang.base;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static lin.com.androidlingbang.MainActivity.REQUEST_CAMERA_PERM;

/**
 * 动态权限申请.
 */
public abstract class PBaseActivity extends BKBaseActivity {
  //在权限授予时触发
  @Override
  public void onPermissionsGranted(int requestCode, List<String> perms) {
    Logger.t(TAG).i("授权码:" + requestCode + ".授权对象:" + perms.toString());
  }

  //在权限否认时触发
  @Override
  public void onPermissionsDenied(int requestCode, List<String> perms) {
    Logger.t(TAG).i("否认码:" + requestCode + "否认对象:" + perms.toString());
    // (Optional) 检查用户是否否认有任何权限和检查“不会再问。
    // 这将显示一个对话框,指导他们在应用程序启用权限设置。
    Toast.makeText(this, "执行onPermissionsDenied()...", Toast.LENGTH_SHORT).show();
    if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
      new AppSettingsDialog.Builder(this, "当前App需要申请照相机权限,需要打开设置页面么?")
              .setTitle("权限申请")
              .setPositiveButton("确认")
              .setNegativeButton("取消", null /* click listener */)
              .setRequestCode(REQUEST_CAMERA_PERM)
              .build()
              .show();
    }
  }

  //请求权限的结果
  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
          @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    //简单的权限处理该请求的结果。
    EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
  }

}
