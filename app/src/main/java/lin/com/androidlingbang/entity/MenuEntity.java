package lin.com.androidlingbang.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MenuEntity implements MultiItemEntity {
  private String id;
  private String title;
  private String ico;
  private String sort;
  private String num = null;
  private boolean select = false;
  private int itemType;
  private int spanSize;
  private int imageResource;
  private String url;
  private String leftTag;
  private String rightTag;
  public static final int HEAD = 1;
  public static final int MY_HEAD = 5;    //我的
  public static final int SUBJECT = 2;
  public static final int LABEL = 3;

  public static final int TEXT_SPAN_SIZE = 3;
  public static final int HEAD_SPAN_SIZE = 1;
  public static final int FULL_SPAN_SIZE = 4;
  public static final int IMG_TEXT_SPAN_SIZE_MIN = 2;


  public MenuEntity() {
  }

  @Override
  public String toString() {
    return "MenuEntity{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", ico='" + ico + '\'' +
            ", sort='" + sort + '\'' +
            ", num='" + num + '\'' +
            ", select=" + select +
            ", itemType=" + itemType +
            ", spanSize=" + spanSize +
            ", imageResource=" + imageResource +
            ", url='" + url + '\'' +
            ", leftTag='" + leftTag + '\'' +
            ", rightTag='" + rightTag + '\'' +
            '}';
  }

  public MenuEntity(String id, String title, String ico, String sort, String num, boolean select,
          int itemType, int spanSize, int imageResource, String url, String leftTag,
          String rightTag) {
    this.id = id;
    this.title = title;
    this.ico = ico;
    this.sort = sort;
    this.num = num;
    this.select = select;
    this.itemType = itemType;
    this.spanSize = spanSize;
    this.imageResource = imageResource;
    this.url = url;
    this.leftTag = leftTag;
    this.rightTag = rightTag;
  }

  public MenuEntity(int head, int spanSize) {
    this.itemType = head;
    this.spanSize = spanSize;
  }


  public int getSpanSize() {
    return spanSize;
  }

  public void setSpanSize(int spanSize) {
    this.spanSize = spanSize;
  }

  public int getItemType() {
    return itemType;
  }

  public void setItemType(int itemType) {
    this.itemType = itemType;
  }

  public boolean isSelect() {
    return select;
  }

  public void setSelect(boolean select) {
    this.select = select;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIco() {
    return ico;
  }

  public void setIco(String ico) {
    this.ico = ico;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public int getImageResource() {
    return imageResource;
  }

  public void setImageResource(int imageResource) {
    this.imageResource = imageResource;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getLeftTag() {
    return leftTag;
  }

  public void setLeftTag(String leftTag) {
    this.leftTag = leftTag;
  }

  public String getRightTag() {
    return rightTag;
  }

  public void setRightTag(String rightTag) {
    this.rightTag = rightTag;
  }


}
