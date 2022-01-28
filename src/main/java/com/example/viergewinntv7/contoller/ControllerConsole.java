package com.example.viergewinntv7.contoller;

import com.example.viergewinntv7.model.Playfield;

public class ControllerConsole {
    public static void main(String[] args) {
        Playfield playfield = new Playfield();

        playfield.clear();
        System.out.println(playfield);
    }
}
