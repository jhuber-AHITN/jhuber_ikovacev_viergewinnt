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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    Circle PlayerIndicator;
    @FXML
    public Circle B00;
    @FXML
    Circle B01;
    @FXML
    Circle B02;
    @FXML
    Circle B03;
    @FXML
    Circle B04;
    @FXML
    Circle B05;
    @FXML
    Circle B06;
    @FXML
    Circle B10;
    @FXML
    Circle B11;
    @FXML
    Circle B12;
    @FXML
    Circle B13;
    @FXML
    Circle B14;
    @FXML
    Circle B15;
    @FXML
    Circle B16;
    @FXML
    Circle B20;
    @FXML
    Circle B21;
    @FXML
    Circle B22;
    @FXML
    Circle B23;
    @FXML
    Circle B24;
    @FXML
    Circle B25;
    @FXML
    Circle B26;
    @FXML
    Circle B30;
    @FXML
    Circle B31;
    @FXML
    Circle B32;
    @FXML
    Circle B33;
    @FXML
    Circle B34;
    @FXML
    Circle B35;
    @FXML
    Circle B36;
    @FXML
    Circle B40;
    @FXML
    Circle B41;
    @FXML
    Circle B42;
    @FXML
    Circle B43;
    @FXML
    Circle B44;
    @FXML
    Circle B45;
    @FXML
    Circle B46;
    @FXML
    Circle B50;
    @FXML
    Circle B51;
    @FXML
    Circle B52;
    @FXML
    Circle B53;
    @FXML
    Circle B54;
    @FXML
    Circle B55;
    @FXML
    Circle B56;
    private static final int HÖHE = 6;
    private static final int BREITE = 7;
    private Circle[][] circles;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void Start(ActionEvent event) throws IOException {
        if (vierGewinnt==null) {
            URL u = getClass().getResource("playfield.fxml");
            Pane newLoadedPane = FXMLLoader.load(u);

            HboxPlaying.getChildren().add(newLoadedPane);
        }
        circles = new Circle[HÖHE][BREITE];
        fillCircles();
        Playfield playfield = new Playfield();
        playfield.Clear();
        vierGewinnt = new Game(new Player(UserLogin.player1name,UserLogin.player1symbol.charAt(0)), new Player(UserLogin.player2name,UserLogin.player2symbol.charAt(0)),playfield);
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
                System.out.println(Arrays.deepToString(circles));
                System.out.println(circles[i][j]);
                circles[i][j].setFill(color);
            }
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
        switch (vierGewinnt.GetCurrentPLayer().GetSymbol()){
            case 'R':
                    PlayerIndicator.setFill(Color.RED);
                break;
            case 'B':PlayerIndicator.setFill(Color.BLUE);
                break;
            case 'G':PlayerIndicator.setFill(Color.GREEN);
                break;
            case 'Y':PlayerIndicator.setFill(Color.YELLOW);
                break;
            case 'V':PlayerIndicator.setFill(Color.BLUEVIOLET);
                break;
        }
    }

    public void fillCircles(){
        circles[0][0] = B00;
        System.out.println("circles00: " + circles[0][0]);
        System.out.println("B00: " + B00);
        circles[0][1] = B01;
        circles[0][2] = B02;
        circles[0][3] = B03;
        circles[0][4] = B04;
        circles[0][5] = B05;
        circles[0][6] = B06;
        circles[1][0] = B10;
        circles[1][1] = B11;
        circles[1][2] = B12;
        circles[1][3] = B13;
        circles[1][4] = B14;
        circles[1][5] = B15;
        circles[1][6] = B16;
        circles[2][0] = B20;
        circles[2][1] = B21;
        circles[2][2] = B22;
        circles[2][3] = B23;
        circles[2][4] = B24;
        circles[2][5] = B25;
        circles[2][6] = B26;
        circles[3][0] = B30;
        circles[3][1] = B31;
        circles[3][2] = B32;
        circles[3][3] = B33;
        circles[3][4] = B34;
        circles[3][5] = B35;
        circles[3][6] = B36;
        circles[4][0] = B40;
        circles[4][1] = B41;
        circles[4][2] = B42;
        circles[4][3] = B43;
        circles[4][4] = B44;
        circles[4][5] = B45;
        circles[4][6] = B46;
        circles[5][0] = B50;
        circles[5][1] = B51;
        circles[5][2] = B52;
        circles[5][3] = B53;
        circles[5][4] = B54;
        circles[5][5] = B55;
        circles[5][6] = B56;
    }


}