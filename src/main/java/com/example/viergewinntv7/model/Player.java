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
 *   Player Klasse mit notwendigen Eigenschaften name und symbol
 *
 */





package com.example.viergewinntv7.model;

public class Player {
    String name;
    Character symbol;

    /**
     * Setzt name und symbol
     * @param name Name
     * @param symbol Symbol
     */
    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Gibt name zurück
     * @return name
     */
    public String GetName() {
        return name;
    }

    /**
     * Gibt symbol zurück
     * @return symbol
     */
    public Character GetSymbol() {
        return symbol;
    }
}
