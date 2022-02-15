package com.example.viergewinntv7;

import com.example.viergewinntv7.model.Game;
import com.example.viergewinntv7.model.Player;
import com.example.viergewinntv7.model.Playfield;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class HelloController {
    protected  Game vierGewinnt;
    @FXML
    private Label welcomeText;
    @FXML
    private HBox HboxPlaying;
    @FXML
    Label PlayersTurnName;
    @FXML
    Label PlayersTurnSymbol;
    @FXML
    Label WinMsg;
    @FXML
    VBox VboxGame;
   

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void Start(ActionEvent event) throws IOException {
        URL u = getClass().getResource("playfield.fxml");
        Pane newLoadedPane =        FXMLLoader.load(u);
        HboxPlaying.getChildren().add(newLoadedPane);
        vierGewinnt = new Game(new Player(UserLogin.player1name,UserLogin.player1symbol.charAt(0)), new Player(UserLogin.player2name,UserLogin.player2symbol.charAt(0)),new Playfield());
        vierGewinnt.RandomPlayer();
        SwitchPlayer();
    }
    @FXML
    protected void PlaceStone(ActionEvent event){
        Button buttonPressed = (Button) event.getSource();
        System.out.println(buttonPressed.getText());
        vierGewinnt.Set(Integer.parseInt(buttonPressed.getText()));
        if (vierGewinnt.GetPlayfield().CheckWin(vierGewinnt.GetCurrentPLayer())){
            Win();
        }else {
            SwitchPlayer();
        }
    }

    protected void Win(){
        VboxGame.setVisible(false);
        WinMsg.setText(vierGewinnt.GetCurrentPLayer().GetName()+" Won the Game!");
    }
    @FXML
    protected void UndoLastMove(){
        vierGewinnt.Undo();
        SwitchPlayer();
    }
    protected void SwitchPlayer(){
        vierGewinnt.SwitchPlayer();
        PlayersTurnName.setText(vierGewinnt.GetCurrentPLayer().GetName());
        String text= String.valueOf(vierGewinnt.GetCurrentPLayer().GetSymbol());
        PlayersTurnSymbol.setText(text);
    }


}