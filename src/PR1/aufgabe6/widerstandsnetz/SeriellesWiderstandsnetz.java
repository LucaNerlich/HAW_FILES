package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * SeriellesWiderstandsnetz.java
 * Version 1.0
 * Zweck: Abbild der Reihenschaltung,
 * erbt von ZusammengesetztesWiderstandsnetz
 */
public class SeriellesWiderstandsnetz extends ZusammengesetztesWiderstandsnetz {
  /* --- Konstruktor --- */

    /**
     * Erwartet zwei Widerstandsnetze als Argumente
     */
    SeriellesWiderstandsnetz(Widerstandsnetz r1, Widerstandsnetz r2) {
        this.r1 = r1;
        this.r2 = r2;
        objektZaehler++;
        objektZaehler++;
    }

  /* --- Redifinition der getBerechnung-Methode --- */

    /**
     * Berechnet den Gesamtwiderstandswert R = R1 + R2
     */
    protected double getBerechnung() {
        return gesamtOhm = r1.getOhm() + r2.getOhm();
    }
}
