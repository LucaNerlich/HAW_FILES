package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * Getraenk.java Version 1.0 Zweck: Abbild eines Getraenks
 */
public class Getraenk implements Ware {
    /* -------- Objektvariablen -------- */
    String getraenketyp; // WASSER, LIMONADE, SAFT, BIER, WEIN, SCHNAPS
    String markenname;
    double preisProFlasche;
    int flaschengroesse;
    int vorhandeneStueckzahlFlaschen;

    /* -------- Konstruktoren -------- */
    Getraenk(String getraenketyp, String markenname, double preisProFlasche,
             int flaschengroesse, int vorhandeneStueckzahlFlaschen) {

        this.getraenketyp = getraenketyp;
        this.markenname = markenname;
        this.preisProFlasche = preisProFlasche;
        this.flaschengroesse = flaschengroesse;
        this.vorhandeneStueckzahlFlaschen = vorhandeneStueckzahlFlaschen;
    }

    /* -------- Setter und Getter-Methoden -------- */
    public String getBezeichnung() {
        return markenname + ": " + getraenketyp;
    }

    public double getPreis() {
        return preisProFlasche;
    }

    public int getVorhandeneStueckzahl() {
        return vorhandeneStueckzahlFlaschen;
    }

    public void setStueckzahl(int stueckzahl) {
        this.vorhandeneStueckzahlFlaschen = stueckzahl;

    }

    public int getGroesse() {
        return flaschengroesse;
    }

    /* -------- Hauptmethoden -------- */
    public boolean istGesundheitsgefaehrdend() {
        if (getraenketyp.equals("WEIN") || getraenketyp.equals("SCHNAPS")
                || getraenketyp.equals("BIER")) {
            return true;
        } else {
            return false;
        }
    }

    private String gefaehrend() {
        if (istGesundheitsgefaehrdend() == true) {
            return " -- Gef�hrdet die Gesundheit!";
        } else {
            return "";
        }
    }

    public void ausgeben() {

        System.out.format("%10s%20f%14d%2s", markenname, preisProFlasche,
                vorhandeneStueckzahlFlaschen, gefaehrend());
        System.out.println();

    }

}
