package PR1.aufgabe2; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2
 * bmi.java
 * Version 1.0
 * Zweck: Die Berechnung vom BMI-Wert
 */

import javax.swing.*;


class bmi {
    /* Das Programm soll nach der Benutzereingabe von Koerpergroeße und Gewicht den
    BMI-Wert berechnen und ausgeben.
    */
    public static void main(String[] args) {
        //  Deklaration der Variablen
        double groesse = 0;
        double gewicht = 0;
        double bmi = 0;

        gewicht = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Bitte geben Sie Ihr Gewicht ein: "));

        groesse = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Bitte geben Sie Ihre Groeße ein: "));

        bmi = gewicht / (groesse * groesse);

        JOptionPane.showMessageDialog(null, "Der BMI-Wert betraegt: " + (int) bmi);

    /* die Explizite Tpykonversion erfolgt mit integer, mit diesem Datentyp
    k�nnen die Kommastellen nicht angezeigt werden.*/
    }
}
