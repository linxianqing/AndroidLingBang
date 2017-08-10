package lin.com.androidlingbang.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lin.com.androidlingbang.R;
import lin.com.androidlingbang.adapter.MyInfoAdapter;
import lin.com.androidlingbang.base.ToolbarFragment;
import lin.com.androidlingbang.data.DataServer;
import lin.com.androidlingbang.entity.MyInfo;
import lin.com.androidlingbang.util.Constant;

/**
 * The type Main fragment 4.
 *
 * @author linxianqinwork @qq.com
 */
public class MainFragment4 extends ToolbarFragment {

  /**
   * The M recycler view.
   */
  @BindView(R.id.RecyclerView)
  RecyclerView mRecyclerView;
  /**
   * "我的"数据
   */
  private List<MyInfo> data = new ArrayList<MyInfo>();

  @Override
  protected void initView() {
//    setToolbarTitle(R.string.current);
    initRecyclerView();
  }


  @Override
  protected void initData() {

  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void initToolbar() {
    setToolbarTitle(getString(R.string.home));
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_item4;
  }

  /**
   * 初始化RecyclerView
   */
  private void initRecyclerView() {
    data = DataServer.getMyInfoData();
    mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), Constant.FOUR));

    BaseQuickAdapter adapter = new MyInfoAdapter(getActivity(), data);
    adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    adapter.isFirstOnly(false); //关闭只加载一次   ,每次操作都加载动画
    //设置 宽度
    adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
      @Override
      public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return data.get(position).getSpanSize();
      }
    });
    //添加分割线
//    mRecyclerView.addItemDecoration(new DividerItemDecoration(
//            getActivity(), DividerItemDecoration.HORIZONTAL));
    mRecyclerView.setAdapter(adapter);

  }

}
