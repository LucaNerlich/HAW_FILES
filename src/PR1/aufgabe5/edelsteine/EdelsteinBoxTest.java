package PR1.aufgabe5.edelsteine;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5, Aufgabe 1
 * EdelsteinBoxTest.java
 * Version 1.0
 * Zweck: Die Klasse EdelsteinBoxTest, testet alle �ffentlichen Methoden. Der Test soll
 * sowohl durch entsprechende Ausgaben wie auch durch automatische �berpr�fung
 * der erwarteten Anzahl an Edelsteinen durchgef�hrt werden.
 */
class EdelsteinBoxTest {
    public static void main(String[] args) {
        /**
         * Das Schatzk�stchen wird mit dem Default-Konstruktor erzeugt.
         */
        EdelsteinBox schatzkaestchen = new EdelsteinBox();

        // schatzkaestchen.initialFuellung();

        /**
         * Edelsteine hinzuf�gen (Sorte, Anzahl)
         */
        schatzkaestchen.hineinlegen(EdelsteinBox.Edelstein.RUBIN, 2);
        schatzkaestchen.hineinlegen(EdelsteinBox.Edelstein.DIAMAND, 5);
        schatzkaestchen.hineinlegen(EdelsteinBox.Edelstein.SMARAGD, 3);
        // schatzkaestchen.hineinlegen(EdelsteinBox.Edelstein.RUBIN, 2);


        /**
         * Edelsteine herausnehmen (Sorte, Anzahl)
         */
        schatzkaestchen.herausnehmen(EdelsteinBox.Edelstein.DIAMAND, 2);


        /**
         * Edelsteine umwandeln (von Sorte, zur Sorte)
         */
        schatzkaestchen.umwandeln(EdelsteinBox.Edelstein.RUBIN,
                EdelsteinBox.Edelstein.DIAMAND);


        /**
         * Repr�sentiert das Schatzk�stchen
         */
        schatzkaestchen.toString();
        // schatzkaestchen.ausgeben();
        // schatzkaestchen.leeren();

        /**
         * Die Anzahl der jeweiligen Edelsteinsorte ausgeben
         */
        System.out.println("Es sind "
                + schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.DIAMAND)
                + " Diamanten enthalten.");
        System.out.println("Es sind "
                + schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.RUBIN)
                + " Rubine enthalten.");
        System.out.println("Es sind "
                + schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.SMARAGD)
                + " Smaragde enthalten.");

        teste(schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.DIAMAND) == 5);
        teste(schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.RUBIN) == 0);
        teste(schatzkaestchen.getAnzahl(EdelsteinBox.Edelstein.SMARAGD) == 3);

        System.out.println("\r\nTests durchlaufen. Falls bisher keine Exception zu sehen war, ist alles ok!");

    }

    public static void teste(boolean bedingung) {
    /* Ausgabe des StackTrace, wenn die Bedingung false ist */
        if (!bedingung) {
            new Exception("Testfehler gefunden").printStackTrace();
        }
    }
  
  /*
  * int diamandTest = Edelstein.DIAMAND.ordinal(); int rubinTest =
  * Edelstein.RUBIN.ordinal(); int smaragdTest = Edelstein.SMARAGD.ordinal();
  * System.out.println(diamandTest); System.out.println(rubinTest);
  * System.out.println(smaragdTest);
  * 
  * } /* -------- Konstanten --------
  */

}
