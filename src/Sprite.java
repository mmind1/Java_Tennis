import java.awt.Color;

public abstract class Sprite extends Block {
  protected int deltaX;
  protected int deltaY;

  /**
   * Construct a sprite.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   * @param width  of this sprite.
   * @param height of this sprite.
   * @param color  of this sprite.
   */
  public Sprite(int x, int y, int width, int height, Color color) {
    super(x, y, width, height, color);
    deltaX = 0;
    deltaY = 0;
  }
  /**
   * Set the speed of this Sprite.
   * @param dx displacement on the X axis.
   * @param dy displacement on the Y axis.
   */

  public void setSpeed(int dx, int dy) {
    deltaX = dx;
    deltaY = dy;
  }

  /**
   * Update the coordinates of this Sprite.
   */
  public void move() {
    topLeftX += deltaX;
    topLeftY += deltaY;
  }

  /**
   * Check if this Sprite is moving left.
   * @return true if this Sprite is moving left, false otherwise.
   */

  public boolean isMovingLeft() {
    return deltaX < 0;
  }

  /**
   * Check if this Sprite is moving right.
   * @return true if this Sprite is moving right, false otherwise.
   */

  public boolean isMovingRight() {
    return deltaX > 0;
  }

  /**
   * Check if this Sprite is moving up.
   * @return true if this Sprite is moving up, false otherwise.
   */

  public boolean isMovingUp() {
    return deltaY > 0;
  }

  /**
   * Check if this Sprite is moving down.
   * @return true if this Sprite is moving down, false otherwise.
   */

  public boolean isMovingDown() {
    return deltaY < 0;
  }
}