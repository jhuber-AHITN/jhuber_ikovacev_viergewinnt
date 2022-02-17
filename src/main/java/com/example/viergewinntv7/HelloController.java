package com.example.viergewinntv7;

import com.example.viergewinntv7.model.Game;
import com.example.viergewinntv7.model.Player;
import com.example.viergewinntv7.model.Playfield;
import com.example.viergewinntv7.view.EventViewGUI;
import com.example.viergewinntv7.view.FieldViewGUI;
import com.example.viergewinntv7.view.PlayerViewGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class HelloController {
    protected  Game vierGewinnt;
    protected PlayerViewGUI playerPrint;
    protected EventViewGUI eventPrint;
    PlayfieldController pfc;
    public static Label eventLabel;


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
    Circle PlayerIndicator;

    private static final int HÖHE = 6;
    private static final int BREITE = 7;
    private Circle[][] circles;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void Start(ActionEvent event) throws IOException {
        playerPrint = new PlayerViewGUI(PlayersTurnName,PlayerIndicator);
        eventPrint = new EventViewGUI();
        if (vierGewinnt==null) {
            URL u = getClass().getResource("playfield.fxml");
            Pane newLoadedPane = FXMLLoader.load(u);

            HboxPlaying.getChildren().add(newLoadedPane);
        }
        pfc = PlayfieldController.getPlayfieldController();
        circles = pfc.getCircles();


        Playfield playfield = new Playfield();
        playfield.Clear();
        vierGewinnt = new Game(new Player(UserLogin.player1name,UserLogin.player1symbol.charAt(0)), new Player(UserLogin.player2name,UserLogin.player2symbol.charAt(0)),playfield);
        vierGewinnt.RandomPlayer();
        SwitchPlayer();
        ColorCircles();
    }
    @FXML
    protected void PlaceStone(ActionEvent event){
        Button buttonPressed = (Button) event.getSource();
        vierGewinnt.Set(Integer.parseInt(buttonPressed.getText()));
        if (vierGewinnt.GetPlayfield().CheckWin(vierGewinnt.GetCurrentPLayer())){
            Win();
        }else {
            SwitchPlayer();
        }

        ColorCircles();

    }

    public void ColorCircles() {
        char[][] field = vierGewinnt.GetPlayfield().getFieldArray();
        Color color;
        for (int i = 0; i < HÖHE; i++) {
            for (int j = 0; j < BREITE; j++) {
                switch (field[i][j]){
                    case 'R':
                        color = Color.RED;
                        break;
                    case 'B':
                        color = Color.BLUE;
                        break;
                    case 'G':
                        color = Color.GREEN;
                        break;
                    case 'Y':
                        color = Color.YELLOW;
                        break;
                    case 'V':
                        color = Color.BLUEVIOLET;
                        break;
                    default:
                        color = Color.TRANSPARENT;
                        break;
                }
                FieldViewGUI.UpdateCircle(color, circles[i][j]);
            }
        }
    }

    protected void Win(){
        VboxGame.setVisible(false);
        eventLabel = WinMsg;
        eventPrint.PrintEvent(vierGewinnt.GetCurrentPLayer().GetName()+" Won the Game!");
    }
    @FXML
    protected void UndoLastMove(){
        vierGewinnt.Undo();
        ColorCircles();
        SwitchPlayer();

    }
    protected void SwitchPlayer(){
        vierGewinnt.SwitchPlayer();
        playerPrint.PrintPlay(vierGewinnt.GetCurrentPLayer());
    }





}