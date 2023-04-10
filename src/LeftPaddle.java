public class LeftPaddle extends Paddle {

  // The left paddle is the computer.

  /**
   * Construct a LeftPaddle.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public LeftPaddle(int x, int y) {
    super(x, y);
    super.setSpeed(0, GameConstant.PADDLE_SPEED);
  }

  @Override
  public void draw() {
    StdDraw.setPenColor(color);
    double halfWidth = width / 2.0;
    double halfHeight = height / 2.0;
    double centerX = topLeftX + halfWidth;
    double centerY = topLeftY - halfHeight;
    StdDraw.filledRectangle(centerX, centerY, halfWidth, halfHeight);
  }

  @Override
  public void move() {
    super.move();
    if (top() > GameConstant.CANVAS_HEIGHT) {
      deltaY = -GameConstant.PADDLE_SPEED;
    } else if (bottom() < 0) {
      deltaY = GameConstant.PADDLE_SPEED;
    }
  }
}