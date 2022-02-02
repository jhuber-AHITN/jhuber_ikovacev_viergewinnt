package com.example.viergewinntv7.controller;

import com.example.viergewinntv7.model.Game;
import com.example.viergewinntv7.model.Player;
import com.example.viergewinntv7.model.Playfield;

import java.util.Scanner;

public class ControllerConsole {
    public static void main(String[] args) {

        Playfield playfield=new Playfield();
        playfield.clear();
        System.out.println(playfield);
    }

    public static Game Initialize(){
        String playerUno;
        char playerUnoChar;
        String playerDos;
        char playerDosChar;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to 4 Wins");

        System.out.print("Player 1, please enter your name:");
        playerUno=scanner.next();
        System.out.print("Player 1, please choose your Char (if left empty you'll be 'x'):");
        playerUnoChar=scanner.next().charAt(0);

        do {
            System.out.print("Player 2, please enter a different name:");
            playerDos=scanner.next();

        }while (playerUno.equals(playerDos));

        do {
            System.out.print("Player 1, please choose your Char (if left empty you'll be 'O'):");
            playerDosChar=scanner.next().charAt(0);

        }while (playerUnoChar == playerDosChar);

        return new Game(new Player(playerUno,playerUnoChar),new Player(playerDos,playerDosChar),new Playfield());
    }
}
