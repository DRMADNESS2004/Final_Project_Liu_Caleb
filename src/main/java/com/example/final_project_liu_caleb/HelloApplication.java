package com.example.final_project_liu_caleb;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        //Player p1=new Player(0,500,50,100, Color.BLUE);
        //Player p2=new Player(950,500,50,100, Color.BLUE);
        Player p1=new Player(0,50,100, Color.BLUE);
        Player p2=new Player(950,50,100, Color.BLUE);
        Score s1=new Score(50,50,Color.BLUE);
        Score s2=new Score(50,50,Color.BLUE);
        Circle c1=new Circle(5,Color.BLACK, 1,1);

        Game g1=new Game(800,500,Color.GRAY,p1,p2,s1,s2,c1);



        /*Button start=new Button("Start");
        start.setOnAction(e->{
            g1.gameStarted=true;
        });
        Button settings=new Button("Settings");
        settings.setOnAction(e->{
        });*/

        Canvas canvas=new Canvas(800,500);
        GraphicsContext gc=canvas.getGraphicsContext2D();

        //freeform animation defined by one or more keyframes and their duration
        Timeline t1=new Timeline(new KeyFrame(Duration.millis(10), e->g1.run(gc)));
        //defines the number of cycles in animation
        t1.setCycleCount(Timeline.INDEFINITE);

        p1.movement(canvas);
        canvas.setOnMouseClicked(e->g1.gameStarted=true);
        Scene scene = new Scene(new StackPane(canvas));
        stage.setTitle("Ping and Pong");
        stage.setScene(scene);
        stage.show();
        t1.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}