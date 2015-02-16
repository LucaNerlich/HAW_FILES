package AD.aufgabe3;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * Main.java
 */

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Main {

    private static int debugCounter = 1;

    public static void main(String[] args) {

        FindPrimSlow primSlow = new FindPrimSlow();
        FindPrimQuick primQuick = new FindPrimQuick();
        SiebDesEra siebDesEra = new SiebDesEra();
        IsPrime isPrime = new IsPrime();


        //SLOW:
        for (int i = 0; i < 5000; i += 100) {
            primSlow.primzahlenSlow(i);
            System.out.println("Slow_Counter i: " + primSlow.getCounter());
        }
        //QUICK:
        for (int i = 0; i < 5000; i += 100) {
            primQuick.primzahlenQuick(i);
            System.out.println("Quick_Counter: " + primQuick.getCounter());
        }
        //SIEB:
        for (int i = 0; i < 5000; i += 100) {
            siebDesEra.primzahlenSieb(i);
            System.out.println("Sieb_Counter: " + siebDesEra.getCounter());
        }

        //ISPRIME:
        for (int i = 0; i < 5000; i++) {
            isPrime.isPrime(i);
            //alle 100 i, Schritte addiert
            if (i % 100 == 0 && !isPrime.isCounterReset()) {
                System.out.println(isPrime.getIsPrimeCounter());
            }
        }
    }
}
