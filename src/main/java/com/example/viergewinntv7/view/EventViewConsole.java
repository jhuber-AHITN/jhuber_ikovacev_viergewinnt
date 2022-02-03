

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
 *   Ausgabe fuer Aufforderungen, Erinerrungen....
 */
package com.example.viergewinntv7.view;

public class EventViewConsole implements EventView{
    @Override
    public void PrintEvent(String event) {
        System.out.println(event);
    }
}
