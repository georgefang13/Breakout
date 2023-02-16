package breakout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author George Fang
 */
public class Main extends Application {
    // useful names for constant values used
    public static final String TITLE = "Ball Buster - George Fang";
    public static final int SIZE = 800;
    public static final int FRAMES_PER_SECOND = 60;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static List<Block> blocks = new ArrayList<>();
    private static int min = 300;
    private static int max = 350;
    private Random rand = new Random();
    private int randomNumX = rand.nextInt(max - min + 1) + min;
    private int randomNumY = rand.nextInt(max - min + 1) + min;

    private Ball ball;
    private Paddle paddle;
    public ScoreBoard scoreBoard;
    private Group root;
    private List<List<Integer>> currLevel;
    private Label score;


    /**
     * Initialize what will be displayed.
     */
    @Override
    public void start (Stage stage) {
        root = new Group();

        try {
            currLevel = readLevel(1);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Unable to find level1.txt");
            System.exit(1);
        }

        setUpLevel(currLevel);
        scoreBoard = new ScoreBoard();
        score = new Label("Lives: " + scoreBoard.getLives() + " Level: " + scoreBoard.getLevel() + " Score: " + scoreBoard.getScore());
        score.setLayoutX(150);
        score.setLayoutY(SIZE - 60);
        //40pt font, Arial font, black text, 800 pixels wide, centered text
        score.setStyle("-fx-font-size: 40px; -fx-font-family: 'Arial'; -fx-text-fill: black; -fx-font-weight: bold; -fx-alignment: center;");


        ball = new Ball(10, randomNumX*Math.pow(-1, randomNumX), -randomNumY, 400, 700);
        paddle = new Paddle(200, 50, SIZE, SIZE);

        ball.setFill(Color.BLACK);
        paddle.setFill(Color.BLACK);

        root.getChildren().add(score);
        root.getChildren().add(ball);
        root.getChildren().add(paddle);
        Scene scene = new Scene(root, SIZE, SIZE, Color.LIGHTBLUE);
        stage.setScene(scene);
        stage.setResizable(false);


        stage.setTitle(TITLE);
        stage.show();

        stage.getScene().setOnKeyPressed(key -> {
            if (key.getCode() == KeyCode.LEFT) {
                paddle.moveLeft();
                System.out.println(key);
            }
            if (key.getCode() == KeyCode.RIGHT) {
                paddle.moveRight();
                System.out.println(key);
            }
            if (key.getCode() == KeyCode.R) {
                ball.resetBall();
            }
            if (key.getCode() == KeyCode.L) {
                scoreBoard.increaseLives();
                score.setText("Lives: " + scoreBoard.getLives() + " Level: " + scoreBoard.getLevel() + " Score: " + scoreBoard.getScore());
                System.out.println(scoreBoard.getLives());
            }
            if (key.getCode() == KeyCode.DIGIT1) {
                try {
                    currLevel = readLevel(1);
                    removeAllBlock();
                    resetPowerUps(ball, paddle);
                    setUpLevel(currLevel);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            if (key.getCode() == KeyCode.DIGIT2) {
                try {
                    currLevel = readLevel(2);
                    removeAllBlock();
                    resetPowerUps(ball, paddle);
                    setUpLevel(currLevel);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            if (key.getCode() == KeyCode.DIGIT3) {
                try {
                    currLevel = readLevel(3);
                    removeAllBlock();
                    resetPowerUps(ball, paddle);
                    setUpLevel(currLevel);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(SECOND_DELAY)));
        animation.play();
    }
    public List<List<Integer>> readLevel(int levelNum) throws FileNotFoundException {
        List<List<Integer>> columns = new ArrayList<List<Integer>>();
        List<Integer> rows;

        InputStream fp = getClass().getResourceAsStream("/level" + levelNum + ".txt");
        System.out.println(fp);
        Scanner scanner = new Scanner(fp);

        while(scanner.hasNextLine()){
            rows = new ArrayList<Integer>();
            for(String i : scanner.nextLine().split(" ")) {
                rows.add(Integer.parseInt(i));
            }
            columns.add(rows);
        }
        return columns;
    }
    public void setUpLevel(List<List<Integer>> level){
        // i's are # columns, j's are # rows
        for(Block b : blocks){
            root.getChildren().remove(b);
        }
        for (int i = 0; i < level.size(); i++) {
            for (int j = 0; j < level.get(1).size(); j++) {
                double y = (i * 40) + (40) / 2;
                double x = (j * 40) + (800 - 600) / 2;
                if(level.get(i).get(j) == 0){
                    continue;
                }
                blocks.add(new Block(Color.PINK, x,
                        y, level.get(i).get(j)));
                blocks.get(blocks.size()-1).setBlockColor(level.get(i).get(j));
            }
        }
        for(Block b : blocks){
            root.getChildren().add(b);
        }

    }

    public void removeAllBlock(){
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
                iterator.remove();
                root.getChildren().remove(block);
            }
        }

    public void step (double elapsedTime) {
        updateBall(elapsedTime);

        checkBallPaddleCollision(paddle, ball);
        checkBallBlockCollision(blocks, ball);
        checkBallWallCollision(ball);
        gameOver();
    }

    private void updateBall(double elapsedTime){
        ball.move(elapsedTime);
    }

    private void checkBallPaddleCollision(Paddle paddle, Ball ball){
        if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent())){
            ball.bounceOffPaddle(paddle);
        }
    }

    private void gameOver() {
        if(scoreBoard.getLives() == 0){
            score.setText("           GAME OVER");
            ball.setBallSpeed(0,0);
            ball.setCenterY(700);
            ball.setCenterX(400);
            scoreBoard.setScore(0);
        }
    }

    private void checkBallBlockCollision(List<Block> blocks, Ball ball){
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
//        for(Block b : blocks){
            Block block = iterator.next();
            if(ball.getBoundsInParent().intersects(block.getBoundsInParent())){
                ball.bounceOffBlock(block, paddle);

                if(block.getHealth() == 0) {
                    iterator.remove();
                    root.getChildren().remove(block);
                    scoreBoard.increaseScore();
                    score.setText("Lives: " + scoreBoard.getLives() + " Level: " + scoreBoard.getLevel() + " Score: " + scoreBoard.getScore());
                }
             }
            }
    }

    private void checkBallWallCollision(Ball ball){
        ball.bounceOffWall(SIZE, SIZE, scoreBoard, score);
    }

    private void resetPowerUps(Ball ball, Paddle paddle){
        ball.resetBall();
        paddle.setWidth(200);
    }
    
}

