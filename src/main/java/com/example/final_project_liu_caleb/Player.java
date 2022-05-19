package com.example.final_project_liu_caleb;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Player extends Rectangle{
    private double posX;
    private double posY;

    //public Player(double pX, double pY, int w, int h, Color c){
    //  super(pX,pY,w,h,c);
    //}

    public Player(double posX, int w, int h, Color c){
        super(w,h,c);
        this.posX=posX;
    }

    //mouse control for player on the left
    private void movement(Canvas c){
        c.setOnMouseMoved(e->posY=e.getY());
    }


}
