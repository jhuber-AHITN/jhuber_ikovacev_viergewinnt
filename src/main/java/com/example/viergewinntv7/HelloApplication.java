package com.example.viergewinntv7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("UserLogin.fxml"));
        Scene SceneLogin= new Scene(fxmlLoader2.load());
        Stage stage1 = new Stage();
        stage1.setScene(SceneLogin);
        stage1.show();


    }

    public static void main(String[] args) {
        launch();
    }
}