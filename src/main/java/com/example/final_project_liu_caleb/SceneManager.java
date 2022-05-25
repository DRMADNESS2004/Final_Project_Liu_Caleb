package com.example.final_project_liu_caleb;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//class that handles the changes in scenes
public class SceneManager {
    private  int canWidth;
    private  int canHeight;
    private  Color canColor=Color.rgb(23, 138, 252);
    private  double radius;
    private  Color ballColor;
    private  double speedX;
    private  double speedY;
    private  int p1Width;
    private  int p1Height;
    private  Color p1Color;
    private  int p2Width;
    private  int p2Height;
    private  Color p2Color;
    private Player p1;
    private Player p2;
    private Circle c1;
    private Score s1;
    private Score s2;
    private Game g1;
    private Stage stage;

    //arg constructor
    public SceneManager(Stage s) throws ExceptionInInitializerError{
        stage=s;
    }

    //menu scene
    public void menu(){
        gameAppearance();

        VBox vb1=new VBox(50);
        vb1.setMinWidth(800);
        vb1.setMinHeight(500);
        vb1.setAlignment(Pos.CENTER);

        Label title=new Label("Ping and Pong");
        title.setStyle("-fx-font-size: 50pt ; -fx-text-fill: #ffffff");

        Button start=new Button("Start");
        start.setStyle("-fx-font-size: 30pt; -fx-background-color: #f7dab0; -fx-border-color: #f27216;-fx-text-fill: #f5b75b;");
        start.setOnAction(e->{
            g1.gameStarted=true;
            stage.setScene(new Scene(new StackPane(g1.getCanvas())));
            g1.getTimeline().play();
        });
        Button settings=new Button("Settings");
        settings.setStyle("-fx-font-size: 30pt; -fx-background-color: #f7dab0; -fx-border-color: #f27216;-fx-text-fill: #f5b75b;");
        settings.setOnAction(e->{
            settings();
        });
        vb1.getChildren().addAll(title,start,settings);
        vb1.setStyle("-fx-background-color: #f5b75b;");
        stage.setScene(new Scene(vb1));
    }

