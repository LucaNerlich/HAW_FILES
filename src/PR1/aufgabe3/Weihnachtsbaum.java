package PR1.aufgabe3; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 1
 * Weihnachtsbaum.java
 * Version 1.0
 * Zweck: Weihnachtsstimmung bereiten!
 */

import javax.swing.*;


class Weihnachtsbaum {
    /* Das Programm soll grafisch (auf der Console) einen Weihnachtsbaum ausgeben
    dabei soll der Anwender die H�he des Baumes angeben.
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        int zeile = 0;
        int spalte = 0;
        int eingabe = 0;

        //Benutzereingabe
        eingabe = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte geben Sie die gewuenschte Hoehe Ihres Baumes als eine ganze Zahl ein: "));

        if (eingabe > 0) { //Abfangen von Zahlen die, die Ausgabe behindern
            //Grafische Darstellung des Baumes

            for (zeile = 1; zeile <= eingabe; zeile++) {
                for (spalte = 1; spalte <= (eingabe - zeile); spalte++)
                    System.out.print("."); //Lueckenfueller innen

                for (spalte = 1; spalte <= ((2 * zeile) - 1); spalte++)
                    System.out.print("*"); //Ausgabe vom Baum

                for (spalte = 1; spalte <= (eingabe - zeile); spalte++)
                    System.out.print("."); //Lueckenfueller außen

                System.out.println(); //Zeilenumbruch erzeugen sonst wird alles in einer Zeile ausgegeben
            }
        } else {
            System.out.print("Dein Baum kann ohne Aeste nicht entstehen...");
        } // end of if-else
    }
}
