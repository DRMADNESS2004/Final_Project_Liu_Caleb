package com.example.final_project_liu_caleb;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Score extends Rectangle implements ICountable{
    private HBox hbox=new HBox();
    private Label label=new Label("0");
    private int score;

    public Score(int w, int h, Color c){
        super(w,h,c);
        hbox.setMinWidth(w);
        hbox.setMinHeight(h);
        label.setStyle("-fx-background-color:"+c);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        label.setText(""+score);
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public String compareTo(Score s) {
        int score1=Integer.parseInt(label.getText());
        int score2=Integer.parseInt(s.getLabel().getText());

        if(score1>score2){
            return "Ping won!";
        }
        else{
            return "Pong won!";
        }
    }
}
