package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * Widerstand.java
 * Version 1.0
 * Zweck: Abbild einfacher Widerst�nde,
 * erbt von Widerstandsnetz
 */
public class Widerstand extends Widerstandsnetz {
    /**
     * --- Konstante ---
     * Der Widerstandswert soll im Konstruktor �bergeben werden und unver�nderlich sein
     */
    protected int WIDERSTANDSWERT;

    /* --- Konstruktor --- */
    protected Widerstand(int Widerstandswert) {
        this.WIDERSTANDSWERT = Widerstandswert;
        objektZaehler++;
    }

  /* --- Getter und Setter --- */

    public int getWiederstandswert() {
        return WIDERSTANDSWERT;
    }

    /**
     * Liefert den Gesamtwiderstand des Netzes
     */
    public double getOhm() {
        return WIDERSTANDSWERT;
    }

    /**
     * Liefert die Anzahl an einfachen Widerst�nden im Netz
     */
    public int anzahlWiderstaende() {
        return objektZaehler;
    }

  /* --- Hauptmethoden --- */

    /**
     * Repr�sentiert das Objekt
     */
    public String toString() {
        return "Gesamtwiederstand: " + this.getOhm() + " mit " +
                this.anzahlWiderstaende() + " Widerst�nden";
    }

    /* --- Hilfsmethoden --- */
    private void test(Widerstand rx) {
        System.out.println("R" + objektZaehler + "+1" + ": " + rx.getOhm());
    }
}
