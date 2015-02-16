package PR1.aufgabe7;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Aufgabe: Aufgabenblatt 4 - OOP Einleitung -
 * Aufgabe 7 Anwendung.java Version 3.0 - final Zweck: Die Klasse Anwendung mit
 * Hilfe von Exceptions weiter absichern
 */

public class Anwendung {
    public static void main(String[] args) {
        try {
            Lokomotive bigChief = new Lokomotive("bigChief", 23, 1183);
            Zug santaFe = new Zug(bigChief);

            // (Laenge , Passagiere)
            santaFe.addWagen(new Wagen(12, 50));
            santaFe.addWagen(new Wagen(15, 20));
            santaFe.addWagen(new Wagen(11, 100));
            santaFe.addWagen(new Wagen(55, 225));

            // santaFe.removeErstenWagen(); //Test remove des ersten Wagens.

            Lokomotive steelHorse = new Lokomotive("steelHorse", 21, 4711);
            Zug rioGrandeExpress = new Zug(steelHorse);

            Wagen wagenNachfolgerTest = new Wagen(18, 80);
            steelHorse.addWagen(new Wagen(13, 60));
            steelHorse.addWagen(wagenNachfolgerTest);
            steelHorse.addWagen(new Wagen(99, 99));

            /**
             * Fehler erwartet, da die L�nge des Wagen nicht zwischen 1 und 100 liegt
             */
            //santaFe.addWagen(new Wagen(103, 225));

            /**
             * Fehler erwartet, da die Passagieranzahl des Wagen nicht zwischen 0 und 500 liegt
             */
            //santaFe.addWagen(new Wagen(100, 503));

            /**
             * Fehler erwartet, da als Argument null �bergeben wird
             */
            //Lokomotive trainCrash = new Lokomotive(null, 23, 1183);
            //Zug testTrain = new Zug(trainCrash);

            /**
             * Fehler erwartet, da als Argument null �bergeben wird
             */
            //steelHorse.addWagen(null);

            /**
             * Fehler erwartet, da wagenNachfolgerTest schon einen Nachfolger
             * hat ->  Zeile 29
             */
            //steelHorse.addWagen(wagenNachfolgerTest);

            /**
             * Fehler erwartet, da "BigChief" bereits einen Wagen hat. Siehe Zeile 17++
             */
            //Zug rioGrandeExpress2 = new Zug(bigChief);

            /**
             * Fehler erwartet, da "santaFe" derselbe Zug ist
             */
            //santaFe.appendZug(santaFe);

            // append normal:
            santaFe.appendZug(rioGrandeExpress);

            rioGrandeExpress.info();
            System.out.println();
            santaFe.info();
        } catch (IllegalArgumentException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
            exceptionObject.printStackTrace();
            return;

        } catch (NullPointerException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
            exceptionObject.printStackTrace();
            return;

        } catch (ZugException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
            exceptionObject.printStackTrace();
            return;
        } finally {
            System.out.println("Zugtest beendet");
        }
    }
}
