package com.example.viergewinntv7.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Playfield {
    protected char[][] fieldArray = new char[6][7];

    /**
     * Clears the Playfield
     */
    public void clear() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
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
        StringBuilder ret = new StringBuilder(" 0 1 2 3 4 5 6 \n|");

        for (int i = 0; i < 6; i++) {
            if (i > 0){
                ret.append("\n|");
            }
            for (int j = 0; j < 7; j++) {
                ret.append(fieldArray[i][j]).append("|");
            }
        }

        return ret.toString();

    }

    public int checkcol(int col){
        int ret = 0;

        for (int i = 0; i < 6; ++i){
            if (fieldArray[i][col] == ' '){
                ret = i;
            }
        }

        return ret;
    }

    public void setcell(int row, int col, char symbol){
        fieldArray[row][col] = symbol;
    }

    public void unsetcell(int row, int col){
        fieldArray[row][col] = ' ';
    }
    public boolean CheckWin(Player toCheckIfWon){
        boolean ret = false;

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 4; j++){
                if (fieldArray[i][j] == toCheckIfWon.getSymbol() && fieldArray[i][j+1] == toCheckIfWon.getSymbol() && fieldArray[i][j+2] == toCheckIfWon.getSymbol() && fieldArray[i][j+3] == toCheckIfWon.getSymbol()){
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 3; j++){
                if (fieldArray[j][i] == toCheckIfWon.getSymbol() && fieldArray[j+1][i] == toCheckIfWon.getSymbol() && fieldArray[j+2][i] == toCheckIfWon.getSymbol() && fieldArray[j+3][i] == toCheckIfWon.getSymbol()){
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                if (fieldArray[i][j] == toCheckIfWon.getSymbol() && fieldArray[i + 1][j + 1] == toCheckIfWon.getSymbol() && fieldArray[i + 2][j + 2] == toCheckIfWon.getSymbol() && fieldArray[i + 3][j + 3] == toCheckIfWon.getSymbol()) {
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 6; j >= 3; j--){
                if (fieldArray[i][j] == toCheckIfWon.getSymbol() && fieldArray[i + 1][j - 1] == toCheckIfWon.getSymbol() && fieldArray[i + 2][j - 2] == toCheckIfWon.getSymbol() && fieldArray[i + 3][j - 3] == toCheckIfWon.getSymbol()) {
                    ret = true;
                }
            }
        }

        return ret;


    }
}