    //settings scene
    public void settings(){
        VBox vb1=new VBox(15);
        vb1.setMinWidth(canWidth);
        vb1.setMinHeight(canHeight);
        vb1.setAlignment(Pos.CENTER);

        Label settingsTitle=new Label("Settings");
        settingsTitle.setStyle("-fx-font-size: 20pt ; -fx-text-fill: #ffffff; -fx-font-weight: bold;");

        //settings for the canvas
        VBox vb2=new VBox(5);
        vb2.setMaxWidth(canWidth/2);
        TextField tf1=new TextField();
        tf1.setPromptText("Width of canvas");
        tf1.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf2=new TextField();
        tf2.setPromptText("Height of canvas");
        tf2.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf3=new TextField();
        tf3.setPromptText("Color of canvas       #Hex (000000 - ffffff)");
        tf3.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        vb2.getChildren().addAll(tf1,tf2,tf3);

        //settings for the ball
        VBox vb3=new VBox(5);
        vb3.setMaxWidth(canWidth/2);
        TextField tf4=new TextField();
        tf4.setPromptText("Radius of ball");
        tf4.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf5=new TextField();
        tf5.setPromptText("Color of ball            #Hex (000000 - ffffff)");
        tf5.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf6=new TextField();
        tf6.setPromptText("Speed x of ball");
        tf6.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf7=new TextField();
        tf7.setPromptText("Speed y of ball");
        tf7.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        vb3.getChildren().addAll(tf4,tf5,tf6,tf7);

        //settings for Ping(the player being controlled using mouse)
        VBox vb4=new VBox(5);
        vb4.setMaxWidth(canWidth/2);
        TextField tf8=new TextField();
        tf8.setPromptText("Width of Ping");
        tf8.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf9=new TextField();
        tf9.setPromptText("Height of Ping");
        tf9.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf10=new TextField();
        tf10.setPromptText("Color of Ping            #Hex (000000 - ffffff)");
        tf10.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        vb4.getChildren().addAll(tf8,tf9,tf10);

        //settings for Pong, the player being controlled by a bot
        VBox vb5=new VBox(5);
        vb5.setMaxWidth(canWidth/2);
        TextField tf11=new TextField();
        tf11.setPromptText("Width of Pong");
        tf11.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf12=new TextField();
        tf12.setPromptText("Height of Pong");
        tf12.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        TextField tf13=new TextField();
        tf13.setPromptText("Color of Pong            #Hex (000000 - ffffff)");
        tf13.setStyle("-fx-background-color: #84e8d0; -fx-text-fill: #ffffff; -fx-font-size: 10pt;");
        vb5.getChildren().addAll(tf11,tf12,tf13);

        Button goBack=new Button("Return");
        goBack.setOnAction(e->{
            //check if the values entered were not correct or empty
            try{
                canWidth=Integer.parseInt(tf1.getText());
                canHeight=Integer.parseInt(tf2.getText());
                canColor= Color.valueOf(tf3.getText());
            }
            catch(Exception a){
                //a.printStackTrace();
                canWidth=0;
                canHeight=0;
                canColor=Color.rgb(23, 138, 252);
            }

            try{
                radius= Double.parseDouble(tf4.getText());
                ballColor=Color.valueOf(tf5.getText());
                speedX=Double.parseDouble(tf6.getText());
                speedY=Double.parseDouble(tf7.getText());
            }
            catch(Exception a){
                //a.printStackTrace();
                radius=0;
                ballColor=Color.BLACK;
                speedX=1;
                speedY=1;
            }

            try{
                p1Width=Integer.parseInt(tf8.getText());
                p1Height=Integer.parseInt(tf9.getText());
                p1Color=Color.valueOf(tf10.getText());
            }
            catch(Exception a){
                //a.printStackTrace();
                p1Width=0;
                p1Height=0;
                p1Color=Color.BLACK;
            }

            try{
                p2Width=Integer.parseInt(tf11.getText());
                p2Height=Integer.parseInt(tf12.getText());
                p2Color=Color.valueOf(tf13.getText());
            }
            catch(Exception a){
                //a.printStackTrace();
                p2Width=0;
                p2Height=0;
                p2Color=Color.BLACK;
            }

            menu();
        });
        goBack.setStyle("-fx-font-size: 10pt; -fx-background-color: #84e8d0; -fx-border-color: #d3f2ee;-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 5; -fx-border-radius: 5;");

        vb1.getChildren().addAll(settingsTitle,vb2,vb3,vb4,vb5,goBack);
        vb1.setStyle("-fx-background-color: #08bd92");
        stage.setScene(new Scene(vb1));
    }

    //sets the attributes of the elements in Ping and Pong(game title)
    public void gameAppearance(){
        if(canWidth<=200){
            canWidth=800;
        }
        if(canHeight<=200){
            canHeight=500;
        }

        if(p1Width<=0||p1Height<=0){
            p1=new Player();
        }
        else{
            p1=new Player(0,p1Width,p1Height,p1Color);
        }
        if(p2Width<=0||p2Height<=0){
            p2Width=25;
            p2=new Player(canWidth-p2Width,25,100, Color.rgb(151, 199, 247));
        }
        else{
            p2=new Player(canWidth-p2Width,p2Width,p2Height,p2Color);
        }
        double posX=canWidth/2;
        double posY=canHeight/2;
        if(radius<=0){
            c1=new Circle();
            c1.setPosX(posX);
            c1.setPosY(posY);
        }
        else{
            c1=new Circle(posX-radius,posY-radius,radius,ballColor,speedX,speedY);
        }

        s1=new Score(Color.rgb(135, 217, 237));
        s2=new Score(Color.rgb(135, 217, 237));

        SceneManager sm1=new SceneManager(stage);
        g1=new Game(canWidth,canHeight,canColor,p1,p2,s1,s2,c1,sm1);
    }
}
