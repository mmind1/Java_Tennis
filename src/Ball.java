public class Ball extends Sprite {
  int userScore;
  int computerScore;
  private int radius;

  /**
   * Construct a Ball.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public Ball(int x, int y) {
    super(x, y,
            GameConstant.BALL_RADIUS,
            GameConstant.BALL_RADIUS,
            GameConstant.BALL_COLOR
    );
    this.radius = GameConstant.BALL_RADIUS;
    super.setSpeed(GameConstant.BALL_SPEED, -GameConstant.BALL_SPEED);
  }

  @Override
  public void draw() {
    StdDraw.setPenColor(color);
    double halfRadius = radius / 2.0;
    double centerX = topLeftX + halfRadius;
    double centerY = topLeftY - halfRadius;
    StdDraw.filledCircle(centerX, centerY, halfRadius);
  }
  /**
   * Bounce off the edges of canvas.
   */

  public void bounce() {
    if (left() < 0) {
      // bouncing off the lest/right edges
      userScore++;
      deltaX *= -1; // switches direction on x-axis
    }

    if (right() > GameConstant.CANVAS_WIDTH) {
      // bouncing off the lest/right edges
      computerScore++;
      deltaX *= -1; // switches direction on x-axis
    }

    if (top() > GameConstant.CANVAS_HEIGHT) {
      // bounce off the top/bottom edges
      deltaY *= -1; // switches direction on y-axis
    }
    if (bottom() < 0) {
      // bounce off the top/bottom edges
      deltaY *= -1; // switches direction on y-axis
    }
  }


  /**
   * Ball gets deflected when collides with the left paddle.
   * @param leftPaddle the left paddle.
   */
  public void collide(LeftPaddle leftPaddle) {
    if (deltaX < 0
            && this.bottom() <= leftPaddle.top()
            && this.top() >= leftPaddle.bottom()
            && this.left() == leftPaddle.right()) {
      deltaX *= -1;
    }
  }


  /**
   * Ball gets deflected when collides with the right paddle.
   * @param rightPaddle the right paddle.
   */
  public void collide(RightPaddle rightPaddle) {
    if (deltaX > 0
            && this.top() >= rightPaddle.bottom()
            && this.bottom() <= rightPaddle.top()
            && this.right() == rightPaddle.left()) {
      deltaX *= -1;
    }
  }
}