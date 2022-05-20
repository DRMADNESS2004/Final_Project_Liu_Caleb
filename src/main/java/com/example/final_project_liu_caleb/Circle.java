package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

public class Circle {
    private double radius;
    private double posX=500;
    private double posY=250;
    private double speedX;
    private double speedY;
    private Color color;

    public Circle(double r, Color c, double sX, double sY){
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


    public void movement(){
        posX+=speedX;
        posY+=speedY;
    }
}
