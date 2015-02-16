package PR1.aufgabe6.kiosk;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6, Aufgabe 1
 * KioskTest.java
 * Version 1.0
 * Zweck: Kioskanwendung - Ausgabe der Waren
 */
public class KioskTest {
    public static void main(String[] args) {
        /**
         * Der Warenbestand vom Kiosk mit Gr��e
         */
        Kiosk kiosk = new Kiosk(100);    //Array wird automatisch vergr��ert, wenn der Platz nicht reicht!

        /**
         * Zeitschrift-Objekte erzeugen (Titel, Erscheinungsdatum, Preis, St�ckzahl)
         */
        Ware Spiegel = new Zeitschrift("Spiegel", 21112013, 4.00, 10);
        Ware Stern = new Zeitschrift("Stern", 23112013, 3.25, 12);

        /**
         * Zigaretten-Objekte erzeugen (Markenname, Preis, St�ckzahl)
         */
        Ware Marlboro = new Zigarettenmarke("Marlboro", 6.00, 50);
        Ware West = new Zigarettenmarke("West", 6.20, 30);
        Ware Nil = new Zigarettenmarke("Nil", 5.80, 20);

        /**
         * Getr�nk-Objekte erzeugen (Getr�nketyp, Markenname, Preis, Flaschengr��e, St�ckzahl)
         */
        Ware CocaCola = new Getraenk("CocaCola", "CocaCola", 2.00, 1, 10);
        Ware FlensburgerPilsener = new Getraenk("BIER", "F_Pilsener", 1.20, 1 / 2,
                30);
        Ware Klarer = new Getraenk("SCHNAPS", "Klarer", 11.90, 3 / 4, 5);

        /**
         * Neue Ware hinzuf�gen
         */
        kiosk.addWare(Spiegel, Stern, Marlboro, West, Nil, CocaCola,
                FlensburgerPilsener, Klarer);

        /**
         * Inventurliste ausgeben
         */
        kiosk.druckeInventarliste();
        System.out.println("---------------------------");
        System.out.println();

        /**
         * Die Flaschengr��e (in Litern) f�r CocaCola-Flaschen ausgeben
         */
        System.out.println("CocaCola Flaschengroesse: " + CocaCola.getGroesse() +
                " Liter");
        System.out.println();

        // kiosk.druckeInventarlisteNEU();

        //System.out.println(kiosk.getWare("Nil"));

        /**
         * St�ckzahl �ndern
         */
        kiosk.aendereStueckzahl(CocaCola, 9);

        /**
         * St�ckzahl erneut �ndern
         */
        kiosk.aendereStueckzahl(CocaCola, 14);

        System.out.println();
        System.out.println("Cola Preis: " + CocaCola.getPreis());
        System.out.println("Klarer Stueckzahl: " + Klarer.getVorhandeneStueckzahl());
        System.out.println("Klarer: " + Klarer.istGesundheitsgefaehrdend()); //sollte true sein
        System.out.println("Stern: " + Stern.istGesundheitsgefaehrdend()); //sollte false sein
        System.out.println();

        /**
         * Die Zigarettenmarke �West� aus dem Warenbestand entfernen
         */
        kiosk.removeWare(West);

        /**
         * Neue Inventurliste ausgeben
         */
        kiosk.druckeInventarliste();
        System.out.println();

        System.out.println(kiosk.getWare("Marlboro"));


        // System.out.println(CocaCola.getVorhandeneStueckzahl());
        //kiosk.getWare("Nil");
    }
}
