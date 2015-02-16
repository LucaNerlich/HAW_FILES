package PR1.aufgabe5.edelsteine;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * EdelsteinBox.java
 * Version 1.0
 * Zweck: Beschreibung Ein Schatzkaestchen kann
 * beliebig mit Edelsteinen gefuellt und Edelsteine entnommen werden. Außerdem
 * kann die Box in form von {DDRRSS} ausgegeben werden.
 */
public class EdelsteinBox {
    /* -------- Objektvariablen -------- */
    private Edelstein[] schatzkaestchen; //Array vom Typ Edelstein

    /**
     * enum Klasse - beinhaltet die drei Edelsteinarten Diamant, Rubin und Smaragd.
     * ----------- Aufzaehlungstypen -----------
     */
    enum Edelstein {
        DIAMAND, RUBIN, SMARAGD, NOTHING;
    }

  /* -------- Konstruktoren -------- */

    /**
     * Default-Konstruktor liefert ein neues, leeres Schatzkaestchen.
     */
    public EdelsteinBox() {
        schatzkaestchen = new Edelstein[20]; //Defaultgroeße von 20

        // schatzkaestchen[0] = Edelstein.DIAMAND;
        // schatzkaestchen[1] = Edelstein.RUBIN;
        // schatzkaestchen[2] = Edelstein.SMARAGD;
        for (int i = 0; i < schatzkaestchen.length; i++) {
            if (schatzkaestchen[i] == null) {
                schatzkaestchen[i] = Edelstein.NOTHING; // Das Schatzkaestchen ist leer wenn alle Plaetze NOTHING stehen haben
            }
        }
    }

    /* -------- Setter und Getter-Methoden -------- */
    public Edelstein[] getSchatzkaestchen() {
        return schatzkaestchen;
    }

    public void setSchatzkaestchen(Edelstein[] schatzkaestchen) {
        this.schatzkaestchen = schatzkaestchen;
    }

    /**
     * Liefert die Anzahl an enthaltenen Edelsteinen der �bergebenen Sorte
     *
     * @param sorte
     * @return zaehler
     */
    public int getAnzahl(Edelstein sorte) {
        int zaehler = 0;

        for (int i = 0; i < schatzkaestchen.length; i++) {
            if (schatzkaestchen[i] == sorte) {
                zaehler++;
            }
        }

        return zaehler;
    }

  /* -------- Hauptmethoden -------- */
    /**
     * fuellt die ersten 3 Plaetze mit Edelsteinen und den Rest mit "Nothing" -
     * also nichts. ATM ueberfl�ssig, da der Konstruktor diese Aufgabe
     * �bernimmt!
     */

    /** public void initialFuellung() {
     for (int i = 0; i < schatzkaestchen.length; i++) {
     if (null == schatzkaestchen[i]) {
     schatzkaestchen[i] = Edelstein.NOTHING;
     }
     }
     }   */

    /**
     * Gibt einen String mit einer Textdarstellung dieses Schatzk�stchens zur�ck
     */
    public String toString() {
        System.out.println("Das Fassungsvermoegen unser Schatzkiste betraegt: " +
                schatzkaestchen.length + " Einheiten.");
        System.out.println();

        return ausgeben(); //Die Methode ausgeben aufrufen
    }

    /**
     * Gibt auf der Konsole eine Zeile mit einer Textdarstellung dieses
     * Schatzk�stchens aus.
     */
    public String ausgeben() {
        String schatzkiste = String.valueOf(schatzkaestchen); // Speichert das Array als String
        System.out.println("Der Inhalt unserer Schatzkiste:");
        System.out.print("(");

        for (int i = 0; i < schatzkaestchen.length; i++) {
            if (schatzkaestchen[i] == Edelstein.DIAMAND) {
                System.out.print("D");
            } else if (schatzkaestchen[i] == Edelstein.RUBIN) {
                System.out.print("R");
            } else if (schatzkaestchen[i] == Edelstein.SMARAGD) {
                System.out.print("S");
            }

            // System.out.println(schatzkaestchen[i]);
        }

        System.out.print(")");
        System.out.println();
        System.out.println();

        return schatzkiste; //String zur�ckgeben, da wir mit toString arbeiten wollen
    }

    /**
     * F�gt diesem Schatzk�stchen n Edelsteine der Sorte sorte hinzu. Ist n
     * gr��er als die Kiste, werden vorher noch alle leeren Plaetze aufgefuellt.
     *
     * @param sorte
     * @param n
     */
    public void hineinlegen(Edelstein sorte, int n) {
        int zaehler = n;

        for (int i = 0; i < schatzkaestchen.length; i++) {
            if ((schatzkaestchen[i] == Edelstein.NOTHING) && (zaehler > 0)) {
                schatzkaestchen[i] = sorte;
                zaehler--;
            } else {
                // System.out.println("Die Schatzkiste ist jetzt voll!");
            }
        }
    }

    /**
     * Entnimmt diesem Schatzk�stchen n Edelsteine der Sorte sorte. Wenn weniger
     * als n Edelsteine der Sorte sorte enthalten sind, werden alle entnommen.
     *
     * @param sorte
     * @param n
     */
    public void herausnehmen(Edelstein sorte, int n) {
        int zaehler = n;

        for (int i = 0; i < schatzkaestchen.length; i++) {
            if ((schatzkaestchen[i] == sorte) && (zaehler > 0)) {
                schatzkaestchen[i] = Edelstein.NOTHING;
                zaehler--;
            } else {
                // System.out.println("Die Kiste ist jetzt leer");
            }
        }
    }

    /**
     * Wandelt alle Edelsteine der Sorte vonSorte in Edelsteine der Sorte
     * zuSorte um.
     *
     * @param vonSorte
     * @param zuSorte
     */
    public void umwandeln(Edelstein vonSorte, Edelstein zuSorte) {
        for (int i = 0; i < schatzkaestchen.length; i++) {
            if (schatzkaestchen[i] == vonSorte) {
                schatzkaestchen[i] = zuSorte;

                // System.out.println(vonSorte + " wurde umgewandelt zu " + zuSorte);
            } else {
                // System.out.println("Es gibt keine Edelsteine zum Umwandeln!");
            }
        }
    }

    /**
     * Entleert dieses Schatzk�stchen. Es enth�lt dann keine Edelsteine mehr.
     */
    public void leeren() {
        for (int i = 0; i < schatzkaestchen.length; i++) {
            schatzkaestchen[i] = Edelstein.NOTHING;
        }

        System.out.println("( )");
    }

  /* -------- Hilfsmethoden -------- */
  /*
  * public static void main(String[] args) { int diamandTest =
  * Edelstein.DIAMAND.ordinal(); int rubinTest = Edelstein.RUBIN.ordinal();
  * int smaragdTest = Edelstein.SMARAGD.ordinal();
  * System.out.println(diamandTest); System.out.println(rubinTest);
  * System.out.println(smaragdTest); }
  */
}
