package PR1.aufgabe6.widerstandsnetz;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 2
 * WiderstandsnetzTest.java
 * Version 1.0
 * Zweck: Testklasse, baut ein Netz auf gibt und den Gesamtwiderstand aus.
 */
public class WiderstandsnetzTest {
    public static void main(String[] args) {
        /**
         * Die Widerst�nde R1 bis R6 haben die Werte 100 Ohm, 200 Ohm,..., 600 Ohm.
         */
        Widerstand R1 = new Widerstand(100);
        Widerstand R2 = new Widerstand(200);
        Widerstand R3 = new Widerstand(300);
        Widerstand R4 = new Widerstand(400);
        Widerstand R5 = new Widerstand(500);
        Widerstand R6 = new Widerstand(600);

        //System.out.println("Anzahl der einfachen Widerst�nde: " +R1.anzahlWiderstaende());
        // R6.getWiederstandswert();

        /**
         * Ein Potenziometer erstellen
         */
        Potenziometer PO1 = new Potenziometer(0);

        /**
         * Folgend der Netzaufbau des Schaltkreis:
         */

        // ParallelesWiderstandsnetz P1 = new ParallelesWiderstandsnetz(R1,R2);
        // ParallelesWiderstandsnetz P3 = new ParallelesWiderstandsnetz(P1,P1);
        System.out.println("-------------");
        System.out.println("Berechnung vom Gesamtwiderstand:");
        System.out.println("-------------");

        ParallelesWiderstandsnetz P1 = new ParallelesWiderstandsnetz(R1, R3);
        System.out.println("P1: " + P1.getOhm() + " Ohm");

        SeriellesWiderstandsnetz S1 = new SeriellesWiderstandsnetz(P1, R2);
        System.out.println("S1: " + S1.getOhm() + " Ohm");

        SeriellesWiderstandsnetz S2 = new SeriellesWiderstandsnetz(R4, R5);
        System.out.println("S2: " + S2.getOhm() + " Ohm");

        ParallelesWiderstandsnetz P2 = new ParallelesWiderstandsnetz(S1, S2);
        System.out.println("P2: " + (int) P2.getOhm() + " Ohm");

        ParallelesWiderstandsnetz P3 = new ParallelesWiderstandsnetz(P2, R6);
        System.out.println("-------------");
        /**
         * Berechneten Gesamtwiderstand ausgeben:
         */
        System.out.println("P3 Gesamt: " + (int) P3.getOhm() + " Ohm");

        System.out.println("-------------");
        //System.out.println("Anzahl der zusammengesetzten Widerst�nde: " +P3.anzahlWiderstaende()+"\r\n");
        // System.out.println(P1.anzahlWiderstaende());

        //System.out.println(R1.toString());

        System.out.println("\r\n------ POTENZIOMETER-------");
        /**
         * Schreiben Sie eine neue Anwendung, die eine Liste der
         * Widerstandswerte der modifizierten Schaltung ausgibt, wenn das
         * Potenziometer in Schritten von 200 von 0 bis auf 5000 Ohm
         * hochgeregelt wird.
         */
        for (int i = 0; i <= 5000; i += 200) {
            PO1.setOhm(i);

            ParallelesWiderstandsnetz PP1 = new ParallelesWiderstandsnetz(R1, R3);

            // System.out.println("PP1: " + PP1.getOhm() + " Ohm");
            SeriellesWiderstandsnetz SS1 = new SeriellesWiderstandsnetz(PP1, R2);
            // System.out.println("SS1: " + SS1.getOhm() + " Ohm");
            System.out.println("Potenziometer Ohm (R4): " + (int) PO1.getOhm()); // testausgabe

            SeriellesWiderstandsnetz SS2 = new SeriellesWiderstandsnetz(PO1, R5);

            // System.out.println("SS2: " + SS2.getOhm() + " Ohm");
            ParallelesWiderstandsnetz PP2 = new ParallelesWiderstandsnetz(SS1, SS2);

            // System.out.println("PP2: " + (int) PP2.getOhm() + " Ohm");
            ParallelesWiderstandsnetz PP3 = new ParallelesWiderstandsnetz(PP2, R6);

            System.out.println("PP3 Gesamt: " + PP3.getOhm() + " Ohm");
            System.out.println();
        }
        System.out.println("-------------");
    }
}
