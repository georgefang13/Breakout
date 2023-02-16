package breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    private static final int SIZE = 40;
    private int health;

    //colors[0] represents block w 1 health and so on
    private final static Color[] colors = {
        Color.rgb(74,53,18), 
        Color.rgb(136,101,41), 
        Color.rgb(7,37,32), 
        Color.rgb(43,175,153), 
        Color.rgb(45,233,204),
            Color.rgb(25,180,25),
            Color.rgb(230,40,40),
            Color.rgb(255,218,65),
            Color.rgb(255,144,22),
    };

    public Block(Color color, double xpos, double ypos, int lives){
        setFill(color);
        setX(xpos);
        setY(ypos);
        health = lives;
        setWidth(SIZE);
        setHeight(SIZE);
    }

    public int getHealth(){
        return health;
    }

    public boolean isDestroyed(){
        if (health == 0){ return true; }
        else return false;
    }

    public void setBlockColor(int health){
        switch (this.getHealth()){
            case 9:
                this.setFill(colors[8]);
                break;
            case 8:
                this.setFill(colors[7]);
                break;
            case 7:
                this.setFill(colors[6]);
                break;
            case 6:
                this.setFill(colors[5]);
                break;
            case 5:
                this.setFill(colors[4]);
                break;
            case 4:
                this.setFill(colors[3]);
                break;
            case 3:
                this.setFill(colors[2]);
                break;
            case 2:
                this.setFill(colors[1]);
                break;
            case 1:
                this.setFill(colors[0]);
                break;
            default:
                this.setFill(colors[0]);
                break;
        }
    }

    public void setHealth(int health){
        this.health = health;
    }


}
