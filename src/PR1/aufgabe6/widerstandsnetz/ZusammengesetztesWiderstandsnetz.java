package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * ZusammengesetztesWiderstandsnetz.java
 * Version 1.0
 * Zweck: Basisklasse der Parallelschaltung und Reihenschaltung
 * erbt von Widerstandsnetz
 */
public abstract class ZusammengesetztesWiderstandsnetz extends Widerstandsnetz {
    /* --- Statische Variablen --- */
    public static int objektZaehler = 0; //F�r die Anzhal der zusammengesetzen Widerst�nde

    /* --- Referenzvariablen --- */
    protected Widerstandsnetz r1;
    protected Widerstandsnetz r2;
  
  /* --- Getter und Setter --- */

    /**
     * Liefert den Ohm-Wert zur�ck
     */
    protected double getOhm() {
        return getBerechnung();
    }

    /**
     * Liefert die Anzahl der Zusammengesetzten Widerst�nde zur�ck
     */
    protected int anzahlWiderstaende() {
        return objektZaehler;
    }

    protected double getBerechnung() {
        return 0.0;
    }
  /* --- Hauptmethoden --- */

    public String toString() {
        return "Anzahl Ohm" + getOhm();
    }

}
