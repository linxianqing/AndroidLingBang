package lin.com.androidlingbang.adapter;


import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import lin.com.androidlingbang.R;
import lin.com.androidlingbang.entity.MenuEntity;
import lin.com.androidlingbang.util.ARouterUtil;
import lin.com.androidlingbang.util.SpannableStringUtils;
import lin.com.androidlingbang.util.ToastUtils;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MenuEntityAdapter extends
        BaseMultiItemQuickAdapter<MenuEntity, BaseViewHolder> {
  private Context mContext;
  public MenuEntityAdapter(Context context, List data) {
    super(data);
    this.mContext = context;
    addItemType(MenuEntity.HEAD, R.layout.item_image_view);
    addItemType(MenuEntity.MY_HEAD, R.layout.my_head);
    addItemType(MenuEntity.SUBJECT, R.layout.item_text_view);
    addItemType(MenuEntity.LABEL, R.layout.more_head);
  }


  @Override
  protected void convert(BaseViewHolder helper, MenuEntity item) {
    switch (helper.getItemViewType()) {
      case MenuEntity.HEAD:
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
        helper.setText(R.id.tv1, item.getNum());
        break;
      case MenuEntity.SUBJECT:
        break;
      case MenuEntity.LABEL:
        helper.setText(R.id.tv1, item.getLeftTag());
        ((TextView) helper.getView(R.id.tv2)).setText(SpannableStringUtils.getBuilder(
                item.getRightTag()).setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tv2)).setMovementMethod(LinkMovementMethod.getInstance());
        break;
      case MenuEntity.MY_HEAD:
        break;

    }
  }

  ClickableSpan clickableSpan = new ClickableSpan() {
    @Override
    public void onClick(View v) {
      ToastUtils.showShortToast("触发点击事件");
      switch (v.getId()) {
        case R.id.tv2:
          ARouterUtil.toUrl("/test/activity");
          break;
      }
    }
    @Override
    public void updateDrawState(TextPaint ds) {
      ds.setColor(Utils.getContext().getResources().getColor(R.color.grgray));    //设置字体颜色
      ds.setUnderlineText(false);                                                  //删除下划线文本
    }
  };
}
