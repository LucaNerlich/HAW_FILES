package PR1.aufgabe7;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Aufgabe: Aufgabenblatt 4 - OOP Einleitung -
 * Aufgabe 7 Lokomotive.java Version 3.0 - final Zweck: Die Klasse Lokomotive mit
 * Hilfe von Exceptions weiter absichern
 */

public class Lokomotive {
    private int laenge;
    private int typ;
    private String name;
    private Wagen ersterWagen;

    /**
     * Konstruktor
     *
     * @param name
     * @param laenge
     * @param typ
     */
    public Lokomotive(String name, int laenge, int typ)
            throws IllegalArgumentException {
        if ((laenge < 1) || (laenge > 100)) {
            throw new IllegalArgumentException("Der Wagen hat die falsche Laenge!");
        } else if (typ < 0) {
            throw new IllegalArgumentException("Der Typ darf nicht negativ sein!");
        }

        this.name = name;
        this.laenge = laenge;
        this.typ = typ;
        this.ersterWagen = null;
    }

    /**
     * Getter und Setter
     */
    public Wagen getErsterWagen() {
        return ersterWagen;
    }

    public void setErsterWagen(Wagen ersterWagen) {
        this.ersterWagen = ersterWagen;
    }

    public int getLaenge() {
        return laenge;
    }

    public int getTyp() {
        return typ;
    }

    public String getName() {
        return name;
    }

    /**
     * Checkt ob es einen ersten Wagen gibt, dann f�gt einen neuen Wagen an ->
     * Wagen.addWagen
     *
     * @param neuerWagen
     */
    public void addWagen(Wagen neuerWagen) throws ZugException {
        if (neuerWagen.getNaechsterWagen() != null) {
            throw new ZugException("Der Wagen hat bereits einen Nachfolger!");
        }

        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } // end of if
        else {
            ersterWagen.addWagen(neuerWagen);
        }
    }

    /**
     * Entfernt immer den ersten Wagen hinter der Lok. Checkt ob der erste Wagen
     * einen nachfolger hat und wei�t diesen dann als neuen ersten Wagen zu oder
     * ob es gar keinen ersten Wagen gibt.
     *
     * @return zuLoeschenderWagen
     */
    public Wagen removeErstenWagen() {
        if (ersterWagen.getNaechsterWagen() != null) {
            Wagen zuLoeschenderWagen = ersterWagen;
            ersterWagen = ersterWagen.getNaechsterWagen();

            return zuLoeschenderWagen;
        } // end of if
        else if (ersterWagen != null) {
            Wagen zuLoeschenderWagen = ersterWagen;
            ersterWagen = null;

            return zuLoeschenderWagen;
        } else {
            return null;
        }
    }

    /**
     * Gibt die Laenge und den Typ des Zugs aus.
     *
     * @return ersterWagen
     */
    public String parameterPrint() {
        return "Laenge= " + laenge + "." + " Typ= " + typ + ".";
    }

    /**
     * Returned den letzten Wagen des Zuges.
     *
     * @return
     */
    public Wagen getLetztenWagen() {
        if (ersterWagen.getNaechsterWagen() == null) {
            return ersterWagen;
        } // end of if
        else {
            return ersterWagen.getLetztenWagen();
        } // end of if-else
    }
}
