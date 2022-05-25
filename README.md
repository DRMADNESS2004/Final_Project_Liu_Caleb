Ping and Pong

This game, made using Javafx, is called Ping and Pong. It is a two-player game in which 
the user(controlled by the position of the mouse) will fight against a simple bot. To gain a point, the players
have to make the ball touch the opponent’s side. In Ping and Pong, the balls’ 
speed, its radius, its color, the width, height, color of the players can be determined by the user's inputs 
in the settings menu. Over time, the speed of the ball will increase which will make the game more challenging to beat.

To build the game, I had to resort to classes such as Canvas, GraphicsContext, Timeline to handle the
animations of the objects. I also had to use a mouse click event to reset the position of the ball
after a point or to reset the points of the two players. 

One of the challenges I faced along the way was that I didn't really know how the animation classes worked since
we never learned it in class. I got stuck a lot early on since I hadn't included certain methods of these
classes to make the animations work and to make the game appear. Another one of the challenges was that
I was struggling to link scenes together since we also had never learned that before. I knew it was possible,
but that also took a lot of time to figure out as I was trying various methods to find the solution.

My Game class has 2 players, 2 scores, 1 circle(ball), a canvas, a graphics context, a timeline, etc. It
handles all the methods and behaviours of the elements in my game by putting them together. The run method
is constantly called because of the timeline which allows certain elements to be animated. The Player class inherits
Rectangle class. It also handles the positioning of Ping(the player being controlled using mouse). The Rectangle
class is abstract, so it cannot be instantiated. The Circle class creates the ball. It contains methods
that randomize its direction, that increase the speed according to the direction of the ball, that 
moves its position X and Y. The ICountable interface contains 2 methods. One of them resets the 2 
scores and the other compares them to return a winner. The Score class keeps count of the scores. It 
also contains a method to increment the score. It implements ICountable. 


