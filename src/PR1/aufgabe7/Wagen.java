package PR1.aufgabe7;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Aufgabe: Aufgabenblatt 4 - OOP Einleitung -
 * Aufgabe 7 Wagen.java Version 3.0 - final Zweck: Die Klasse Wagen mit Hilfe
 * von Exceptions weiter absichern
 */
public class Wagen {
    private int laenge;
    private int passagierkapazitaet;
    private static int anzahlWagenGesammt;
    private int SERIENNUMMER;
    private Wagen naechsterWagen;

    /**
     * Konstruktor f�r Wagen
     *
     * @param laenge
     * @param passagierkapazitaet
     */
    public Wagen(int laenge, int passagierkapazitaet)
            throws IllegalArgumentException {
        if ((laenge < 1) || (laenge > 100)) {
            throw new IllegalArgumentException("Der Wagen entspricht nicht der richtigen Laenge!");
        }

        if ((passagierkapazitaet < 0) || (passagierkapazitaet > 500)) {
            throw new IllegalArgumentException("Der Wagen entspricht nicht der richtigen Kapazitaet!");
        }

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

    public int getSeriennummer() {
        return SERIENNUMMER;
    }

    /**
     * F�gt einen neuen Wagen an das Ende an. Ruft sich rekursiv auf, wenn der
     * Wagen noch einen Nachfolger hat so lange bis der naechste "frei" ist.
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
     * Gibt die Seriennummer, Passagierkapazitaet und Laenge zur�ck.
     *
     * @return String
     */
    public String parameterPrint() throws IllegalArgumentException {
        if (SERIENNUMMER == 0) {
            throw new IllegalArgumentException("Etwas ist in der Ausgabe schiefgegangen!");
        }

        return "Wagen Nummer: " + SERIENNUMMER + " L�nge = " + laenge +
                ",\t Passagiere = " + passagierkapazitaet + "\n";
    }

    /**
     * Gibt den letzten Wagen zur�ck.
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
