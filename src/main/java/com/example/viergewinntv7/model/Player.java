package com.example.viergewinntv7.model;

import java.util.Objects;

public class Player {
    String name;
    Character symbol;

    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
