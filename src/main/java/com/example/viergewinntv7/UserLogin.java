package com.example.viergewinntv7;


import com.example.viergewinntv7.view.EventView;
import com.example.viergewinntv7.view.EventViewGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    public static String player1name = "";
    public static String player2name = "";
    public static String player1symbol = "";
    public static String player2symbol = "";

    protected Button choosenColor;
    @FXML
    EventViewGUI eventPrint = new EventViewGUI();
    @FXML
    TextField PlayerName;
    @FXML
    VBox VboxForLogin;
    @FXML
    Label ErrorMSG;
    @FXML
    Label InfoText;

    class CreatePlayer implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Button b = (Button) actionEvent.getSource();
            VboxForLogin.getChildren().remove(b);
            if (player1name.equals("")) {
                player1name = PlayerName.getText();
                player1symbol = choosenColor.getText();
                choosenColor.setDisable(true);
                PlayerName.setText("");

            } else if (!player1name.equals(PlayerName.getText())) {
                player2name = PlayerName.getText();
                player2symbol = choosenColor.getText();
                choosenColor.setDisable(true);
                VboxForLogin.setVisible(false);
                HelloController.eventLabel = InfoText;
                eventPrint.PrintEvent("Close this window");
                try {
                    Stage stage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                    Scene scene = null;
                    scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else {
                HelloController.eventLabel = ErrorMSG;
                eventPrint.PrintEvent("Please don't use the same name as User1");
            }


        }
    }

    CreatePlayer createPlayer = new CreatePlayer();


    @FXML
    public void ButtonPressed(ActionEvent event) {
        choosenColor = (Button) event.getSource();
        Button b = new Button("Create Player");
        VboxForLogin.getChildren().add(b);
        b.setOnAction(createPlayer);
        VBox.setMargin(b,new Insets(0,0,0,130));
    }


}