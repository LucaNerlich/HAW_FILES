package PR1.aufgabe3;

import javax.swing.*;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3
 * Zahlenraten.java
 * Version 1.0
 * Zweck: Zahlenraten mit dem Benutzer
 */


class Zahlenraten {
    /* Das Programm soll eine geheime Zufallszahl zwischen 1 und 100 erzeugen, die
    der Benutzer anschließend raten soll.
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        int eingabe = 0;
        int zufallszahl = 0;

        zufallszahl = (int) (Math.random() * 100) + 1; // Zufallszahl zwischen 1 und 100 erzeugen
        JOptionPane.showMessageDialog(null,
                "Willkommen! Bitte rate eine Zahl zwischen 1 und 100.");

        for (int counter = 1; zufallszahl != eingabe; counter++) { //Zaehlschleife fuer die Versuche
            //Benutzereingabe
            eingabe = Integer.parseInt(JOptionPane.showInputDialog(null,
                    counter +
                            ".Versuch: "));

            if ((eingabe > 100) || (eingabe <= 0)) { //Meldung an Benutzer wenn Eingabezahl ueber 100 oder kleiner gleich 0
                JOptionPane.showMessageDialog(null,
                        "Zahl kann nicht <= 0 und hoeher als 100 sein");
            } // end of if

            //Vergleich der Eingabe mit entsprechender Ausgabe
            if (eingabe < zufallszahl) {
                JOptionPane.showMessageDialog(null,
                        "Meine Zahl ist groeßer als " + eingabe);
            } // end of if
            else {
                if (eingabe > zufallszahl) {
                    JOptionPane.showMessageDialog(null,
                            "Meine Zahl ist kleiner als " +
                                    eingabe);
                } // end of if
                else {
                    if (zufallszahl == eingabe) {
                        JOptionPane.showMessageDialog(null,
                                "Glueckwunsch! Du hast meine Zahl beim " +
                                        counter + ". Versuch erraten!");
                    } // end of if
                } // end of if-else
            } // end of if-else
        } // end of for

        JOptionPane.showMessageDialog(null,
                "Die Zufallszahl war die: " + zufallszahl);
    }
}
