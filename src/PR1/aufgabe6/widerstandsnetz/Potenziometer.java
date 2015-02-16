package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * Potenziometer.java
 * Version 1.0
 * Zweck: Abbild von Widerst�nde mit einem regelbaren Widerstandswert,
 * erbt von Widerstand
 */
public class Potenziometer extends Widerstand {
    /* -------- Objektvariablen -------- */
    public static final int Widerstandswert = 0;

    /* --- Konstruktor --- */
    Potenziometer() {
        super(Widerstandswert);      //Konstruktor der Basisklasse wird aufgerufen
    }

    Potenziometer(int Widerstandswert) {
        super(Widerstandswert);
    }

    public void setOhm(int ohm) {
        this.WIDERSTANDSWERT = ohm;
    }
}
