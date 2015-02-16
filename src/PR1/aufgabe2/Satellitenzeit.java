package PR1.aufgabe2; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 1
 * Satellitenzeit.java
 * Version 1.0
 * Zweck: Sekundenbetrag einlesen und die Zeitspanne ausgeben
 */

import javax.swing.*;

class Satellitenzeit {
  /* Das Programm soll den Benutzer auffordern die Anzahl der Sekunden ein- und
  diese in einer bestimmten Form wieder auszugeben.
  */

    public static void main(final String[] args) {

        //  Deklaration und Initialisierung der Variablen
        int sekundeninput;
        int d = 86400;
        int h = 3600;
        int m = 60;

        int tage = 0;
        int stunden = 0;
        int minuten = 0;
        int rest;

        //Benutzereingabe
        sekundeninput = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte ganzzahligen Wert eingeben:"));

        //Anweisung zur Berechnung
        tage = sekundeninput / d;
        rest = sekundeninput % d;          //Divisionsrest mit modulo

        stunden = rest / h;
        rest = rest % h;

        minuten = rest / m;
        rest = rest % m;

        //Benutzerausgabe
        JOptionPane.showMessageDialog(null, tage + "Tage " + stunden + ":" + minuten + ":" + rest);
    }
}
