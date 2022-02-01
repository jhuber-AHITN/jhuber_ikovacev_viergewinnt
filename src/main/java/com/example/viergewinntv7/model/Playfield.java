package com.example.viergewinntv7.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Playfield {
    protected char[][] fieldArray = new char[7][6];

    /**
     * Clears the Playfield
     */
    public void clear() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                fieldArray[i][j] = ' ';
            }
        }
    }

    /**
     * Returns a String that represents the Playfield
     * @return ret - The String
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("|");

        for (int i = 0; i < 6; i++) {
            if (i > 0){
                ret.append("\n|");
            }
            for (int j = 0; j < 7; j++) {
                ret.append(fieldArray[j][i]).append("|");
            }
        }

        return ret.toString();

    }
}
