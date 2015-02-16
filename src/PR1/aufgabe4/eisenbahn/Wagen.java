package PR1.aufgabe4.eisenbahn;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4 - OOP Einleitung - Aufgabe 2
 * Wagen.java
 * Version 3.0 - final
 * Zweck: Test der Aufgabe: Eisenbahn
 */
public class Wagen {
    private final int laenge;
    private final int passagierkapazitaet;
    private static int anzahlWagenGesammt;
    private final int SERIENNUMMER;
    private Wagen naechsterWagen;

    /**
     * Konstruktor f�r Wagen
     *
     * @param laenge
     * @param passagierkapazitaet
     */
    public Wagen(int laenge, int passagierkapazitaet) {
        this.laenge = laenge;
        this.passagierkapazitaet = passagierkapazitaet;
        naechsterWagen = null;
        anzahlWagenGesammt++;
        this.SERIENNUMMER = anzahlWagenGesammt;
    }

    /**
     * Getter & Setter
     */
    public Wagen getNaechsterWagen() {
        if (naechsterWagen != null) {
            return naechsterWagen;
        } // end of if
        else {
            return null;
        } // end of if-else
    }

    public int getPassagierkapazitaet() {
        return passagierkapazitaet;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setNaechsterWagen(Wagen naechsterWagen) {
        this.naechsterWagen = naechsterWagen;
    }

    /**
     * Fuegt einen neuen Wagen an das Ende an. Ruft sich rekursiv auf, wenn der Wagen noch einen Nachfolger hat
     * so lange bis der naechste "frei" ist.
     *
     * @param neuerWagen
     */
    public void addWagen(Wagen neuerWagen) {
        if (naechsterWagen == null) {
            setNaechsterWagen(neuerWagen);
        } // end of if
        else {
            naechsterWagen.addWagen(neuerWagen);
        }
    }

    /**
     * Gibt die Seriennummer, Passagierkapazitaet und Laenge zurueck.
     *
     * @return String
     */
    public String parameterPrint() {
        return "Wagen Nummer: " + SERIENNUMMER + ", Passagiere = " +
                passagierkapazitaet + "\t Laenge = " + laenge + "\n";
    }

    /**
     * Gibt den letzten Wagen zurueck.
     *
     * @return
     */
    public Wagen getLetztenWagen() {
        if (naechsterWagen == null) {
            return this;
        } // end of if
        else {
            return naechsterWagen.getLetztenWagen();
        } // end of if-else
    }
}
