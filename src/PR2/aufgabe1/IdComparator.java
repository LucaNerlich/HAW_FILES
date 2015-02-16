/**
 * Praktikum WIPR2, SS 2014  
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1
 * IdComparator.java
 */
package PR2.aufgabe1;

import java.util.Comparator;

/**
 * Diese Klasse repr�sentiert den ID-Comparator (Vergleich von IDs)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) & (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class IdComparator implements Comparator<Customer> {

    /**
     * Override Compare f�r ID
     *
     * @param Customer arg0, Customer arg1 -> repr�sentiert die beiden Kundenobjekte die verglichen werden
     * @return result -> repr�sentiert den Ergebniswert aus dem Vergleich
     */
    public int compare(Customer arg0, Customer arg1) {

        // vergleichen mit < > = und dann 0,1,-1 returnen
        int result = -1;

        if (arg0.getId() > arg1.getId()) {
            result = 1;
        } else if (arg0.getId() == arg1.getId()) {
            result = 0;
        }

        return result;
    }

}
