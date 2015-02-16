package PR1.aufgabe3;

import javax.swing.*;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 2
 * Primfaktorzerlegung.java
 * Version 1.0
 * Zweck: Darstellung von einer beliebigen Zahl als Produkt von Primzahlen!
 */


class Primfaktorzerlegung {
    /* Das Programm soll Primfaktoren berechnen und diese nach Eingabe vom Benutzer
    ausgeben.
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        int eingabe = 0;
        int ergebnis = 0;

        //Benutzereingabe
        eingabe = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte geben Sie Ihre gewuenschte Zahl ein die in Primfaktoren zerlegt werden soll: "));

        if (eingabe > 0) { //Abfangen von Zahlen die, die Ausgabe behindern

            if (eingabe == 1) {
                System.out.print("Primfaktor von: 1"); //Sondernfall 1 abfangen
            } else {
                //Benutzerausgabe
                System.out.print("Primfaktoren von " + eingabe + ": ");

                for (int zahl = 2; (eingabe % zahl) == 0; ) { //Solange durch zwei teilbar
                    ergebnis = eingabe / zahl;
                    eingabe = ergebnis;
                    System.out.print(zahl + " ");

                    for (; (eingabe % zahl) != 0; zahl++) {
                    } // end of for
                }

                System.out.print(eingabe); //Ansonsten Ergebnis ausgeben
            }
        } else { //Ausgabe falls eine negative oder die Zahl 0 eingegeben wird
            JOptionPane.showMessageDialog(null,
                    "Sie haben keine gueltige Zahl eingebeben bitte wiederholen Sie die Eingabe");
        } // end of if-else
    }
}
