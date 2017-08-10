package lin.com.androidlingbang.entity;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class HomeItem {
    /**
     * 标签
     */
    private String title;
    /**
     * activity
     */
    private Class<?> activity;
    /**
     * imageResource
     */
    private int imageResource;

    /**
     * Gets image resource.
     *
     * @return the image resource
     */
    public int getImageResource() {
        return imageResource;
    }

    /**
     * Sets image resource.
     *
     * @param imageResource
     *         the image resource
     */
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title
     *         the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public Class<?> getActivity() {
        return activity;
    }

    /**
     * Sets activity.
     *
     * @param activity
     *         the activity
     */
    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}
