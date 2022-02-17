/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Elektronik und Technische Informatik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Jhuber,Ikovacev
 * @date    : 30.02.2022
 *
 * @details
 *   Ausgabe fuer Player
 */
package com.example.viergewinntv7.view;

import com.example.viergewinntv7.model.Player;

public class PlayerViewConsole implements PlayerView{

    @Override
    /**
     * Gibt mitgegeben Spielernamen aus
     */
    public void PrintPlay(Player player) {
        System.out.print(player.GetName());
    }
}
