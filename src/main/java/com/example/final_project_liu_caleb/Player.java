package com.example.final_project_liu_caleb;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Player extends Rectangle{
    private double posX;
    private double posY;

    public Player(){
        super(25,100,Color.BLACK);
    }

    public Player(double posX, int w, int h, Color c){
        super(w,h,c);
        this.posX=posX;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosY(){
        return posY;
    }

    //mouse control for player on the left
    public void movement(Canvas c){
        c.setOnMouseMoved(e->posY=e.getY());
    }


}
