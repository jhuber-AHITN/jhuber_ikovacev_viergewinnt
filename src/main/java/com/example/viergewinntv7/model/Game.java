/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Elektronik und Technische Informatik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : jhuber, ikovacev
 * @date    : 03.02.2022
 *
 * @details
 *   Gameklasse mit Methoden um das Spiel zu steuern
 *
 */




package com.example.viergewinntv7.model;

import com.example.viergewinntv7.controller.ControllerConsole;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    protected Player[] players = new Player[2];
    protected Player currentPLayer;
    protected Playfield playfield;
    protected int[] lastset = new int[2];

    /**
     * Setzt die Spieler und das Spielfeld
     * @param playerOne erster Spieler
     * @param playerTwo zweiter Spieler
     * @param playfield Spielfeld
     */
    public Game(Player playerOne, Player playerTwo, Playfield playfield) {
        players[0] = playerOne;
        players[1] = playerTwo;
        this.playfield = playfield;
    }

    /**
     * Macht einen Spielzug in der mitgegebenen Spalte
     * @param col   Spalte
     */
    public void set(int col) {
        lastset[1] = col;
        lastset[0] = playfield.checkcol(col);
        playfield.setcell(playfield.checkcol(col), col, currentPLayer.getSymbol());
    }

    /**
     * Macht den letzten Spielzug rückgängig
     */
    public void undo() {
        playfield.unsetcell(lastset[0], lastset[1]);
    }

    /**
     * Gibt das Spielfeld zurück
     * @return Spielfeld
     */
    public Playfield getPlayfield() {
        return playfield;
    }

    /**
     * Setzt currentPlayer auf einen zufälligen Spieler aus players[]
     */
    public void RandomPlayer() {
        currentPLayer = players[(int) Math.floor(Math.random() * (1 - 0 + 1) + 0)];
    }

    /**
     * Wechselt den currentPlayer
     */
    public void SwitchPlayer() {
        if (currentPLayer == players[0]) {
            currentPLayer = players[1];
        } else {
            currentPLayer = players[0];
        }
    }

    /**
     * Gibt den currentPlayer zurück
     * @return  currentPlayer
     */
    public Player getCurrentPLayer() {
        return currentPLayer;
    }
}