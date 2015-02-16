package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * ParallelesWiderstandsnetz.java
 * Version 1.0
 * Zweck: Abbild der Parallelschaltung,
 * erbt von ZusammengesetztesWiderstandsnetz
 */
public class ParallelesWiderstandsnetz extends ZusammengesetztesWiderstandsnetz {
  /* --- Konstruktor --- */

    /**
     * Erwartet zwei Widerstandsnetze als Argumente
     */
    protected ParallelesWiderstandsnetz(Widerstandsnetz r1, Widerstandsnetz r2) {
        this.r1 = r1;
        this.r2 = r2;
        objektZaehler++; //Da statisch, unabh�niger Z�hler der Objekte f�r Anzahl dieser
        objektZaehler++;
    }

  /* --- Redifinition der getBerechnung-Methode --- */

    /**
     * Berechnet den Gesamtwiderstandswert R = 1/(1/R1 + 1/R2)
     */
    protected double getBerechnung() {
        return gesamtOhm = 1 / ((1 / r1.getOhm()) + (1 / r2.getOhm()));
    }
}
