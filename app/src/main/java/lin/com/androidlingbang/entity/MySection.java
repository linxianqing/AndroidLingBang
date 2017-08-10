package lin.com.androidlingbang.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MySection extends SectionEntity<Video> {
  /**
   * test
   */
  private boolean isMore;

  /**
   * Instantiates a new My section.
   *
   * @param isHeader
   *         the is header
   * @param header
   *         the header
   * @param isMroe
   *         the is mroe
   */
  public MySection(boolean isHeader, String header, boolean isMroe) {
    super(isHeader, header);
    this.isMore = isMroe;
  }

  /**
   * Instantiates a new My section.
   *
   * @param t
   *         the t
   */
  public MySection(Video t) {
    super(t);
  }

  /**
   * Is more boolean.
   *
   * @return the boolean
   */
  public boolean isMore() {
    return isMore;
  }

  /**
   * Sets more.
   *
   * @param mroe
   *         the mroe
   */
  public void setMore(boolean mroe) {
    isMore = mroe;
  }
}
