package com.example.final_project_liu_caleb;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Game {
    private Circle ball;
    private Player player1;
    private Player player2;
    private Score score1;
    private Score score2;
    public boolean gameStarted=false;
    private int width;
    private int height;
    private Color color;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Timeline timeline;

    public Game(int w, int h, Color c, Player p1, Player p2, Score s1, Score s2, Circle b){
        width=w;
        height=h;
        color=c;
        player1=p1;
        player2=p2;
        score1=s1;
        score2=s2;
        ball=b;
        animation();
    }

    //method that'll refresh the graphicsContext to animate the different objects in the game
    public void animation(){
        canvas=new Canvas(width,height);
        graphicsContext=canvas.getGraphicsContext2D();
        //freeform animation defined by one or more keyframes and their duration
        timeline=new Timeline(new KeyFrame(Duration.millis(10), e->run(graphicsContext)));
        //defines the number of cycles in animation
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    //returns the timeline
    public Timeline getTimeline() {
        return timeline;
    }

    //returns canvas
    public Canvas getCanvas() {
        return canvas;
    }

    //returns the graphics context
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    //returns first score object (player 1: Ping)
    public Score getScore1() {
        return score1;
    }

    //returns second score object (player 2: Pong)
    public Score getScore2() {
        return score2;
    }

    //ball and bot movement
    public void run(GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(0,0,width,height);

        gc.setFill(ball.getColor());
        gc.setFont(Font.font(100));

        if(gameStarted){
            ball.movement();
            player1.movement(canvas);

            //bot movements
            if(ball.getPosX()<width-width/6){
                player2.setPosY(ball.getPosY()-player2.getHeight()/2);
            }
            else if(ball.getPosY()>player2.getPosY()+player2.getHeight()/2){
                player2.setPosY(player2.getPosY()+1);
            }
            else{
                player2.setPosY(player2.getPosY()-1);
            }

            //draw ball
            gc.fillOval(ball.getPosX(), ball.getPosY(), ball.getRadius(), ball.getRadius());
            score2.setScore(4);
            //score1.setScore(0);
        }
        else{
            if(!(score1.getScore()>=5||score2.getScore()>=5)){
                //set the replay screen
                gc.setStroke(Color.WHITE);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.strokeText("Replay",width/2, height/2);

                //resets the ball's position and speed
                ball.setPosX(width/2);
                ball.setPosY(height/2);
                ball.setSpeedX(1);
                ball.setSpeedY(1);
            }
            else{
                gc.setStroke(Color.WHITE);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.strokeText(score1.compareTo(score2),width/2, height/2);
                gc.strokeText("Back to menu",width/2, height/2+100);
                ball.setPosX(width/2);
                ball.setPosY(height/2);
                gameStarted=false;
            }
        }

        //makes ball stay in the canvas
        if(ball.getPosY()+ball.getRadius()>height || ball.getPosY()<0){
            ball.setSpeedY(ball.getSpeedY()*-1);
        }
        else if(ball.getPosX()+ball.getRadius()>width){
            ball.setSpeedX(ball.getSpeedX()*-1);
            score1.setScore(score1.getScore()+1);
            gameStarted=false;
        }
        else if(ball.getPosX()<0){
            ball.setSpeedX(ball.getSpeedX()*-1);
            score2.setScore(score2.getScore()+1);
            gameStarted=false;
        }

        //ball speed increase after collision with players
        if(((ball.getPosX()+ ball.getRadius()>player2.getPosX())&&ball.getPosY()>=player2.getPosY()&&ball.getPosY()<=player2.getPosY()+player2.getHeight())||
        ((ball.getPosX()<=player1.getPosX()+player1.getWidth())&&ball.getPosY()>=player1.getPosY()&&ball.getPosY()<= player1.getPosY()+player1.getHeight())){
            ball.speedIncrease();
        }

        gc.setFont(Font.font(50));
        gc.setFill(score1.getColor());
        gc.fillText(score1.getLabel().getText(),width/4,100);
        gc.fillText(score2.getLabel().getText(),3*width/4,100);

        //draw player1 && player2
        gc.setFill(player1.getColor());
        gc.fillRect(player1.getPosX(),player1.getPosY(),player1.getWidth(),player1.getHeight());
        gc.setFill(player2.getColor());
        gc.fillRect(player2.getPosX(),player2.getPosY(),player2.getWidth(),player2.getHeight());
    }
}
