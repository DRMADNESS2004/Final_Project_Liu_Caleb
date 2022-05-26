package com.example.final_project_liu_caleb;

import javafx.scene.paint.Color;

//class that keeps track of the score, also implements ICountable, it can add pts
public class Score implements ICountable{
    private int score;
    private Color color;

    //no-arg constructor
    public Score(){
        color=Color.AQUA;
    }

    //arg constructor
    public Score(Color c){
        color=c;
    }

    //returns the color
    public Color getColor() {
        return color;
    }

    //returns the score
    public int getScore() {
        return score;
    }

    //sets the score
    public void setScore(int score) {
        this.score = score;
    }

    //adds point to the player's score
    public void addPts(){
        score++;
    }

    @Override
    //compares the scores between the two players
    public String compareTo(Score s) {
        int score2=s.getScore();

        if(score>score2){
            return "Ping won!";
        }
        else{
            return "Pong won!";
        }
    }
}
