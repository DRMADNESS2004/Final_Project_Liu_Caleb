package com.example.final_project_liu_caleb;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Game {
    private Circle ball;
    private Player player1;
    private Player player2;
    private Score score1;
    private Score score2;
    private Canvas canvas;
    private GraphicsContext gc1;
    public boolean gameStarted=false;
    private int width;
    private int height;

    public Game(int w, int h, Color c, Player p1, Player p2, Score s1, Score s2, Circle b){
        width=w;
        height=h;
        player1=p1;
        player2=p2;
        score1=s1;
        score2=s2;
        ball=b;
    }

    public GraphicsContext getGraph(){
        return gc1;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Scene getScene(){
        return new Scene(new StackPane(canvas));
    }

    //ball and bot movement
    public void run(GraphicsContext gc){
        /*gc.setFill(Color.GOLDENROD);
        gc.fillRect(0,0,800,500);*/
        if(gameStarted){
            ball.movement();

            //bot movements
            if(ball.getPosX()<width-width/4){
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
        }
        else{
            //set the start menu
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Start",width/2, height/2-50);
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Settings",width/2, height/2+50);

        }
    }
}
