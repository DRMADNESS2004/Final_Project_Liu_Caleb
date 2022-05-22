package com.example.final_project_liu_caleb;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        Player p1=new Player(0,50,100, Color.BLUE);
        Player p2=new Player(750,50,100, Color.BLUE);
        Score s1=new Score(50,50,Color.BLUE);
        Score s2=new Score(50,50,Color.BLUE);
        Circle c1=new Circle(400,250,50,Color.PINK, 1,1);

        Game g1=new Game(800,500,Color.GRAY,p1,p2,s1,s2,c1);

        VBox vb1=new VBox(50);
        vb1.setMinWidth(800);
        vb1.setMinHeight(500);
        vb1.setAlignment(Pos.CENTER);
        Button start=new Button("Start");
        start.setOnAction(e->{
            g1.gameStarted=true;
            stage.setScene(new Scene(new StackPane(g1.getCanvas())));
        });
        Button settings=new Button("Settings");
        settings.setOnAction(e->{
            stage.setScene(settings());
        });
        vb1.getChildren().addAll(start,settings);

        g1.getCanvas().setOnMouseClicked(e->g1.gameStarted=true);
        stage.setTitle("Ping and Pong");
        if(!g1.gameStarted){
            stage.setScene(new Scene(vb1));
        }
        stage.show();
        g1.getTimeline().play();
    }


    public static void main(String[] args) {
        launch(args);
    }

    //settings scene
    private Scene settings(){
        HBox hb1=new HBox();
        hb1.setMinWidth(800);
        hb1.setMinHeight(500);
        TextField tf1=new TextField("Width of canvas");
        TextField tf2=new TextField("Height of canvas");
        TextField tf3=new TextField("Color of canvas");

        TextField tf4=new TextField("Radius of ball");
        TextField tf5=new TextField("Color of ball");
        TextField tf6=new TextField("Speed x of ball");
        TextField tf7=new TextField("Speed y of ball");

        TextField tf8=new TextField("Width of Ping");
        TextField tf9=new TextField("Height of Ping");
        TextField tf10=new TextField("Color of Ping");

        TextField tf11=new TextField("Width of Pong");
        TextField tf12=new TextField("Height of Pong");
        TextField tf13=new TextField("Color of Pong");

        Scene settings=new Scene(hb1);
        return settings;
    }
}