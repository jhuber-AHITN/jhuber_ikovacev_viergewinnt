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
 *   Ausgabe fuer Spielfeld....
 */
package com.example.viergewinntv7.view;

public class FieldViewConsole implements FieldView {

    @Override
    public void Prientfield(String field) {
        System.out.print(field);
    }
}
