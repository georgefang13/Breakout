# Breakout Design
## George Fang


## Design Goals
  * The goal of this design was to make adding new levels seamless. For example, if the user wants to add a level 4
    that includes a diamond hoe, they could easily create a .txt file and call it level 4.
  * New power-ups are also easy to add. If I wanted to make a block that creates new balls, I would simply add a
    color to 'private final static Color[] colors' variable in the Block class, and a new case to the 
    'public void setBlockColor(int health)' method in the Block class in which I would specify the power-up. 
  * Overall, the design goal was to make the game easily expandable and dynamic.

## High-Level Design
  * The Main class is the class that handles the setup and starting of the game. It creates the root and the scene,
    handles key presses, scans the level text files, checks for ball collisions with the various object using
    checkBallPaddleCollision(paddle, ball); checkBallBlockCollision(blocks, ball); checkBallWallCollision(ball); 
    methods, and other game related functions such as: updateBall(), gameOver(), and resetPowerUps()
  * The Ball class is the class that creates the ball object. Its constructor allows the user to create balls and
    set its radius, speed, and position. The ball class handles ball movement, and the actual bouncing off of 
    walls, blocks, and paddles. It also has the setSpeed() helper method and resetBall() method for main to use 
    when you use the cheat 'r' or it detects you have 0 lives.
  * The Block class is the class that creates the block object. Its constructor allows the user to create blocks 
    and set its color, position, and number of lives. Main is the primary user of blocks. It reads in the text files 
    which contains a 2D array of space delineated numbers that each represent a block and its health. The block class
    has 4 functions: getHealth() isDestroyed() setBlockColor() and setHealth() which do or check as they appear to.
  * The Paddle class is the class that creates the paddle object. Its constructor allows the user to create paddles
    and set its width, speed, and starting location. The paddle class itself is very simple. It only has two methods
    moveLeft() and moveRight() to control movement. The main method checks for the left and right key stroke and call
    the moveLeft() and moveRight() method from the Paddle class. 
  * The ScoreBoard class is the class that creates the scoreboard object. Its constructor allows the user to create 
    a scoreboard which has a predetermined starting number of lives (3), the level (1), and the players score (0).
    The various methods in ScoreBoard are: loseLife(), increaseScore(), setLevel(int newLevel), getLives(), 
    increaseLives(), getLevel(), getScore(), and setScore(int i). These allow main to modify the scoreboard as 
    needed. Everytime a block fully breaks, the score is incremented by one. Everytime the ball goes through the bottom
    of the screen the game is reset and the player loses a life. If the player selects 1 2 or 3 the scoreboard 
    reflects that by showing the level the player is on. Scoreboard is used in main by creating a new scoreboard
    and displaying its information on a Label object like so:
    scoreBoard = new ScoreBoard();
    score = new Label("Lives: " + scoreBoard.getLives() + " Level: " + scoreBoard.getLevel() + " Score: " + scoreBoard.getScore());

## Assumptions or Simplifications
  * The most obvious decision was to scan text files to create levels. Initially I created arrays within the main
    class but I knew that would get messy and hard to expand upon. Having the scanner allows users to simply add a
    new text time and rename it to level(#).
  * Another decision was to break up each individual object into its own class such as block, ball, and paddle.
    This allowed me to handle their individual functions seperately.
 
## Changes from the Plan
  * The main differences between the final and the plan were the lack of some features I would have liked to add:
    * Paddle can direct the ball based on which part of the paddle the ball hits
    * Paddle doesn't get stopped by the edge of the screen
    * Unbreakable block
    * Power-up that releases more balls into the game
    * Menu screen to choose level
    * Move onto the next level when you complete the level you're on
  * The biggest one I wish I could have gotten to work is paddle redirection based on where the ball hit on the paddle.

## How to Add New Levels
  * As mentioned above, if the user wants to add a level 4 that includes a diamond hoe, they could easily create 
    a .txt file with their design as a 2D array of numbers delineated by spaced and call it level4.txt
  * New power-ups are also easy to add. If I wanted to make a block that creates new balls, I would simply add a
    color to 'private final static Color[] colors' variable in the Block class, and a new case to the
    'public void setBlockColor(int health)' method in the Block class in which I would specify the power-up.
