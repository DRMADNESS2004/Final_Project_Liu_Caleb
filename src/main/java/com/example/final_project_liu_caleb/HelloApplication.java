package com.example.final_project_liu_caleb;

import javafx.application.Application;
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