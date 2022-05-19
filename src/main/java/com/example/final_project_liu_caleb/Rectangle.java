package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

public class Rectangle {
    private double width;
    private double height;
    private Color color;
    /*private double posY;
    private double posX;*/

    public Rectangle(/*double pX, double pY,*/ double w, double h, Color c){
        width=w;
        height=h;
        color=c;
        //posX=pX;
        //posY=pY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /*public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }*/
}
