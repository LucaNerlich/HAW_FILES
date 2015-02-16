package PR1.aufgabe7;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Aufgabe: Aufgabenblatt 4 - OOP Einleitung -
 * Aufgabe 7 ZugException.java Version 3.0 - final Zweck: Eigene Exception
 * erstellen
 */

public class ZugException extends Exception {

    ZugException() {
        super();
    }

    ZugException(String message) {
        super(message);
    }
}
