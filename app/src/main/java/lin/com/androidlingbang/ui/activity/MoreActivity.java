package lin.com.androidlingbang.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import lin.com.androidlingbang.R;
import lin.com.androidlingbang.adapter.MenuEntityAdapter;
import lin.com.androidlingbang.base.FinallyActivity;
import lin.com.androidlingbang.data.DataServer;
import lin.com.androidlingbang.entity.MenuEntity;

/**
 * Created by linxianqing on 2017/7/11.
 */
@Route(path = "/test/activity3")
public class MoreActivity extends FinallyActivity {
  @BindView(R.id.MoreRecyclerView)
  RecyclerView mMoreRecyclerView;



  private List<MenuEntity> mData;


  @Override
  protected void initData() {

  }
  @Override
  protected void initView() {
    setTitle("全部应用");
    mMoreRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    mData = DataServer.getMoreData();
    BaseQuickAdapter homeAdapter = new MenuEntityAdapter(getApplication(), mData);
    homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    homeAdapter.isFirstOnly(false); //关闭只加载一次   ,每次操作都加载动画
    homeAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
      @Override
      public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return mData.get(position).getSpanSize();
      }
    });
//    View head = getLayoutInflater().inflate(R.layout.more_head, (ViewGroup) mMoreRecyclerView
//            .getParent(), false);
//    homeAdapter.addHeaderView(head);
    mMoreRecyclerView.setAdapter(homeAdapter);
//    homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//      @Override
//      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//        if (mData.get(position).getUrl() != null&&mData.get(position).getUrl().equals("/test/activity")) {
//            MenuEntity o = (MenuEntity) adapter.getData().get(position);
//            System.out.println(o.getRightTag());
//            switch (o.getRightTag()) {
//              case "编辑":
//                ARouter.getInstance()
//                        .build(mData.get(position).getUrl())
//                        .navigation();
//                break;
//            }
//        }
//      }
//    });
  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void getExtraParams() {

  }

  @Override
  protected int getLayoutId() {
    return R.layout.more_activity;
  }


}
