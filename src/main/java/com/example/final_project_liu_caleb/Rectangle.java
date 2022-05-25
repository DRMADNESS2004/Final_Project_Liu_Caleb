package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

//abstract class (cannot be instantiated), player inherits from this class
public abstract class Rectangle {
    private int width;
    private int height;
    private Color color;

    //arg constructor
    public Rectangle(int w, int h, Color c){
        width=w;
        height=h;
        color=c;
    }

    //returns the width
    public int getWidth() {
        return width;
    }

    //returns the height
    public int getHeight() {
        return height;
    }

    //returns the color
    public Color getColor() {
        return color;
    }

}
