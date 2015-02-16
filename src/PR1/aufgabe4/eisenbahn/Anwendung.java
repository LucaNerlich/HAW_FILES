package PR1.aufgabe4.eisenbahn;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4 - OOP Einleitung - Aufgabe 2
 * Anwendung.java
 * Version 3.0 - final
 * Zweck: Test der Aufgabe: Eisenbahn
 */
public class Anwendung {
    public static void main(String[] args) {
        Lokomotive bigChief = new Lokomotive("bigChief", 23, 1183);
        Zug santaFe = new Zug(bigChief);

        //(Laenge , Passagiere)
        santaFe.addWagen(new Wagen(12, 50));
        santaFe.addWagen(new Wagen(15, 20));
        santaFe.addWagen(new Wagen(20, 100));
        santaFe.addWagen(new Wagen(55, 225));

        // santaFe.removeErstenWagen(); //Test remove des ersten Wagens.

        Lokomotive steelHorse = new Lokomotive("steelHorse", 21, 4711);
        Zug rioGrandeExpress = new Zug(steelHorse);

        steelHorse.addWagen(new Wagen(13, 60));
        steelHorse.addWagen(new Wagen(18, 80));

        santaFe.appendZug(rioGrandeExpress);
        rioGrandeExpress.info();
        System.out.println();
        santaFe.info();
    }
}
