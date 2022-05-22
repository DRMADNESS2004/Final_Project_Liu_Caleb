package com.example.final_project_liu_caleb;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Score extends Rectangle implements ICountable{
    private Label label=new Label("0");
    private int score;

    public Score(int w, int h, Color c){
        super(w,h,c);
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
    public void compareTo(Label l) {
        int score1=Integer.parseInt(label.getText());
        int score2=Integer.parseInt(l.getText());

        if(score1>score2){
            Alert al1 = new Alert(Alert.AlertType.INFORMATION);
            al1.setTitle("Information Dialog");
            al1.setHeaderText("Winner");
            al1.setContentText("The winner is Ping");
            al1.showAndWait();
        }
        else if(score1<score2){
            Alert al1 = new Alert(Alert.AlertType.INFORMATION);
            al1.setTitle("Information Dialog");
            al1.setHeaderText("Winner");
            al1.setContentText("The winner is Pong");
            al1.showAndWait();
        }
    }
}
