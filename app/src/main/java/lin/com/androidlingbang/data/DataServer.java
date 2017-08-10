package lin.com.androidlingbang.data;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lin.com.androidlingbang.GlobalApplication;
import lin.com.androidlingbang.entity.Friend;
import lin.com.androidlingbang.entity.MenuEntity;
import lin.com.androidlingbang.entity.MultipleItem;
import lin.com.androidlingbang.entity.MyInfo;
import lin.com.androidlingbang.entity.Status;
import lin.com.androidlingbang.util.FileUtil;

/**
 * The type Data server.
 */
public class DataServer {
  private static final String HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK =
          "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460";
  private static final String CYM_CHAD = "CymChad";
  private static Object sMoreData;

  private DataServer() {
  }

  /**
   * Gets sample data.
   *
   * @param lenth
   *         the lenth
   *
   * @return the sample data
   */
  public static List<Status> getSampleData(int lenth) {
    List<Status> list = new ArrayList<>();
    for (int i = 0; i < lenth; i++) {
      Status status = new Status();
      status.setUserName("Chad" + i);
      status.setCreatedAt("04/05/" + i);
      status.setRetweet(i % 2 == 0);
      status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
      status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
      list.add(status);
    }
    return list;
  }

  /**
   * Add data list.
   *
   * @param list
   *         the list
   * @param dataSize
   *         the data size
   *
   * @return the list
   */
  public static List<Status> addData(List list, int dataSize) {
    for (int i = 0; i < dataSize; i++) {
      Status status = new Status();
      status.setUserName("Chad" + i);
      status.setCreatedAt("04/05/" + i);
      status.setRetweet(i % 2 == 0);
      status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
      status.setText(
              "Powerful and flexible RecyclerAdapter https://github"
                      + ".com/CymChad/BaseRecyclerViewAdapterHelper");
      list.add(status);
    }

    return list;
  }


