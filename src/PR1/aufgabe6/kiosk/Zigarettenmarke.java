package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * Zigarettenmarke.java Version 1.0 Zweck: Abbild einer Zigarettenschachtel
 */
public class Zigarettenmarke implements Ware {
    /* -------- Objektvariablen -------- */
    String markenname;
    double preisProSchachtel;
    int vorhandeneStueckzahlSchachteln;

    /* -------- Konstruktoren -------- */
    Zigarettenmarke(String markenname, double preisProSchachtel,
                    int vorhandeneStueckzahlSchachteln) {
        this.markenname = markenname;
        this.preisProSchachtel = preisProSchachtel;
        this.vorhandeneStueckzahlSchachteln = vorhandeneStueckzahlSchachteln;

    }

    /* -------- Setter und Getter-Methoden -------- */
    public String getBezeichnung() {
        return markenname;
    }

    public double getPreis() {
        return preisProSchachtel;
    }

    public int getVorhandeneStueckzahl() {
        return vorhandeneStueckzahlSchachteln;
    }

    public void setStueckzahl(int stueckzahl) {
        this.vorhandeneStueckzahlSchachteln = stueckzahl;

    }

    public int getGroesse() {
        return 0;
    }

    /* -------- Hauptmethoden -------- */
    public boolean istGesundheitsgefaehrdend() {
        return true;
    }

    public String gefaehrend() {
        if (istGesundheitsgefaehrdend() == true) {
            return " -- Gef�hrdet die Gesundheit!";
        } else {
            return "";
        }
    }

    public void ausgeben() {


        System.out.format("%10s%20f%14d%2s", markenname, preisProSchachtel,
                vorhandeneStueckzahlSchachteln, gefaehrend());
        System.out.println();
    }

}
