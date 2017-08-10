package lin.com.androidlingbang.base;

import android.os.Bundle;

/**
 * Created by lin on 17-8-1.
 */

public abstract class ToolbarFragment extends BKBaseFragment {

    protected abstract void initToolbar();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolbar();
    }

    /**
     * @return fragment消费back键返回true, 反之返回false
     */
    public boolean onBackPressed() {
        return false;
    }

}
