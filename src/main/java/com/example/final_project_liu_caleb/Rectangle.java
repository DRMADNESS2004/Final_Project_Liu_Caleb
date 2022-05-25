package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

//abstract class (cannot be instantiated), player inherits from this class
public abstract class Rectangle {
    private double width;
    private double height;
    private Color color;

    //arg constructor
    public Rectangle(double w, double h, Color c){
        width=w;
        height=h;
        color=c;
    }

    //returns the width
    public double getWidth() {
        return width;
    }

    //returns the height
    public double getHeight() {
        return height;
    }

    //returns the color
    public Color getColor() {
        return color;
    }

}
