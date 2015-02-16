package AD.aufgabe3;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * FindPrimQuick.java
 */

/**
 * Algorithm which finds prime numbers rather quickly O(n²)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class FindPrimQuick {

    private int counter = 0;
    private boolean printNumbers = false;

    /**
     * Algorithm which finds prime numbers rather quickly
     * @param n integer
     */
    public void primzahlenQuick(int n) {
        boolean a[] = new boolean[n];
        int i;
        int j;
        for (i = 0; i < n; i++) {
            a[i] = true;
        }
        for (i = 3; i < n; i += 2) { //muss nur ueber alle ungeraden laufen
            if (i != n - 1) {
                a[i + 1] = false; //alle geraden automatisch false
            }
            if (a[i]) { //alle false bereits ausfiltern
                for (j = 2; j < Math.sqrt(i); j++) { //wurzel i, da wir dann bereits alle möglichen Divisoren getestet haben.
                    if ((i % j == 0) && (j != i)) {
                        a[i] = false;
                        break; //bereits 1x Division gefunden
                    }
                    counter++;
                }
            }
        } // alle i, fur die a[i] noch auf true steht, sind Primzahlen
        if (printNumbers == true) {
            for (int k = 0; k < a.length; k++) {
                if (a[k]) {
                    System.out.println(k);
                }
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
