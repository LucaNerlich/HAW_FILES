package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * Zeitschrift.java Version 1.0 Zweck: Abbild einer Zeitschrift
 */
public class Zeitschrift implements Ware {
    /* -------- Objektvariablen -------- */
    String titel;
    int erscheinungsdatum;
    double preisProStueck;
    int vorhandeneStueckzahl;

    /* -------- Konstruktoren -------- */
    Zeitschrift(String titel, int erscheinungsdatum, double preisProStueck,
                int vorhandeneStueckzahl) {

        this.titel = titel;
        this.erscheinungsdatum = erscheinungsdatum;
        this.preisProStueck = preisProStueck;
        this.vorhandeneStueckzahl = vorhandeneStueckzahl;

    }

    /* -------- Setter und Getter-Methoden -------- */
    public String getBezeichnung() {
        return titel;
    }

    public double getPreis() {
        return preisProStueck;
    }

    public int getVorhandeneStueckzahl() {
        return vorhandeneStueckzahl;
    }

    public void setStueckzahl(int stueckzahl) {
        this.vorhandeneStueckzahl = stueckzahl;

    }

    public int getGroesse() {
        return 0;
    }

    /* -------- Hauptmethoden -------- */
    public boolean istGesundheitsgefaehrdend() {
        return false;
    }

    public void ausgeben() {

        System.out.format("%10s%10d%10f%14d", titel, erscheinungsdatum, preisProStueck,
                vorhandeneStueckzahl);

        System.out.println();

    }
}
