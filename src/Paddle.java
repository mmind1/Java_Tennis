import java.awt.event.KeyEvent;

public abstract class Paddle extends Sprite {

  /**
   * Construct a Paddle.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public Paddle(int x, int y) {
    super(x, y,
            GameConstant.PADDLE_WIDTH,
            GameConstant.PADDLE_HEIGHT,
            GameConstant.PADDLE_COLOR
    );
    super.setSpeed(GameConstant.PADDLE_SPEED,0);
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
    if (left() < 0) {
      topLeftX = 0;
    } else if (right() > GameConstant.CANVAS_WIDTH) {
      topLeftX = GameConstant.CANVAS_WIDTH - width;
    }
  }

  /**
   * Change direction when arrow key is pressed.
   */
  public void changeDirection() {
    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
      deltaX = GameConstant.PADDLE_SPEED;
    } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
      deltaX = -GameConstant.PADDLE_SPEED;
    }
  }
}
