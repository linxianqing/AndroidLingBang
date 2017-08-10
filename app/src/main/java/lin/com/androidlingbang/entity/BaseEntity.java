package lin.com.androidlingbang.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by lin on 17-8-1.
 */
public class BaseEntity implements MultiItemEntity {
    /**
     *
     */
    private int itemType;
    /**
     *
     */
    private int spanSize;
    /**
     * 头
     */
    public static final int HEAD = 1;
    /**
     * 主体
     */
    public static final int SUBJECT = 2;
    /**
     * 间隔条
     */
    public static final int BASEINTERVALBAR = 3;


    /**
     * The constant ONE_SPAN_SIZE.
     */
    public static final int ONE_SPAN_SIZE = 1;
    /**
     * The constant TWO_SPAN_SIZE.
     */
    public static final int TWO_SPAN_SIZE = 2;
    /**
     * The constant THREE_SPAN_SIZE.
     */
    public static final int THREE_SPAN_SIZE = 3;
    /**
     * The constant FOUR_SPAN_SIZE.
     */
    public static final int FOUR_SPAN_SIZE = 4;

    /**
     * Instantiates a new Base entity.
     */
    public BaseEntity() {
    }

    /**
     * Instantiates a new Base entity.
     *
     * @param itemType
     *         the item type
     * @param spanSize
     *         the span size
     */
    public BaseEntity(int itemType, int spanSize) {

        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    /**
     * Sets item type.
     *
     * @param itemType
     *         the item type
     */
    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    /**
     * Gets span size.
     *
     * @return the span size
     */
    public int getSpanSize() {
        return spanSize;
    }

    /**
     * Sets span size.
     *
     * @param spanSize
     *         the span size
     */
    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }
}
