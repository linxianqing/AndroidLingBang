package lin.com.androidlingbang.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lin.com.androidlingbang.R;
import lin.com.androidlingbang.adapter.FriendAdapter;
import lin.com.androidlingbang.base.ToolbarFragment;
import lin.com.androidlingbang.data.DataServer;
import lin.com.androidlingbang.entity.Friend;
import lin.com.androidlingbang.util.Constant;

/**
 * The type Main fragment 3.
 *
 * @author linxianqinwork @qq.com
 */
public class MainFragment3 extends ToolbarFragment {
  /**
   * recycler view.
   */
  @BindView(R.id.RecyclerView)
  public RecyclerView mRecyclerView;
  /**
   * 朋友数据列表
   */
  private List<Friend> data = new ArrayList<Friend>();

  @Override
  protected void initView() {
    initRecyclerView();
  }

  /**
   * 初始化RecyclerView
   */
  private void initRecyclerView() {
    data = DataServer.getFriendData();
    mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), Constant.FOUR));

    BaseQuickAdapter adapter = new FriendAdapter(getActivity(), data);
    adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    adapter.isFirstOnly(false); //关闭只加载一次,每次操作都加载动画
    //设置 宽度
    adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
      @Override
      public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return data.get(position).getSpanSize();
      }
    });

    mRecyclerView.setAdapter(adapter);
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
    return R.layout.fragment_item3;
  }
}
