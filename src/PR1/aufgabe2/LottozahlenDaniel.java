package PR1.aufgabe2; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 3
 * lottozahlen_d.java
 * Version 1.0
 * Zweck: Ziehung der Lottozahlen digitalisieren
 */

import javax.swing.*;


class LottozahlenDaniel {
    /* Das Programm soll ohne eine Benutzereingabe zufaellig sechs Lottozahlen ziehen
    und diese dann ausgeben.
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        int zufallszahl1 = 0;
        int zufallszahl2 = 0;
        int zufallszahl3 = 0;
        int zufallszahl4 = 0;
        int zufallszahl5 = 0;
        int zufallszahl6 = 0;

        //  Generierung der Zufallszahlen die als int gespeichert werden
        zufallszahl1 = (int) (Math.random() * 49) + 1;
        zufallszahl2 = (int) (Math.random() * 49) + 1;
        zufallszahl3 = (int) (Math.random() * 49) + 1;
        zufallszahl4 = (int) (Math.random() * 49) + 1;
        zufallszahl5 = (int) (Math.random() * 49) + 1;
        zufallszahl6 = (int) (Math.random() * 49) + 1;

        //  Ausgabe der Zufallszahlen
        JOptionPane.showMessageDialog(null,
                "Die Lottozahlen lauten: " + zufallszahl1 +
                        ", " + zufallszahl2 + ", " + zufallszahl3 +
                        ", " + zufallszahl4 + ", " + zufallszahl5 +
                        ", " + zufallszahl6);
    }
}