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

import java.util.Objects;

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
    public String getName() {
        return name;
    }

    /**
     * Setzt name auf den mitgegebenen Namen
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt symbol zurück
     * @return symbol
     */
    public Character getSymbol() {
        return symbol;
    }

    /**
     * Setzt symbol auf den mitgebenen character
     * @param symbol Symbol
     */
    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
