package com.example.final_project_liu_caleb;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

//class that define a player's attributes, also defines how the players should move
public class Player extends Rectangle{
    private double posX;
    private double posY;

    //no-arg constructor
    public Player(){
        super(25,100,Color.BLACK);
    }

    //arg constructor
    public Player(double posX, int w, int h, Color c){
        super(w,h,c);
        this.posX=posX;
    }

    //returns the position of X
    public double getPosX() {
        return posX;
    }

    //sets the position of Y
    public void setPosY(double posY) {
        this.posY = posY;
    }

    //returns the position of X
    public double getPosY(){
        return posY;
    }

    //mouse control for player on the left
    public void movementMouse(Canvas c){
        c.setOnMouseMoved(e->posY=e.getY());
    }

    //bot movements
    public void movementBot(Circle c, int w){
        if(c.getPosX()<w-w/6){
            posY=c.getPosY()-getHeight()/2;
        }
        else if(c.getPosY()>posY+getHeight()/2){
            posY+=1;
        }
        else{
            posY-=1;
        }
    }
}
