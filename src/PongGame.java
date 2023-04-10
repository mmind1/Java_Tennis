import java.awt.Color;
import java.awt.Font;

public class PongGame {
  private static Paddle leftPaddle;
  private static Paddle rightPaddle;
  private static Ball ball;

  /**
   * The program starts here.
   *
   * @param args command-line arguments.
   */
  public static void main(String[] args) {
    setupCanvas();
    setupGameObjects();
    boolean isGameOver = false;
    while (!isGameOver) {
      StdDraw.clear(Color.black);

      drawGameObjects();

      moveGameObjects();
      handleCollisions();
      if (ball.userScore == 5 || ball.computerScore == 5) {
        isGameOver = true;
      }

      displayScoreComputer(ball.computerScore);
      displayScoreUser(ball.userScore);

      StdDraw.show();
      StdDraw.pause(GameConstant.FRAME_DELAY);
    }
    StdDraw.clear(Color.black);
    displayResult();
  }

  private static void handleCollisions() {
    ball.collide((LeftPaddle) leftPaddle);
    ball.collide((RightPaddle) rightPaddle);
  }

  private static void moveGameObjects() {
    leftPaddle.move();
    rightPaddle.move();
    rightPaddle.changeDirection();
    ball.move();
    ball.bounce();
  }

  private static void drawGameObjects() {
    StdDraw.line(GameConstant.CANVAS_WIDTH / 2.0,0, GameConstant.CANVAS_WIDTH / 2.0, GameConstant.CANVAS_HEIGHT);
    ball.draw();
    leftPaddle.draw();
    rightPaddle.draw();
  }

  private static void setupGameObjects() {

    leftPaddle = new LeftPaddle(
            (0 + GameConstant.PADDLE_OFFSET),
            (GameConstant.CANVAS_HEIGHT - GameConstant.PADDLE_HEIGHT) / 2

    );

    rightPaddle = new RightPaddle(
            (GameConstant.CANVAS_WIDTH - GameConstant.PADDLE_OFFSET),
            (GameConstant.CANVAS_HEIGHT - GameConstant.PADDLE_HEIGHT) / 2
    );

    ball = new Ball(
            GameConstant.CANVAS_WIDTH  / 2,
            GameConstant.CANVAS_HEIGHT  / 2
    );
  }

  private static void displayScoreComputer(int computerScore) {
    StdDraw.setPenColor(GameConstant.SCORE_COLOR);
    StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 24));
    // Computer is left side
    StdDraw.textLeft(
            20,
            GameConstant.CANVAS_HEIGHT - 30,
            "Computer Score: " + ball.computerScore
    );
  }

  private static void displayScoreUser(int userScore) {
    StdDraw.setPenColor(GameConstant.SCORE_COLOR);
    StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 24));
    // User or player is right side
    StdDraw.textRight(
            GameConstant.CANVAS_WIDTH - 30,
            GameConstant.CANVAS_HEIGHT - 30,
            "My Score: " + ball.userScore
    );
  }

  private static void displayResult() {
    if (ball.userScore == 5) {
      StdDraw.setPenColor(GameConstant.SCORE_COLOR);
      StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 48));
      StdDraw.text(
              GameConstant.CANVAS_WIDTH / 2.0,
              GameConstant.CANVAS_HEIGHT / 2.0, ("You won!")
      );
    }
    if (ball.computerScore == 5) {
      StdDraw.setPenColor(GameConstant.SCORE_COLOR);
      StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 48));
      StdDraw.text(
                GameConstant.CANVAS_WIDTH / 2.0,
                GameConstant.CANVAS_HEIGHT / 2.0, ("The computer won!")
      );
    }
    StdDraw.show();
  }

  private static void setupCanvas() {
    StdDraw.setCanvasSize(GameConstant.CANVAS_WIDTH, GameConstant.CANVAS_HEIGHT);
    StdDraw.setXscale(0, GameConstant.CANVAS_WIDTH);
    StdDraw.setYscale(0, GameConstant.CANVAS_HEIGHT);
    StdDraw.enableDoubleBuffering();
  }
}