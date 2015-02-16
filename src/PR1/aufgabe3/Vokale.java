package PR1.aufgabe3; /**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 *         Luca Nerlich (LucaSteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 4
 * Vokale.java
 * Version 1.0
 * Zweck: Einlesen einer Textdatei und ausgeben der Anzahl der Vokale.
 */

import java.io.IOException;


class Vokale {
    public static void main(String[] args) throws IOException {
    /* Variablen */
        int inCharCode;
        char ch;

        double anzahlA = 0;
        double anzahlE = 0;
        double anzahlI = 0;
        double anzahlO = 0;
        double anzahlU = 0;

        double anzahlVokale = 0;
        double anzahlZeilen = 0;
        double anzahlWoerter = 0;

        double anteilA = 0;
        double anteilE = 0;
        double anteilI = 0;
        double anteilO = 0;
        double anteilU = 0;

    /* Einzelne Zeichen (Code) aus der Eingabedatei lesen */
        inCharCode = System.in.read(); // erstes Zeichen lesen

        while (inCharCode >= 0) {
            ch = (char) inCharCode; // Code zu Zeichen casten
                              /* Zeichen verarbeiten */

            switch (ch) { //Vokale zaehlen
                case 'a':
                case 'A':
                    anzahlA++;

                    break;

                case 'e':
                case 'E':
                    anzahlE++;

                    break;

                case 'i':
                case 'I':
                    anzahlI++;

                    break;

                case 'o':
                case 'O':
                    anzahlO++;

                    break;

                case 'u':
                case 'U':
                    anzahlU++;

                    break;

                case ' ': //Woerter zaehlen
                    anzahlWoerter++;

                    break;

                case '\n': //Zeilen zaehlen und je neue Zeile ein Wort
                    anzahlZeilen++;
                    anzahlWoerter++;

                    break;
            }
            inCharCode = System.in.read(); // naechstes Zeichen lesen
        }

        //Berechnung Gesamtzahl Vokale
        anzahlVokale = anzahlA + anzahlE + anzahlI + anzahlO + anzahlU;

        //Berechnung der jeweiligen Anteile
        anteilA = (anzahlA / anzahlVokale) * 100;
        anteilE = (anzahlE / anzahlVokale) * 100;
        anteilI = (anzahlI / anzahlVokale) * 100;
        anteilO = (anzahlO / anzahlVokale) * 100;
        anteilU = (anzahlU / anzahlVokale) * 100;

        System.out.println("Haeufigkeit des Auftretens:");
        System.out.printf("a: %-6.0f %5.1f%% aller Vokale \n", anzahlA, anteilA); //%[Schalter][Breite].[Genauigkeit]Datentyp
        System.out.printf("e: %-6.0f %5.1f%% aller Vokale \n", anzahlE, anteilE); //%Formatierungsbefehl
        System.out.printf("i: %-6.0f %5.1f%% aller Vokale \n", anzahlI, anteilI); //f steht f�r die Dezimalzahl die ausgegeben werden soll
        System.out.printf("o: %-6.0f %5.1f%% aller Vokale \n", anzahlO, anteilO);
        System.out.printf("u: %-6.0f %5.1f%% aller Vokale \n", anzahlU, anteilU);
        System.out.println("Es wurden " + (int) anzahlZeilen + " Zeilen und " +
                (int) anzahlWoerter + " Woerter verarbeitet. "); // Anzahl der Zeilen ist richtig, W�rter genau 20 zu viel...
    }
}
