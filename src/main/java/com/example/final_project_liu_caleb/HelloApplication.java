package com.example.final_project_liu_caleb;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage){
        SceneManager sm1=new SceneManager(stage);
        sm1.menu();

        stage.setTitle("Ping and Pong");
        stage.getScene().getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}