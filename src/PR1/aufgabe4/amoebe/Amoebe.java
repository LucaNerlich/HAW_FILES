package PR1.aufgabe4.amoebe;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4 - OOP Einleitung - Aufgabe 1
 * Amoebe.java
 * Version 1.0
 * Zweck:
 */

class Amoebe {
    /* -------- Konstanten -------- */
    private final boolean GESCHLECHT;

    /* -------- Objektvariablen -------- */
    private int groesse;
  
  /* -------- Konstruktoren -------- */

    /**
     * Konstruktor fuer eine neue weibliche (Aufruf mit true) oder maennliche
     * (false) Amoebe der Groeße 1
     */
    Amoebe(boolean weiblich) { //Konstruktor mit einem Parameter weiblich*/
        groesse = 1; //Instanzvariable zuweisen Defaultwert fuer groesse =1
        GESCHLECHT = weiblich;
    }
  
  /* -------- Oeffentliche Methoden -------- */

    /**
     * liefert das Geschlecht (Ergebnis true = weiblich, false = maennlich)
     */
    boolean istWeiblich() {
        return GESCHLECHT;
    }

    /**
     * liefert die aktuelle die Groeße
     */
    int getGroesse() {
        return groesse;
    }

    /**
     * fuettert diese Amoebe, die dabei um 1 waechst
     */
    void futter() {
        groesse++;
    }

    /**
     * laesst diese Amoebe hungern, die dabei um 1 schrumpft. Die Mindestgroeße ist
     * 1 Auch wenn eine Amoebe hungert, wird sie nicht mehr kleiner als 1
     */
    void hunger() {
        if (groesse > 1) {
            groesse--;
        }
    }


    Amoebe teile() { //R�ckgabewert ist Referenztyp (Klasse Amoebe)

        if (groesse < 5) {
            return null; // Wenn die groesse kleiner 5 dann wird dem Objekt null "no Object" zugewiesen -> in TestKlasse in Zeile 37
        } else {
            Amoebe amoebe = new Amoebe(GESCHLECHT); //hier wird der Konstruktor mit einem Parametern aufgerufen
            amoebe.groesse = (groesse / 2); //die neue Amoebe bekommt groesse der alten Amoebe durch zwei zugewiesen
            groesse -= (groesse / 2); // die Alte Amoebe muss dann auch durch zwei geteilt werden   [-=] ->  groesse=groesse-(groesse/2)

            return amoebe; //R�ckgabewert, das in dieser Methode erstellte Objekt
        } // end of if-else
    }


    Amoebe vereinige(Amoebe andereAmoebe) { //Parameter ist eine Referenzvariable fuer zuvereinigende Amoebe (m1)

        if ((GESCHLECHT == andereAmoebe.istWeiblich()) || //Vergleich wie in Aufgabenstellung
                (groesse == andereAmoebe.getGroesse())) {
            return null;
        } else {
            if (andereAmoebe.getGroesse() > groesse) {
                return (new Amoebe(andereAmoebe.istWeiblich())); //Wenn die zweite Amoebe groesser ist hat die neue Amoebe das Geschlecht der Zweiten
            } else {
                return (new Amoebe(GESCHLECHT)); //Wenn die Erste Amoebe groesser ist hat die neue Amoebe das Geschlecht der Erster
            }
        }
    }

    boolean angreifen(Amoebe feind) {
        if ((GESCHLECHT == false) && (GESCHLECHT == feind.istWeiblich()) &&
                (groesse != feind.getGroesse())) { //Wenn beide maennlich und unterschiedlich groß (w2 wird von w5 angegriffen)

            if (feind.getGroesse() > groesse) { //Wenn der Feind groeßer ist als der Verteildiger

                while (groesse > 1) { // Dann wird der Verteildiger auf groesse 1 geschrumpft und der Feind solange vergrossert
                    feind.futter();
                    hunger();
                } // end of while
            } else {
                while (feind.getGroesse() > 1) { // Wenn Verteildiger groesser dann andersrum
                    futter();
                    feind.hunger();
                }
            } // end of if-else

            return true; // beide maennlich und unterschiedlich groß dann true
        } else {
            return false; // beide weiblich also anderer weg sich zubekaempfen
        }
    }

    void ausgeben() {
        if (GESCHLECHT == true) {
            System.out.println("Amoebe: weiblich (" + GESCHLECHT + ")  Groeße: " +
                    groesse);
        } else {
            System.out.println("Amoebe: maennlich (" + GESCHLECHT + ") Groeße: " +
                    groesse);
        } // end of if
    }
}
