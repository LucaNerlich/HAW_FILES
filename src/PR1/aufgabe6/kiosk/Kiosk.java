package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 1
 * Kiosk.java
 * Version 1.0
 * Zweck: Speichern und verwalten der Objekte (Warenbestand)
 */
public class Kiosk {
    /* -------- Objektvariablen -------- */
    private int maxAnzahlWaren;
    private Ware[] Warenbestand;

    /* -------- Konstruktoren -------- */
    Kiosk(int maxAnzahlWaren) { //Konstruktor erzeugt das Array f�r den Warenbestand mit �bergebener Gr��e
        this.maxAnzahlWaren = maxAnzahlWaren;
        Warenbestand = new Ware[maxAnzahlWaren];

        // Warenbestand[0] = new Zeitschrift("test", 1, 2, 3);
        // Warenbestand[1] = new Zeitschrift("test2", 1, 2, 3);
        // Warenbestand[2] = new Zeitschrift("test3", 99, 99, 99);
        // Warenbestand[3] = new Zeitschrift("test4", 1, 2, 3);
    }

  /* -------- Hauptmethoden -------- */

    /**
     * Repr�sentiert das Objekt
     */
    public String toString() {
        return "Die Bestandsliste kann " + maxAnzahlWaren +
                " Zeilen von Ware erfassen:\r\n";
    }

    /**
     * F�gt die �bergebene Waren-Objekte (Varargs!) dem aktuellen Warenbestand
     * hinzu.
     *
     * @param neueWaren
     */
    public void addWare(Ware... neueWaren) {
        int zaehler = neueWaren.length;
        int zaehlerSpeicher = zaehler; // Damit wir "vorne" anfangen
        int warenZaehler = 0;

        //zaehlt die Anzahl der Warenobjekte
        for (int i = 0; i < Warenbestand.length; i++) {
            if (Warenbestand[i] != null) {
                warenZaehler++;
            }
        }

        // Fall abfangen, dass Warenbestand[] zu gro� werden w�rde
        if ((warenZaehler + zaehler) > Warenbestand.length) {
            Ware[] neuerWarenbestand = new Ware[warenZaehler + zaehler + 50]; //neues Array mit einer Reserve von 50 erzeugen

            for (int i = 0; i < Warenbestand.length; i++) {
                neuerWarenbestand[i] = Warenbestand[i]; //Den Bestand ins neue Array �berf�hren
            }

            Warenbestand = neuerWarenbestand;
            System.out.println("Das Lager wurde erfolgreich vergroessert!");
        }

        //fuegt die neue Ware hinzu
        int i = 0;

        while (zaehler > 0) {
            if (Warenbestand[i] == null) { //Also noch frei
                Warenbestand[i] = neueWaren[zaehlerSpeicher - zaehler]; //Schreibt die neue Ware in die Bestandsliste
                zaehler--;
            } else {
                i++; //gehe zum n�chsten Platz wenn nicht frei
            }
        }
    }

    /**
     * Entfernt die �bergebene Ware (als Objekt) aus dem aktuellen Warenbestand.
     *
     * @param alteWare
     */
    public void removeWare(Ware alteWare) {
        int zaehler = 1;

        for (int i = 0; i < Warenbestand.length; i++) {
            if ((Warenbestand[i] == alteWare) && (zaehler != 0)) {
                Warenbestand[i] = null;
                zaehler = 0; //Damit das Objekt nur einmal gel�scht wird
            }

            /**
             * Verschieben der Array-Elemente nach dem L�schen
             */
            for (; i < (Warenbestand.length - 1); i++) {
                Warenbestand[i] = Warenbestand[i + 1];
            }
        }
    }

    /**
     * Liefert die zur �bergebenen Bezeichnung zugeh�rige Ware (als Objekt)
     * zur�ck.
     *
     * @param bezeichnung
     * @return
     */
    public Ware getWare(String bezeichnung) {
        for (int i = 0; i < Warenbestand.length; i++) {
            String name = Warenbestand[i].getBezeichnung();

            if (name.equals(bezeichnung)) {
                return Warenbestand[i];
            }
        }

        return null;
    }

    /**
     * Ver�ndert die vorhandene St�ckzahl der �bergebenen Ware. Ist der Wert
     * anzahl negativ, wird die St�ckzahl erniedrigt.
     *
     * @param ware
     * @param anzahl
     */
    public void aendereStueckzahl(Ware ware, int anzahl) {
    /*
    * int zaehler = 0; for (int i = 0; i < Warenbestand.length; i++) { if
    * (Warenbestand[i] == ware) { zaehler++; } } if (anzahl > zaehler) {
    * int differenzPLUS = anzahl - zaehler; for (int j = 0; j <
    * Warenbestand.length; j++) { if (Warenbestand[j] == null &&
    * differenzPLUS > 0) { Warenbestand[j] = ware; differenzPLUS--; } } }
    *
    * else if (anzahl < 0) { int differenzMINUS = anzahl; for (int j = 0; j
    * < Warenbestand.length; j++) { if (Warenbestand[j] == ware &&
    * differenzMINUS < 0) { Warenbestand[j] = null; differenzMINUS++; } } }
    */
        ware.setStueckzahl(anzahl); // Ruft die Methode in dem Interface auf
    }

    /**
     * Gibt auf der Konsole eine Liste aller aktuell im Sortiment befindlichen
     * Waren aus, wobei f�r jede Ware folgende Informationen enthalten sein
     * sollen: Bezeichnung, Preis, St�ckzahl und ggf. ein Warnhinweis, falls die
     * Ware gesundheitsgef�hrdend ist.
     */
    public void druckeInventarliste() {
        System.out.println("************* Aktueller Warenbestand *************");
        System.out.println("Bezeichnung            Preis            Stueckzahl");

        for (int i = 0; i < Warenbestand.length; i++) {
            if (Warenbestand[i] != null) {
                // System.out.println(Warenbestand[i]);
                Warenbestand[i].ausgeben();
            }
        }
    }

    /**
     * testmethode zur �bersicht
     */
    public void druckeInventarlisteNEU() {
        for (int i = 0; i < Warenbestand.length; i++) {
            System.out.println(Warenbestand[i]);
        }
    }
}