  /**
   * Gets str data.
   *
   * @return the str data
   */
  public static List<String> getStrData() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      String str = HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK;
      if (i % 2 == 0) {
        str = CYM_CHAD;
      }
      list.add(str);
    }
    return list;
  }

  /**
   * Gets multiple item data.
   *
   * @return the multiple item data
   */
  public static List<MultipleItem> getMultipleItemData() {
//    int j = MainFragment1.sisz1;

    List<MultipleItem> list = new ArrayList<>();

    for (int i = 0; i <= 5; i++) {
      list.add(new MultipleItem(MultipleItem.IMG, MultipleItem.IMG_SPAN_SIZE));
    }
    for (int i = 0; i <= 40; i++) {
      list.add(new MultipleItem(MultipleItem.TEXT, 4, CYM_CHAD));
    }
    return list;
  }

  /**
   * Gets menu item data.
   *
   * @return the menu item data
   */
  public static List<MenuEntity> getMenuItemData() {

    List<MenuEntity> list = new ArrayList<>();

    for (int i = 0; i <= 4; i++) {
      MenuEntity menuEntity = new MenuEntity();
      int type = (int) (Math.random() * 3 + 1);
//      menuEntity.
//      list.add(menuEntity);
    }
//    for (int i = 0; i <= 6; i++) {
//      list.add(new MenuEntity(MultipleItem.TEXT, 4, CYM_CHAD));
//    }
    return list;
  }

  /**
   * 获取首页数据.
   *
   * @return List<MenuEntity> home menu entity data
   */
  public static List<MenuEntity> getHomeMenuEntityData() {

    List<MenuEntity> list = new ArrayList<>();
    JsonArray jsonArray = getJsonElements();
    Gson gson = new Gson();

    for (JsonElement indexArr : jsonArray) {
      MenuEntity menuEntity = gson.fromJson(indexArr, MenuEntity.class);
      MenuEntity menuEntity1 = new MenuEntity(MenuEntity.HEAD, MenuEntity.HEAD_SPAN_SIZE);
      menuEntity1.setImageResource(getMipmapDrawableId(menuEntity));
      menuEntity1.setTitle(menuEntity.getTitle());
      menuEntity1.setUrl(menuEntity.getUrl());
      menuEntity1.setNum(menuEntity.getNum()); //设置徽章'
      list.add(menuEntity1);
    }

    for (int i = 0; i < 20; i++) {
      MenuEntity menuEntity = new MenuEntity(MenuEntity.SUBJECT, MenuEntity.FULL_SPAN_SIZE);
      menuEntity.setUrl("/test/activity");
      list.add(menuEntity);
    }
    return list;
  }

  /**
   * 获取'我的'数据.
   *
   * @return List<MenuEntity> my info data
   */
  public static List<MyInfo> getMyInfoData() {
    List<MyInfo> list = new ArrayList<>();
    MyInfo myInfo = new MyInfo(MyInfo.HEAD, MyInfo.FOUR_SPAN_SIZE);
    myInfo.setIcon(getMipmapDrawableId("app_wdjh_ico"));
    myInfo.setEmail("linxianqin@outlook.com");
    myInfo.setUsername("linxiqng");
    myInfo.setJumpUrl("/test/activity");
    MyInfo myInfo1 = new MyInfo(MyInfo.SUBJECT, MyInfo.FOUR_SPAN_SIZE);

    myInfo1.setHeadline("会员");
    myInfo1.setSubtitle("4555积分");
    myInfo1.setJumpUrl("/test/activity");

    MyInfo myInfo2 = new MyInfo(MyInfo.BASEINTERVALBAR, MyInfo.FOUR_SPAN_SIZE);
    MyInfo myInfo3 = new MyInfo(MyInfo.SUBJECT, MyInfo.FOUR_SPAN_SIZE);

    list.add(myInfo);
    list.add(myInfo1);
    list.add(myInfo2);
    for (int i = 0; i < 15; i++) {
      myInfo3.setHeadline("会员");
      myInfo3.setSubtitle("4555积分");
      myInfo3.setJumpUrl("/test/activity");
      list.add(myInfo3);
    }
    return list;
  }

  /**
   * 获取'朋友'数据.
   *
   * @return List<Friend> friend data
   */
  public static List<Friend> getFriendData() {
    List<Friend> list = new ArrayList<>();
    SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日    HH:mm:ss     ");
    Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
    String    str    =    formatter.format(curDate);
    Friend friend = new Friend(Friend.SUBJECT, Friend.FOUR_SPAN_SIZE);
    for (int i = 0; i < 15; i++) {
      friend.setIcon(getMipmapDrawableId("app_wdjh_ico"));
      friend.setHeadline("支付中心");
      friend.setSubheading("转账成功");
      friend.setUrl("/test/activity");
      friend.setTime(str);
      list.add(friend);
    }
    return list;
  }

  /**
   * 获取更多数据
   *
   * @return List<MenuEntity> more data
   */
  public static List<MenuEntity> getMoreData() {
    List<MenuEntity> list = new ArrayList<>();
    JsonArray jsonArray = getJsonElements();
    Gson gson = new Gson();
    MenuEntity menuEntity1 = new MenuEntity(MenuEntity.LABEL, MenuEntity.FULL_SPAN_SIZE);
    menuEntity1.setLeftTag("我的应用");
    menuEntity1.setRightTag("编辑");
    list.add(menuEntity1);
    for (int i = 0; i < jsonArray.size() - 1; i++) {
      MenuEntity menuEntity = gson.fromJson(jsonArray.get(i), MenuEntity.class);
      MenuEntity menuEntity2 = new MenuEntity(MenuEntity.HEAD, MenuEntity.HEAD_SPAN_SIZE);
      menuEntity2.setImageResource(getMipmapDrawableId(menuEntity));
      menuEntity2.setTitle(menuEntity.getTitle());
      list.add(menuEntity2);
    }

    MenuEntity menuEntity3 = new MenuEntity(MenuEntity.LABEL, MenuEntity.FULL_SPAN_SIZE);
    menuEntity3.setLeftTag("便民生活");
    menuEntity3.setRightTag("");
    list.add(menuEntity3);
    for (int i = 0; i < jsonArray.size() - 1; i++) {
      MenuEntity menuEntity = gson.fromJson(jsonArray.get(i), MenuEntity.class);
      MenuEntity menuEntity4 = new MenuEntity(MenuEntity.HEAD, MenuEntity.HEAD_SPAN_SIZE);
      menuEntity4.setImageResource(getMipmapDrawableId(menuEntity));
      menuEntity4.setTitle(menuEntity.getTitle());
      list.add(menuEntity4);
    }

    MenuEntity menuEntity5 = new MenuEntity(MenuEntity.LABEL, MenuEntity.FULL_SPAN_SIZE);
    menuEntity5.setLeftTag("资金往来");
    menuEntity5.setRightTag("");
    list.add(menuEntity5);
    for (int i = 0; i < jsonArray.size() - 1; i++) {
      MenuEntity menuEntity = gson.fromJson(jsonArray.get(i), MenuEntity.class);
      MenuEntity menuEntity6 = new MenuEntity(MenuEntity.HEAD, MenuEntity.HEAD_SPAN_SIZE);
      menuEntity6.setImageResource(getMipmapDrawableId(menuEntity));
      menuEntity6.setTitle(menuEntity.getTitle());
      list.add(menuEntity6);
    }
    MenuEntity menuEntity7 = new MenuEntity(MenuEntity.LABEL, MenuEntity.FULL_SPAN_SIZE);
    menuEntity7.setLeftTag("购物娱乐");
    menuEntity7.setRightTag("");
    list.add(menuEntity5);
    for (int i = 0; i < jsonArray.size() - 1; i++) {
      MenuEntity menuEntity = gson.fromJson(jsonArray.get(i), MenuEntity.class);
      MenuEntity menuEntity8 = new MenuEntity(MenuEntity.HEAD, MenuEntity.HEAD_SPAN_SIZE);
      menuEntity8.setImageResource(getMipmapDrawableId(menuEntity));
      menuEntity8.setTitle(menuEntity.getTitle());
      list.add(menuEntity8);
    }

    return list;
  }

  /**
   * 根据图片名称得到图片id.
   *
   * @return 图片id
   */
  private static int getMipmapDrawableId(MenuEntity menuEntity) {
    return getContext().getResources().getIdentifier(menuEntity.getIco(), "mipmap",
            getContext().getPackageName());
  }

  private static int getMipmapDrawableId(String ico) {
    return getContext().getResources().getIdentifier(ico, "mipmap",
            getContext().getPackageName());
  }

  /**
   * 获取文件json元素.
   *
   * @return json数组
   */
  private static JsonArray getJsonElements() {
    String strByJson = FileUtil.getJson(getContext(), "menulist.json");
    JsonParser parser = new JsonParser();
    return parser.parse(strByJson).getAsJsonArray();
  }


  /**
   * 获取全局上下文.
   *
   * @return Context
   */
  private static Context getContext() {
    return new GlobalApplication().getContext();
  }

}
