package PR1.aufgabe4.eisenbahn;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4 - OOP Einleitung - Aufgabe 2
 * Lokomotive.java
 * Version 3.0 - final
 * Zweck: Test der Aufgabe: Eisenbahn
 */
public class Lokomotive {
    private final int laenge;
    private final int typ;
    private final String name;
    private Wagen ersterWagen;

    /**
     * Konstruktor
     *
     * @param name
     * @param laenge
     * @param typ
     */
    public Lokomotive(String name, int laenge, int typ) {
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
     * Checkt ob es einen ersten Wagen gibt, dann fuegt einen neuen Wagen an -> Wagen.addWagen
     *
     * @param neuerWagen
     */
    public void addWagen(Wagen neuerWagen) {
        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } // end of if
        else {
            ersterWagen.addWagen(neuerWagen);
        }
    }

    /**
     * Entfernt immer den ersten Wagen hinter der Lok. Checkt ob der erste Wagen einen nachfolger hat
     * und weißt diesen dann als neuen ersten Wagen zu
     * oder ob es gar keinen ersten Wagen gibt.
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
     * Gibt die  Laenge und den Typ des Zugs aus.
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
