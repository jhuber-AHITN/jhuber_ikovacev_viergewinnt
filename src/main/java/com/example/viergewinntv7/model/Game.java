package com.example.viergewinntv7.model;

public class Game {
    protected Player playerUno;
    protected Player playerDos;
    protected Playfield playfield;

    public Game(Player playerUno, Player playerDos, Playfield playfield) {
        this.playerUno = playerUno;
        this.playerDos = playerDos;
        this.playfield = playfield;
    }

    public Game() {
    }

    public void setPlayerUno(Player playerUno) {
        this.playerUno = playerUno;
    }

    public void setPlayerDos(Player playerDos) {
        this.playerDos = playerDos;
    }

    public void setPlayfield(Playfield playfield) {
        this.playfield = playfield;
    }

    public Player getPlayerUno() {
        return playerUno;
    }

    public Player getPlayerDos() {
        return playerDos;
    }

    public Playfield getPlayfield() {
        return playfield;
    }
}