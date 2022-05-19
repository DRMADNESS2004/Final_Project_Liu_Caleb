package com.example.final_project_liu_caleb;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Game {
    private Circle ball;
    private Player player1;
    private Player player2;
    private Score score1;
    private Score score2;
    private Canvas canvas;

    public Game(int w, int h, Color c, Player p1, Player p2, Score s1, Score s2){
        canvas=new Canvas(w,h);
        GraphicsContext gc1=canvas.getGraphicsContext2D();
        gc1.setFill(c);
        gc1.fillRect(0,0,w,h);
        //freeform animation defined by one or more keyframes and their duration
        Timeline t1=new Timeline(new KeyFrame(Duration.millis(10), e->run(gc1)));
        //defines the number of cycles in animation
        t1.setCycleCount(Timeline.INDEFINITE);
        player1=p1;
        player2=p2;
        score1=s1;
        score2=s2;
    }

    public Scene getScene(){
        return new Scene(new StackPane(canvas));
    }

    private void run(GraphicsContext gc){

    }
}
