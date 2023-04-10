import java.awt.event.KeyEvent;

public class RightPaddle extends Paddle {

  // The right paddle is the user.


  /**
   * Construct a Paddle.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public RightPaddle(int x, int y) {
    super(x, y);
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
      topLeftY = GameConstant.CANVAS_HEIGHT;
    } else if (bottom() < 0) {
      deltaY = 0;
    }
  }

  @Override
  public void changeDirection() {
    if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
      deltaY = GameConstant.PADDLE_SPEED;
    } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
      deltaY = -GameConstant.PADDLE_SPEED;
    }
  }
}