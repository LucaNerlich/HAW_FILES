package AD.aufgabe3;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * SiebDesEra.java
 */

/**
 * Algorithm which finds prime numbers pretty quick O(nlogn)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class SiebDesEra {

    private int counter;
    private boolean printNumbers = false;

    /**
     * Algorithm which finds prime numbers pretty quick
     * @param n integer
     */
    public void primzahlenSieb(int n) {
        boolean[] a = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = true;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (a[i] == true) {
                for (int j = 2; i * j < n; j++) {
                    a[i * j] = false;
                    counter++;
                }
            }
        }
        if (printNumbers == true) {
            for (int k = 0; k < a.length; k++) {
                if (a[k] == true) {
                    System.out.println(k);
                }
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
