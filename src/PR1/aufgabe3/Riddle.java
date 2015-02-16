package PR1.aufgabe3; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3
 * Riddle.java
 * Version 1.2
 * Zweck: Zahlenraten mit dem Benutzer
 */

import javax.swing.*;


class Riddle {
    public static void main(String[] args) {
        int solution = (int) (Math.random() * 100) + 1; // Loesung wird zufaellig zwischen 1 und 100 generiert.
        int counter = 1; // Counter der Versuche wird initialisiert.
        System.out.println("Geben Sie jetzt ihren Tipp ein!");

        int guess = Integer.parseInt(JOptionPane.showInputDialog(null, // Der Tipp des Benutzers wird abgefragt.
                "Bitte ganzzahligen Wert x eingeben:"));

        if (guess >= 1) { //Programm laeuft nur, wenn der Tipp >= 1 ist.

            while (guess != solution) { // While laeuft solange wie der Tipp ungleich der Loesung ist.

                if (guess > solution) {
                    counter++;
                    System.out.println("Die Loesung ist kleiner als Ihr Tipp!");
                    guess = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Bitte ganzzahligen Wert x eingeben:"));
                } // end of if-else
                else if (guess < solution) {
                    counter++;
                    System.out.println("Die Loesung ist groeßer als Ihr Tipp!");
                    guess = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Bitte ganzzahligen Wert x eingeben:"));
                }

                System.out.println();
            }

            if (guess == solution) {
                System.out.println("Sie haben die korrekte Loesung erraten!");
                System.out.println("Die Loesung war: " + solution);
                System.out.println("Sie haben " + counter + " Versuche gebraucht!");
            }
        } // end of if
        else {
            System.err.println("Bitte Versuchen Sie es mit einem Wert >= 1 erneut!");
        }
    }
}
