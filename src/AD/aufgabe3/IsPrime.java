package AD.aufgabe3;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * IsPrime.java
 */

/**
 * Algorithm which decides if a given integer number is a prime number
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class IsPrime {

    private int isPrimeCounter = 0;
    int primCounter = 0;
    boolean counterReset = false;

    /**
     * Algorithm which decides if a given integer number is a prime number
     * @param n int
     * @return boolean -> is prime or not
     */
    public boolean isPrime(int n) {

        boolean isPrime = true;
        if (counterReset) {
            isPrimeCounter = 0;
        }

        if (n % 2 == 0) {
            isPrime = false;
        } else {
            //if not, then just check the odds
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    isPrime = false;
                }
                isPrimeCounter++;
            }
        }

        if (isPrime) {
            primCounter++;
        }

        //alle 10 Primzahlen, Schritte nicht addiert
        if (primCounter % 10 == 0 && isPrimeCounter != 0 && counterReset) {
            System.out.println("n: " + n + " primeCounter: " + isPrimeCounter);
            primCounter = 1;
        }
        return isPrime;
    }

    public int getIsPrimeCounter() {
        return isPrimeCounter;
    }

    public boolean isCounterReset() {
        return counterReset;
    }
}
