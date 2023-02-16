package breakout;

//ChatGPT made this class
public class ScoreBoard {
    private int lives;
    private int level;
    private int score;

    public ScoreBoard() {
        lives = 3;
        level = 1;
        score = 0;
    }

    public void loseLife() {
        lives--;
    }

    public void increaseScore() {
        score += 1;
    }

    public void setLevel(int newLevel) {
        level = newLevel;
    }

    public int getLives() {
        return lives;
    }
    public void increaseLives() {
        lives += 1;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int i) {
        score = i;
    }
}

