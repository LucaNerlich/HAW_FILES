package PR1.aufgabe4.eisenbahn;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4 - OOP Einleitung - Aufgabe 2
 * Zug.java
 * Version 3.0 - final
 * Zweck: Test der Aufgabe: Eisenbahn
 */

public class Zug {
    private Lokomotive lok;

    /**
     * Konstruktor
     *
     * @param lok
     */
    public Zug(Lokomotive lok) {
        this.lok = lok;
    }

    /**
     * Gibt das object der lok zurueck.
     *
     * @return lok
     */
    public Lokomotive getLok() {
        return lok;
    }

    /**
     * Startmethode um einen Wagen hinzuzufuegen.
     *
     * @param neuerWagen
     */
    public void addWagen(Wagen neuerWagen) {
        lok.addWagen(neuerWagen);
    }

    /**
     * Gibt den ersten Wagen zurueck, der entfernt werden soll.
     *
     * @return
     */
    public Wagen removeErstenWagen() {
        return lok.removeErstenWagen();
    }

    /**
     * Gibt den letzten Wagen zurueck. Hilfsmethode.
     *
     * @return
     */
    private Wagen getLetztenWagen() {
        return lok.getLetztenWagen();
    }

    /**
     * Haengt die Wagen des zweiten Zugs ab
     * und haengt sie an den ersten Zug hinten an.
     *
     * @param andererZug
     */
    public void appendZug(Zug andererZug) {
        if (lok.getErsterWagen() == null) {
            lok.setErsterWagen(andererZug.getLok().getErsterWagen());
        } // end of if
        else {
            getLetztenWagen().setNaechsterWagen(andererZug.getLok().getErsterWagen());
        } // end of if-else
    }

    /**
     * Ausgabe / Teste Klasse. Gibt alle Zuege und Wagen mit Parametern aus.
     */
    public void info() {
        System.out.println("Zug Name: " + lok.getName());
        System.out.println(lok.parameterPrint());
        System.out.println("Anzahl der Wagen im Zug: " + getWagenAnzahl());
        System.out.println("Der Zug ist " + getZugLaenge() + " Einheiten lang.");
        System.out.println("Der Zug kann " + getKapazitaet() +
                " Passagiere transportieren.");
        System.out.println("Der Zug besteht aus folgenden Wagen:");
        System.out.println(gibWagenParameter());
    }

    /**
     * Gibt die Parameter des Wagens zurueck.
     *
     * @return parameterWagen
     */
    public String gibWagenParameter() {
        String parameterWagen = "";

        for (Wagen x = lok.getErsterWagen(); x != null;
             x = x.getNaechsterWagen()) {
            parameterWagen += x.parameterPrint();
        } // end of for

        return parameterWagen;
    }

    /**
     * Gibt die Anzahl der Wagen am Zug zurueck.
     *
     * @return anzahlDerWagen
     */
    public int getWagenAnzahl() {
        int anzahlDerWagen = 0;

        for (Wagen x = lok.getErsterWagen(); x != null;
             x = x.getNaechsterWagen()) {
            anzahlDerWagen++;
        } // end of for

        return anzahlDerWagen;
    }

    /**
     * Gibt die Laenge des Zuges zurueck.
     *
     * @return laengeDesZuges
     */
    public int getZugLaenge() {
        int laengeDesZuges = lok.getLaenge();

        for (Wagen x = lok.getErsterWagen(); x != null;
             x = x.getNaechsterWagen()) {
            laengeDesZuges += x.getLaenge();
        } // end of for

        return laengeDesZuges;
    }

    /**
     * Gibt die Passagierkapazitaet zurueck.
     *
     * @return kapazitaetDesZuges
     */
    public int getKapazitaet() {
        int kapazitaetDesZuges = 0;

        for (Wagen x = lok.getErsterWagen(); x != null;
             x = x.getNaechsterWagen()) {
            kapazitaetDesZuges += x.getPassagierkapazitaet();
        } // end of for
        return kapazitaetDesZuges;
    }
}
