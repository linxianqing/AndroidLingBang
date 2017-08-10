package lin.com.androidlingbang.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.entity.MyInfo;
import lin.com.androidlingbang.util.ARouterUtil;

/**
 * Created by linxianqing on 2017/7/31.
 */

public class MyInfoAdapter extends
        BaseMultiItemQuickAdapter<MyInfo, BaseViewHolder> {
  private Context mContext;

  /**
   * Same as QuickAdapter#QuickAdapter(Context,int) but with
   * some initialization data.
   *
   * @param data A new list is created out of this one to avoid mutable list
   */
  public MyInfoAdapter(Context context, List data) {
    super(data);
    this.mContext = context;
    addItemType(MyInfo.HEAD, R.layout.my_head);
    addItemType(MyInfo.SUBJECT, R.layout.my_subject);
    addItemType(MyInfo.BASEINTERVALBAR, R.layout.base_intervalbar);
  }

  @Override
  protected void convert(BaseViewHolder helper, MyInfo item) {
    switch (helper.getItemViewType()) {
      case MyInfo.HEAD:
        helper.setImageResource(R.id.iv1, item.getIcon());
        helper.setText(R.id.tv1, item.getUsername());
        helper.setText(R.id.tv2, item.getEmail());
        ((LinearLayout) helper.getView(R.id.lLayout)).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            ARouterUtil.toUrl(item.getJumpUrl());
          }
        });
        break;
      case MyInfo.SUBJECT:
        helper.setText(R.id.tv1, item.getHeadline());
        helper.setText(R.id.tv2, item.getSubtitle());
        ((ConstraintLayout) helper.getView(R.id.cLayout)).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            ARouterUtil.toUrl(item.getJumpUrl());
          }
        });
        break;
    }
  }
}
