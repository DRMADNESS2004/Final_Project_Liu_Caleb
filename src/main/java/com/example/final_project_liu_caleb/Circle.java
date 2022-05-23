package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

public class Circle {
    private double radius;
    private double posX;
    private double posY;
    private double speedX;
    private double speedY;
    private Color color;

    public Circle(){
        posX=400;
        posY=250;
        radius=25;
        color=Color.BLACK;
        speedX=1;
        speedY=1;
    }

    public Circle(double pX, double pY, double r, Color c, double sX, double sY){
        posX=pX;
        posY=pY;
        radius=r;
        color=c;
        speedX=sX;
        speedY=sY;
    }


    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void movement(){
        posX+=speedX;
        posY+=speedY;
    }
}
