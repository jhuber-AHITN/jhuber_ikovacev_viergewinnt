package com.example.viergewinntv7.model;

import com.example.viergewinntv7.controller.ControllerConsole;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    protected Player[] players = new Player[2];
    protected Player currentPLayer;
    protected Playfield playfield;
    protected int[] lastset = new int[2];

    public Game(Player playerOne, Player playerTwo, Playfield playfield) {
        players[0] = playerOne;
        players[1] = playerTwo;
        this.playfield = playfield;
    }

    public void set(int col) {
        lastset[1] = col;
        lastset[0] = playfield.checkcol(col);
        playfield.setcell(playfield.checkcol(col), col, currentPLayer.getSymbol());
    }

    public void undo() {
        playfield.unsetcell(lastset[0], lastset[1]);
    }

    public void reset() {
        playfield.clear();

    }


    public Playfield getPlayfield() {
        return playfield;
    }

    public void RandomPlayer() {
        currentPLayer = players[(int) Math.floor(Math.random() * (1 - 0 + 1) + 0)];
    }

    public void SwitchPlayer() {
        if (currentPLayer == players[0]) {
            currentPLayer = players[1];
        } else {
            currentPLayer = players[0];
        }
    }

    public Player getCurrentPLayer() {
        return currentPLayer;
    }
}