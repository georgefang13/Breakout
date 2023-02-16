# Breakout Plan
### George Fang


#### Examples

You need to put blank lines to write some text

in separate paragraphs.


Emphasis, aka italics, with *asterisks* or _underscores_.

Strong emphasis, aka bold, with **asterisks** or __underscores__.

Combined emphasis with **asterisks and _underscores_**.


You can also make lists:
* Bullets are made with asterisks
1. You can order things with numbers.


You can put links in like this: [Duke CompSci](https://www.cs.duke.edu)



## Interesting Breakout Variants

 * Idea #1: Brick Breaker is the most intriguing to me because it is the version I grew up playing on my mom's 
blackberry way back in the day. I think its interesting how each time it hits the paddle, the screen shifts down a few
pixels to increase the urgency and add difficulty. 

 * Idea #2: Bricks n Balls sounds interesting to me and something I would like to implement in conjunction with
brick breaker. The ability to shoot and do more with your paddle than just hit the ball is something I want to try!


## Paddle Ideas

 * Idea #1: RNG makes it so every 1/10 hits of the brick, a paddle power occurs which elongates the paddle, gives
the paddle laser beams, allows it to catch and aim, etc. for a 10-second window.

 * Idea #2: Middle third cause the ball to bounce normally, the left and right thirds cause the ball to bounce back
in the direction it came


## Block Ideas

 * Idea #1: Drops power up randomly on every 10th hit, or an equivalent RNG.

 * Idea #2: Different colored blocks take different number of hits, each hit brings it to the next color scheme. 

 * Idea #3: Some indestructible bricks that don't need to be killed, but act as an obstacle.


## Power-up Ideas

 * Idea #1: Triple shot which adds 3 balls to the game.

 * Idea #2: Slows down the ball.

 * Idea #3: Bad Idea: Screen flashes for 5 seconds (1 second black, one normal, one black, one normal...)


## Cheat Key Ideas

 * Idea #1: Full screen wide bar.

 * Idea #2: Remove all bricks of the highest # hit variety.

 * Idea #3: Adds 20 balls randomly throughout the screen.

 * Idea #4: Ball hit counts for full amount of block, regardless of color.


## Level Descriptions

 * Idea #1: Minecraft shovel. This is the easier level, has less 5 blocks, will a 1/50 chance of getting a 
cheat key. 
13x15
0 0 0 0 0 0 0 0 0 0 3 3 3 0 0
0 0 0 0 0 0 0 0 0 3 5 5 4 3 0
0 0 0 0 0 0 0 0 3 5 4 4 5 3 0
0 0 0 0 0 0 0 3 5 4 4 4 5 3 0
0 0 0 0 0 0 0 0 1 4 4 5 3 0 0
0 0 0 0 0 0 0 1 2 1 5 3 0 0 0
0 0 0 0 0 0 1 2 1 0 3 0 0 0 0
0 0 0 0 0 1 2 1 0 0 0 0 0 0 0
0 0 0 0 1 2 1 0 0 0 0 0 0 0 0
0 0 0 1 2 1 0 0 0 0 0 0 0 0 0
0 1 1 2 1 0 0 0 0 0 0 0 0 0 0
0 1 2 1 0 0 0 0 0 0 0 0 0 0 0
0 0 1 1 0 0 0 0 0 0 0 0 0 0 0


 * Idea #2: Minecraft pickaxe. Medium level, more higher number blocks, ball speed x1.5, 1/40 chance of cheat key.
13 x 15
0 0 0 0 0 3 3 3 3 3 0 0 0 0 0
0 0 0 0 3 5 4 4 4 4 3 1 2 0 0
0 0 0 0 0 3 3 3 3 4 4 2 1 0 0 
0 0 0 0 0 0 0 0 0 1 5 4 3 0 0
0 0 0 0 0 0 0 0 1 2 1 4 4 3 0
0 0 0 0 0 0 0 1 2 1 0 3 4 3 0
0 0 0 0 0 0 1 2 1 0 0 3 4 3 0
0 0 0 0 0 1 2 1 0 0 0 3 4 3 0 
0 0 0 0 1 2 1 0 0 0 0 3 4 3 0
0 0 0 1 2 1 0 0 0 0 0 0 3 0 0 
0 0 1 2 1 0 0 0 0 0 0 0 0 0 0
0 1 2 1 0 0 0 0 0 0 0 0 0 0 0
0 2 1 0 0 0 0 0 0 0 0 0 0 0 0

 * Idea #3: Minecraft sword. Hardest level. Ball 2x speed with 1.01x speed increase for every bounce on the paddle.
1/30 chance of cheat key.
18x18
0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 0
0 0 0 0 0 0 0 0 0 0 0 0 0 3 5 4 3 0
0 0 0 0 0 0 0 0 0 0 0 0 3 5 4 5 3 0
0 0 0 0 0 0 0 0 0 0 0 3 5 4 5 3 0 0
0 0 0 0 0 0 0 0 0 0 3 5 4 5 3 0 0 0
0 0 0 0 0 0 0 0 0 3 5 4 5 3 0 0 0 0
0 0 0 3 3 0 0 0 3 5 4 5 3 0 0 0 0 0
0 0 0 3 4 3 0 3 5 4 5 3 0 0 0 0 0 0
0 0 0 0 3 4 3 5 4 5 3 0 0 0 0 0 0 0
0 0 0 0 3 4 3 4 5 3 0 0 0 0 0 0 0 0
0 0 0 0 0 3 4 3 3 0 0 0 0 0 0 0 0 0
0 0 0 0 1 2 3 4 4 3 0 0 0 0 0 0 0 0
0 0 0 1 2 1 0 3 3 4 3 0 0 0 0 0 0 0
0 3 3 2 1 0 0 0 0 3 3 0 0 0 0 0 0 0
0 3 4 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 3 3 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

SEE ASSETS


## Class Ideas

 * Idea #1: Ball: move() - update the position of the ball based on its velocity and direction.
checkCollision(Block b) - check if the ball has collided with a block and update the block's health if necessary.
checkCollision(Paddle p) - check if the ball has collided with the paddle and update its direction based on where 
it hit the paddle.

 * Idea #2: Block: isHit() - decrease the block's health by a certain amount when it is hit by the ball
and check if the block's health has reached zero and return a Boolean value indicating whether the block 
should be removed from the game.
render() - draw the block on the game screen

 * Idea #3: Paddle: move() - update the position of the paddle based on user input.
setSize() - set the size of the paddle


 * Idea #4: Level:
generateBlocks() - create and position the blocks for a particular level based on a 
predefined layout or algorithm.
isComplete() - check if all the blocks in the level have been destroyed and return a Boolean value 
indicating whether the level is complete.
nextLevel() - load the next level in the game


