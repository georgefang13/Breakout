package breakout;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import breakout.ScoreBoard;


import java.util.Random;

public class Ball extends Circle {
    private Point2D myVelocity;
    private double ballXSpeed;
    private double ballYSpeed;
    private Random rand = new Random();

    public Ball(double radius, double ballXSpeed, double ballYSpeed, int xpos, int ypos) {
        super(radius);
        setCenterX(xpos);
        setCenterY(ypos);

        myVelocity = new Point2D(ballXSpeed, ballYSpeed);
    }

    public void move(double timeElapsed){
        setCenterX(this.getCenterX() + myVelocity.getX() * timeElapsed);
        setCenterY(this.getCenterY() + myVelocity.getY() * timeElapsed);
    }
    
    public void bounceOffWall(double screenWidth, double screenHeight, ScoreBoard scoreBoard, Label score){
        //bounce off walls
        if (this.getCenterX() < 0 + this.getRadius() || this.getCenterX() > screenWidth - this.getBoundsInLocal().getWidth() + this.getRadius()) {
            myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
        }
        //bounce off ceiling
        if (this.getCenterY() < 0) {
            myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY() + this.getRadius());
        }
        //bounce off floor
        if (this.getCenterY() > screenHeight) {
            this.resetBall();
            scoreBoard.loseLife();
            score.setText("Lives: " + scoreBoard.getLives() + " Level: " + scoreBoard.getLevel() + " Score: " + scoreBoard.getScore());
        }
    }

    public void bounceOffPaddle(Paddle paddle){
        //get the position of the ball and paddle in the x-axis
        double ballX = this.getCenterX();
        double paddleX = paddle.getX();
        //get the width of the paddle
        double paddleWidth = paddle.getWidth();
        //paddle left third
        double paddleThird = paddleX + paddleWidth/3;
        //paddle right third
        double paddleThird2 = paddleX + paddleWidth*2/3;
        //check if the ball is on the left third of the paddle
        if(ballX < paddleThird && ballXSpeed > 0){
            myVelocity = new Point2D(-myVelocity.getX(), -myVelocity.getY());
        }
        //check if the ball is on the right third of the paddle
        else if(ballX > paddleThird2 && ballXSpeed < 0){
            myVelocity = new Point2D(-myVelocity.getX(), -myVelocity.getY());
        }
        //otherwise, just reflect the ball
        else{
            myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
        }
    }
    public void resetBall(){
        this.setCenterX(400);
        this.setCenterY(700);
        myVelocity = new Point2D((rand.nextInt(300) + 50) * (rand.nextInt(2) * 2 - 1) ,-330);
    }

    public void setBallSpeed(double ballXSpeed, double ballYSpeed){
        myVelocity = new Point2D(ballXSpeed,ballYSpeed);
    }
    public void bounceOffBlock(Block block, Paddle paddle){

        Bounds ballBounds = this.getBoundsInParent(); 
        Bounds blockBounds = block.getBoundsInParent();      

        // Check for intersection with top and bottom sides of block
        if (ballBounds.getMaxX() > blockBounds.getMinX() && 
            ballBounds.getMinX() < blockBounds.getMaxX()) { 
            if (ballBounds.getMaxY() >= blockBounds.getMinY() && 
                ballBounds.getMaxY() <= blockBounds.getMinY() + 5) { 
                myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
            } else if (ballBounds.getMinY() <= blockBounds.getMaxY() && 
                    ballBounds.getMinY() >= blockBounds.getMaxY() - 5) {
                myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
            }
        }

        // Check for intersection with left and right sides of block
        if (ballBounds.getMaxY() > blockBounds.getMinY() && 
            ballBounds.getMinY() < blockBounds.getMaxY()) {
            if (ballBounds.getMaxX() >= blockBounds.getMinX() && 
                ballBounds.getMaxX() <= blockBounds.getMinX() + 5) {
                myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
            } else if (ballBounds.getMinX() <= blockBounds.getMaxX() &&
            ballBounds.getMinX() >= blockBounds.getMaxX() - 5) {
            myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
            }
        }
        //normal block
        if(block.getHealth() < 6) {
            block.setHealth(block.getHealth() - 1);
        }
        //double paddle size
        else if (block.getHealth() == 6){
            block.setHealth(block.getHealth() - 6);
            paddle.setWidth(paddle.getWidth()*2);
        }
        //half paddle size
        else if (block.getHealth() == 7){
            block.setHealth(block.getHealth() - 7);
            paddle.setWidth(paddle.getWidth()/2);
        }
        //increase speed 1.5x
        else if (block.getHealth() == 8){
            block.setHealth(block.getHealth() - 8);
            myVelocity = new Point2D(1.5*myVelocity.getX(),1.5*myVelocity.getY());
        }
        //decrease speed 1.5x
        else if (block.getHealth() == 9){
            block.setHealth(block.getHealth() - 9);
            myVelocity = new Point2D(myVelocity.getX()/1.5,myVelocity.getY()/1.5);
        }
        block.setBlockColor(block.getHealth());
    }
    
}
