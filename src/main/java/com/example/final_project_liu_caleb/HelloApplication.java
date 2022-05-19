package com.example.final_project_liu_caleb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        //Player p1=new Player(0,500,50,100, Color.BLUE);
        //Player p2=new Player(950,500,50,100, Color.BLUE);
        Player p1=new Player(0,50,100, Color.BLUE);
        Player p2=new Player(950,50,100, Color.BLUE);
        Score s1=new Score(50,50,Color.BLUE);
        Score s2=new Score(50,50,Color.BLUE);

        Game g1=new Game(800,500,Color.GRAY,p1,p2,s1,s2);
        Scene scene = g1.getScene();
        stage.setTitle("Ping and Pong");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}