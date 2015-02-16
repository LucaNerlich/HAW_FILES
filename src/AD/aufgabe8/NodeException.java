package AD.aufgabe8;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 8
 * NodeException.java
 *
 * Exceptionsklasse fuer Fehler innerhalb des Binaerbaums
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class NodeException extends Exception {

    NodeException() {
        super();
    }

    NodeException(String message) {
        super(message);
    }

}
