package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * interface.java Version 1.0 Zweck: Interface
 */
public interface Ware {

    public String getBezeichnung();

    public double getPreis();

    public boolean istGesundheitsgefaehrdend();

    public int getVorhandeneStueckzahl();

    public void setStueckzahl(int stueckzahl);

    public void ausgeben();

    public int getGroesse();
}
