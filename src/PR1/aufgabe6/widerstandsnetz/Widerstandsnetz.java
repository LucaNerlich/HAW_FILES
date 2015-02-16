package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * Widerstandsnetz.java
 * Version 1.0
 * Zweck: Basisklasse f�r die Widerstandsnetze
 */
public abstract class Widerstandsnetz {
    /* -------- Objektvariablen -------- */
    protected int anzahlWiderstaende;
    protected double gesamtOhm;

    /* -------- Statische Variablen -------- */
    public static int objektZaehler = 0;

  /* -------- Abstrakte Methoden -------- */

    /**
     * Liefert den Gesamtwiderstand des Netzes
     */
    abstract double getOhm();

    /**
     * Liefert die Anzahl an einfachen Widerst�nden im Netz
     */
    abstract int anzahlWiderstaende();
}
