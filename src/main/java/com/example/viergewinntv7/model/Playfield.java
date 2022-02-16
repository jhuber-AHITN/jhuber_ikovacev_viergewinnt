/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Elektronik und Technische Informatik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : jhuber, ikovacev
 * @date : 03.02.2022
 * @details Playfield Klasse die das Spielfeld mithilfe eines Arrays darstellt und die Züge mit dem counter mitzählt
 */


package com.example.viergewinntv7.model;

/**
 * Playfield Klasse die das Spielfeld mithilfe eines Arrays darstellt und die Züge mit dem counter mitzählt
 */
public class Playfield {
    private static final int HÖHE = 6;
    private static final int BREITE = 7;
    private static final int UNENTSCHIEDEN = 42;

    protected char[][] fieldArray = new char[HÖHE][BREITE];
    protected static int counter = 0;

    /**
     * Leert das Spielfeld
     */
    public void Clear() {
        for (int i = 0; i < HÖHE; i++) {
            for (int j = 0; j < BREITE; j++) {
                fieldArray[i][j] = ' ';
            }
        }
    }

    /**
     * Gibt einen String zurück der das Spielfeld repräsentiert
     *
     * @return Spielfeldstring
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(" 0 1 2 3 4 5 6 \n|");

        for (int i = 0; i < 6; i++) {
            if (i > 0) {
                ret.append("\n|");
            }
            for (int j = 0; j < 7; j++) {
                ret.append(fieldArray[i][j]).append("|");
            }
        }

        return ret.toString();

    }

    /**
     * Sucht die erste freie Zeile in einer Spalte
     *
     * @param col die Spalte
     * @return die Zeile
     */
    public int Checkcol(int col) {
        int ret = 0;

        for (int i = 0; i < 6; ++i) {
            if (fieldArray[i][col] == ' ') {
                ret = i;
            }
        }

        return ret;
    }

    /**
     * Setzt eine bestimmte Zelle auf ein Symbol
     *
     * @param row    die Zeile in der sich die Zelle befindet
     * @param col    die Spalte in der sich die Zelle befindet
     * @param symbol das Symbol auf das gesetzt wird
     */
    public void SetCell(int row, int col, char symbol) {
        fieldArray[row][col] = symbol;
        counter++;
    }

    /**
     * Löscht den Inhalt einer bestimmten Zelle
     *
     * @param row die Zeile in der sich die Zelle befindet
     * @param col die Spalte in der sich die Zelle befindet
     */
    public void UnsetCell(int row, int col) {
        fieldArray[row][col] = ' ';
        counter--;
    }

    /**
     * Checkt ob ein Spieler gewonnen hat
     *
     * @param toCheckIfWon der Spieler der gewonnen haben könnte
     * @return true-wenn gewonnen / false-wenn nicht gewonnen
     */
    public boolean CheckWin(Player toCheckIfWon) {
        boolean ret = false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (fieldArray[i][j] == toCheckIfWon.GetSymbol() && fieldArray[i][j + 1] == toCheckIfWon.GetSymbol() && fieldArray[i][j + 2] == toCheckIfWon.GetSymbol() && fieldArray[i][j + 3] == toCheckIfWon.GetSymbol()) {
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (fieldArray[j][i] == toCheckIfWon.GetSymbol() && fieldArray[j + 1][i] == toCheckIfWon.GetSymbol() && fieldArray[j + 2][i] == toCheckIfWon.GetSymbol() && fieldArray[j + 3][i] == toCheckIfWon.GetSymbol()) {
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (fieldArray[i][j] == toCheckIfWon.GetSymbol() && fieldArray[i + 1][j + 1] == toCheckIfWon.GetSymbol() && fieldArray[i + 2][j + 2] == toCheckIfWon.GetSymbol() && fieldArray[i + 3][j + 3] == toCheckIfWon.GetSymbol()) {
                    ret = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j >= 3; j--) {
                if (fieldArray[i][j] == toCheckIfWon.GetSymbol() && fieldArray[i + 1][j - 1] == toCheckIfWon.GetSymbol() && fieldArray[i + 2][j - 2] == toCheckIfWon.GetSymbol() && fieldArray[i + 3][j - 3] == toCheckIfWon.GetSymbol()) {
                    ret = true;
                }
            }
        }

        return ret;


    }

    /**
     * Checkt ob ein Unentschieden entstanden ist
     *
     * @return true-wenn unentschieden / false-wenn nicht unentschieden
     */
    public boolean CheckDraw() {
        return counter == UNENTSCHIEDEN;
    }

}
