package breakout;

import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {
    public double paddleXSpeed = 50;
    private static final int HEIGHT = 10;

    public Paddle(double width, double paddleXSpeed, double screenWidth, double screenHeight){
        setHeight(HEIGHT);
        setWidth(width);
        setX(screenWidth/2 - width/2);
        setY(screenHeight * .90);
    }
    public void moveRight(){
        setX(getX() + paddleXSpeed);
    }
    public void moveLeft(){
        setX(getX() - paddleXSpeed);
    }

}
