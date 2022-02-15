package com.example.viergewinntv7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class UserLogin {
    public static String player1name="";
    public static String player2name="";
    public static String player1symbol="";
    public static String player2symbol="";

    protected Button choosenColor;

    @FXML
    TextField PlayerName;
    @FXML
    VBox VboxForLogin;
    @FXML
    Label ErrorMSG;
    @FXML
    Button PlayerButton;
    @FXML
    Label InfoText;
    @FXML
    public void CreatePlayer() throws IOException {
        if (player1name.equals("")){
            player1name= PlayerName.getText();
            player1symbol=choosenColor.getText();
            choosenColor.setDisable(true);
            PlayerName.setText("");

        } else if (!player1name.equals(PlayerName.getText())) {
            player2name= PlayerName.getText();
            player2symbol=choosenColor.getText();
            choosenColor.setDisable(true);
            VboxForLogin.setVisible(false);
            PlayerButton.setVisible(false);
            InfoText.setText("Close this window");
        } else {
            ErrorMSG.setText("Please don't use the same name as User1");
        }

    }
    @FXML
    public void ButtonPressed(ActionEvent event){
        choosenColor = (Button) event.getSource();
    }


}