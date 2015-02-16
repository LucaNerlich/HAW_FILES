package PR1.aufgabe2; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 5
 * ausdruecke.java
 * Version 1.0
 * Zweck: Auswertung logischer Ausdr�cke
 */

import javax.swing.*;


class ausdruecke {
    /* Das Programm soll nach der Benutzereingabe pruefen welche Bedingungen erfuellt
    sind und welche nicht. Der Benutzer erhaelt eine Rueckmeldung in Form von true
    oder false
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        int i = 0;
        int j = 0;
        int k = 0;

        boolean b; //bolean fuer Wahrheitswerte true or false
        boolean c;
        boolean d;

        //Benutzereingabe
        i = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte geben Sie einen Wert fuer i ein: "));

        j = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte geben Sie einen Wert j ein: "));

        k = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Bitte geben Sie einen Wert k ein: "));

        b = Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                "Bitte geben Sie ein ob der Wert b true oder false ist: "));

        c = Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                "Bitte geben Sie ein ob der Wert c true oder false ist: "));

        d = Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                "Bitte geben Sie ein ob der Wert d true oder false ist: "));

        //Bedingung a = i,j und k sind ungleich 0
        if ((i != 0) && (j != 0) && (k != 0)) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung a = i, j und k sind ungleich 0: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung a = i,j und k sind ungleich 0: false");
        }

        //Bedingung b = i ist durch 17 teilbar und echt positiv  (ohne null)
        if (((i % 17) == 0) && (i > 0)) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung b = i ist durch 17 teilbar und echt positiv: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung b = i ist durch 17 teilbar und echt positiv: false");
        }

        //Bedingung c = j ist ungerade und liegt zwischen 20 und 40
        if (((j % 2) != 0) && (j >= 20) && (j <= 40)) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung c = j ist ungerade und ziwschen 20 und 40: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung c = j ist ungerade und ziwschen 20 und 40: false");
        }

        //Bedingung d = k ist Vielfaches von 3 und 5 oder Vielfaches von 5 und 7 oder von 5 und 11
        if ((((k % 3) == 0) && ((k % 5) == 0)) ||
                (((k % 5) == 0) && ((k % 7) == 0)) ||
                (((k % 5) == 0) && ((k % 11) == 0))) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung d = k ist Vielfaches von 3 und 5 oder 5 und 7 oder 5 und 11: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung d = k ist Vielfaches von 3 und 5 oder 5 und 7 oder 5 und 11: false");
        }

        //Bedingung e = b,c und d Variablen sind entweder alle drei true oder false
        if (((b == true) && (c == true) && (d == true)) ||
                ((b == false) && (c == false) && (d == false))) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung e = b, c und d sind alle drei true oder alle drei false: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung e = b, c und d sind alle drei true oder alle drei false: false");
        }
        b = true;
        d = true;
        c = true;
        //Bedingung f = eine Variable b,c und d ist true oder alle drei
        if (((b == true) && (c == true) && (d == true)) || ((b == true) ^
                (c == true) ^ (d == true))) {
            JOptionPane.showMessageDialog(null,
                    "Bedingung f = Eine Variable b, c oder d oder alle drei sind true: true");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bedingung f = Eine Variable b, c oder d oder alle drei sind true: false");
        }
    }
}
