package com.example.viergewinntv7.controller;

import com.example.viergewinntv7.model.Game;
import com.example.viergewinntv7.model.Player;
import com.example.viergewinntv7.model.Playfield;
import com.example.viergewinntv7.view.*;

import java.util.Objects;
import java.util.Scanner;

public class ControllerConsole {
    static EventView event = new EventViewConsole();
    static FieldView fieldView = new FieldViewConsole();
    static PlayerView playerView = new PlayerViewConsole();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String undo;
        Integer choosenColumn = 0;


        do {


            Game fourWins = Initialize();
            fourWins.RandomPlayer();
            fieldView.Prientfield(fourWins.getPlayfield().toString());


            while (!fourWins.getPlayfield().CheckWin(fourWins.getCurrentPLayer()) && !fourWins.getPlayfield().CheckDraw()) {
                fourWins.SwitchPlayer();
                do {
                    playerView.PrintPlay("\n" + fourWins.getCurrentPLayer().getName());
                    event.PrintEvent(" Select a column to place your Symbol: \n");
                    fourWins.SwitchPlayer();
                    event.PrintEvent("If " + fourWins.getCurrentPLayer().getName() + " wants to undo their move press \"u\":\n");
                    fourWins.SwitchPlayer();

                    undo = input.next();
                    if (!undo.equals("u")){
                    choosenColumn = Integer.parseInt(undo);
                    }

                } while ((choosenColumn < 0 || choosenColumn  > 6) && !undo.equals("u"));

                if (undo.equals("u")){
                    fourWins.undo();
                } else{
                    fourWins.set(choosenColumn);
                }


                fieldView.Prientfield(fourWins.getPlayfield().toString());
            }
            if (!fourWins.getPlayfield().CheckDraw()) {
                event.PrintEvent("\n" + fourWins.getCurrentPLayer().getName() + " won! GG!\n");
            } else {
                event.PrintEvent("Sadly this looks like a draw! GG!\n");
            }

            event.PrintEvent("Do you want to restart?\n" +
                             "If yes (R)\n" +
                             "If not (N)\n");
        }while(Objects.equals(input.nextLine(), "R"));
    }

    public static Game Initialize() {
        Playfield toInitialize = new Playfield();
        toInitialize.clear();
        String playerUno;
        String playerUnoChar;
        String playerDos;
        String playerDosChar;
        Scanner scanner = new Scanner(System.in);

        event.PrintEvent("Welcome to 4 Wins");

        event.PrintEvent("Player 1, please enter your name:");
        playerUno = scanner.nextLine();
        event.PrintEvent("Player 1, please choose your Char (press spacebar and enter you'll be 'x'):");
        playerUnoChar = scanner.nextLine();

        do {
            event.PrintEvent("Player 2, please enter a different name:");
            playerDos = scanner.nextLine();
            if (Objects.equals(playerUnoChar, "")) {
                playerUnoChar = "x";
            }

        } while (playerUno.equals(playerDos));

        do {
            event.PrintEvent("Player 2, please choose your Char (press spacebar and enter you'll be 'O'):");
            playerDosChar = scanner.nextLine();
            System.out.println(playerDosChar);
            if (Objects.equals(playerDosChar, "")) {
                playerDosChar = "O";
            }

        } while (Objects.equals(playerUnoChar, playerDosChar));

        return new Game(new Player(playerUno, playerUnoChar.charAt(0)), new Player(playerDos, playerDosChar.charAt(0)), toInitialize);

    }


}
