package com.example.final_project_liu_caleb;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class HelloApplication extends Application {
    private TextField tf1=new TextField();
    private TextField tf2=new TextField();
    private TextField tf3=new TextField();
    private TextField tf4=new TextField();
    private TextField tf5=new TextField();
    private TextField tf6=new TextField();
    private TextField tf7=new TextField();
    private TextField tf8=new TextField();
    private TextField tf9=new TextField();
    private TextField tf10=new TextField();
    private TextField tf11=new TextField();
    private TextField tf12=new TextField();
    private TextField tf13=new TextField();
    private int width=800;
    private int height=500;

    @Override
    public void start(Stage stage){
        Player p1;
        Player p2;
        Circle c1;
        Color color=Color.GRAY;
        if(!tf1.getText().equals("")){
            width=Integer.parseInt(tf1.getText());
        }
        if(!tf2.getText().equals("")){
            height=Integer.parseInt(tf2.getText());
        }
        if(!tf3.getText().equals("")){
            color= Color.valueOf(tf3.getText());
        }

        if(tf8.getText().equals("")||tf9.getText().equals("")||tf10.getText().equals("")){
            p1=new Player();
        }
        else{
            p1=new Player(0,50,100, Color.BLUE);
        }
        if(tf11.getText().equals("")||tf12.getText().equals("")||tf13.getText().equals("")){
            p2=new Player(750,50,100, Color.BLUE);
        }
        else{
            p2=new Player(width-Integer.parseInt(tf11.getText()),25,100, Color.BLUE);
        }
        if(tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals("")){
            c1=new Circle();
        }
        else{
            c1=new Circle(400,250,50,Color.PINK, 1,1);
        }

        Score s1=new Score(50,50,Color.BLUE);
        Score s2=new Score(50,50,Color.BLUE);

        Game g1;

        if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")){
            g1=new Game(800,500,Color.GREY,p1,p2,s1,s2,c1);
        }
        else{
            g1=new Game(width,height,color,p1,p2,s1,s2,c1);
        }

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
        stage.getScene().getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
        g1.getTimeline().play();
    }


    public static void main(String[] args) {
        launch(args);
    }

    //settings scene
    private Scene settings(){
        VBox vb1=new VBox(50);
        vb1.setMinWidth(width);
        vb1.setMinHeight(height);
        vb1.setAlignment(Pos.CENTER);

        VBox vb2=new VBox();
        vb2.setMaxWidth(width/2);
        tf1=new TextField();
        tf1.setPromptText("Width of canvas");
        tf2=new TextField();
        tf2.setPromptText("Height of canvas");
        tf3=new TextField();
        tf3.setPromptText("Color of canvas");
        vb2.getChildren().addAll(tf1,tf2,tf3);

        VBox vb3=new VBox();
        vb3.setMaxWidth(width/2);
        tf4=new TextField();
        tf4.setPromptText("Radius of ball");
        tf5=new TextField();
        tf5.setPromptText("Color of ball");
        tf6=new TextField();
        tf6.setPromptText("Speed x of ball");
        tf7=new TextField();
        tf7.setPromptText("Speed y of ball");
        vb3.getChildren().addAll(tf4,tf5,tf6,tf7);

        VBox vb4=new VBox();
        vb4.setMaxWidth(width/2);
        tf8=new TextField();
        tf8.setPromptText("Width of Ping");
        tf9=new TextField();
        tf9.setPromptText("Height of Ping");
        tf10=new TextField();
        tf10.setPromptText("Color of Ping");
        vb4.getChildren().addAll(tf8,tf9,tf10);

        VBox vb5=new VBox();
        vb5.setMaxWidth(width/2);
        tf11=new TextField();
        tf11.setPromptText("Width of Pong");
        tf12=new TextField();
        tf12.setPromptText("Height of Pong");
        tf13=new TextField();
        tf13.setPromptText("Color of Pong");
        vb5.getChildren().addAll(tf11,tf12,tf13);

        vb1.getChildren().addAll(vb2,vb3,vb4,vb5);

        Scene settings=new Scene(vb1);
        return settings;
    }
}