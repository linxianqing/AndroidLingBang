package lin.com.androidlingbang.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.entity.Friend;
import lin.com.androidlingbang.util.ARouterUtil;

/**
 * Created by lin on 17-8-1.
 */

public class FriendAdapter extends
        BaseMultiItemQuickAdapter<Friend, BaseViewHolder> {
  /**
   * 当前上下文
   */
  private Context mContext;

  /**
   * Same as QuickAdapter#QuickAdapter(Context,int) but with
   * some initialization data.
   *
   * @param data A new list is created out of this one to avoid mutable list
   */
  public FriendAdapter(Context context, List data) {
    super(data);
    this.mContext = context;
    addItemType(Friend.SUBJECT, R.layout.friend_subject);
  }

  @Override
  protected void convert(BaseViewHolder helper, Friend item) {
    switch (helper.getItemViewType()) {
      case Friend.SUBJECT:
        helper.setImageResource(R.id.iv1, item.getIcon());
        helper.setText(R.id.tv1, item.getHeadline());
        helper.setText(R.id.tv2, item.getSubheading());
        helper.setText(R.id.tv3, item.getTime());
        ((ConstraintLayout) helper.getView(R.id.cLayout)).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            ARouterUtil.toUrl(item.getUrl());
          }
        });
        break;
      default:
        break;
    }

  }
}
