import java.awt.Color;

/**
 * A block is a game object with rectangular bounding box.
 */
public abstract class Block implements GameObject {
  protected int topLeftX;
  protected int topLeftY;
  protected int width;
  protected int height;
  protected Color color;

  /**
   * Construct a block.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   * @param width  of this block.
   * @param height of this block.
   * @param color  of this block.
   */
  public Block(int x, int y, int width, int height, Color color) {
    this.topLeftX = x;
    this.topLeftY = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * Get the "top" of this block.
   *
   * @return the y coordinate of the top edge.
   */
  public int top() {
    return topLeftY;
  }

  /**
   * Get the "bottom" of this block.
   *
   * @return the y coordinate of the bottom edge.
   */
  public int bottom() {
    return topLeftY - height;
  }

  /**
   * Get the "left" of this block.
   *
   * @return the x coordinate of the left edge.
   */
  public int left() {
    return topLeftX;
  }

  /**
   * Get the "right" of this block.
   *
   * @return the x coordinate of the right edge.
   */
  public int right() {
    return topLeftX + width;
  }

}