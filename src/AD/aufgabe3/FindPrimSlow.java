package AD.aufgabe3;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * FindPrimSlow.java
 */

/**
 * Algorithm which finds prime numbers quite slow O(n²)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class FindPrimSlow {

    private int counter = 0;
    private boolean printNumbers = false;

    /**
     * Algorithm which finds prime numbers quite slow
     * @param n integer
     */
    public void primzahlenSlow(int n) {
        boolean a[] = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++) {
            a[i] = true;
        }
        for (i = 2; i < n; i++) {
            for (j = 2; j < n; j++) {
                if ((i % j == 0) && (j != i)) {
                    a[i] = false;
                }
                counter++;
            }
        } // alle i, fur die a[i] noch auf true steht, sind Primzahlen
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
