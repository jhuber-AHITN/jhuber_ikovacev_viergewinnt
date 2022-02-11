package com.example.viergewinntv7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private HBox HboxPlaying;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void CreatePlayField(ActionEvent event) throws IOException {
        URL u = getClass().getResource("playfield.fxml");
        Pane newLoadedPane =        FXMLLoader.load(u);
        HboxPlaying.getChildren().add(newLoadedPane);
    }
}