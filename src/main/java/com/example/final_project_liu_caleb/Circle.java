package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

public class Circle {
    private double radius;
    private double posX;
    private double posY;
    private double speedX;
    private double speedY;
    private Color color;

    //no-arg constructor
    public Circle(){
        posX=400;
        posY=250;
        radius=25;
        color=Color.BLACK;
        speedX=1;
        speedY=1;
    }

    //arg constructor
    public Circle(double pX, double pY, double r, Color c, double sX, double sY){
        posX=pX;
        posY=pY;
        radius=r;
        color=c;
        speedX=sX;
        speedY=sY;
    }

    //returns the position of X
    public double getPosX() {
        return posX;
    }

    //sets the position of X
    public void setPosX(double posX) {
        this.posX = posX;
    }

    //returns the position of Y
    public double getPosY() {
        return posY;
    }

    //sets the positon of Y
    public void setPosY(double posY) {
        this.posY = posY;
    }

    //returns the radius
    public double getRadius() {
        return radius;
    }

    //returns the color
    public Color getColor() {
        return color;
    }

    //returns the speed of X
    public double getSpeedX() {
        return speedX;
    }

    //returns the speed of Y
    public double getSpeedY() {
        return speedY;
    }

    //sets the speed of X
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    //sets the speed of Y
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    //modifies the position X and Y according to the speed when called
    public void movement(){
        posX+=speedX;
        posY+=speedY;
    }

    //increases the speed accordingly to its direction when called
    public void speedIncrease(){
        if(speedX<0){
            speedX-=1;
        }
        else{
            speedX+=0.5;
        }
        if(speedY<0){
            speedY-=0.5;
        }
        else{
            speedY+=0.5;
        }
        speedX*=-1;
    }
}
