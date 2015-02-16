package AD.aufgabe6;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6
 * Quicksort.java
 *
 * http://codereview.stackexchange.com/questions/42750/quicksort-of-comparable
 * http://www.java-blog-buch.de/d-objekte-sortieren-comparator-und-comparable/
 * http://stackoverflow.com/questions/6944345/quick-sort-in-java-using-comparable
 * http://www.java-uni.de/index.php?Seite=86
 */

import java.util.Random;

/**
 * Quicksort algorithm implementation with 3 pivot methods
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Quicksort {

    private int choosePivotMethod = 0; //MAKE 2 FOR RANDOM; 1 FOR MIDDLE; O FOR LAST ELEMENT
    private int counter;

    /**
     * Uses quicksort to sort an array
     *
     * @param comparables the array you want to sort using quicksort
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] comparables) {
        quicksort(comparables, 0, comparables.length - 1);
    }

    /**
     * private methods which executes the algorith.
     * @param comparables T[]
     * @param start
     * @param ende
     */
    private <T extends Comparable<T>> void quicksort(T[] comparables, int start, int ende) {


        if (ende > start) {
            int i = start;
            int j = ende - 1;
            //ARBEITSBREICH IMMER NUR VOM ANFANG BIS 1 VOR PIVOT, PIVOT MUSS NACH HINTEN GESWAPT WERDEN

            T pivot = getPivot(comparables, start, ende); // int wert um die PivotMethode auszuwaehlen.

            //anfang tausch logik
            while (true) {
                while (comparables[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (comparables[j].compareTo(pivot) >= 0 && j > 0) {
                    j--;
                }
                if (i >= j) {
                    // in der Mitte getroffen
                    break;
                }
                //vertauschen
                swap(comparables, i, j);
                counter++;
            }
            //ende tausch logik

            //pivot in die Mitte tauschen
            swap(comparables, i, ende);
            counter++;

            quicksort(comparables, start, i - 1);
            quicksort(comparables, i + 1, ende);
        }
    }

    /**
     * private method to determine the pivot element
     * @param comparables T[]
     * @param start int
     * @param ende int
     * @return int
     */
    private <T extends Comparable<T>> T getPivot(T[] comparables, int start, int ende) {
        T pivot;

        // MITTE
        if (choosePivotMethod == 1) {
            int middle = start + (ende - start) / 2;
            pivot = comparables[middle];
            swap(comparables, ende, middle);
            counter++;
        }
        // RANDOM
        if (choosePivotMethod == 2) {
            //Random rand = new Random();
            //int pivotRandom = start + rand.nextInt(ende - start + 1);

            int pivotRandom = start + (int) Math.random() * (ende - start + 1);

            pivot = comparables[pivotRandom];
            swap(comparables, ende, pivotRandom);
            counter++;
        } else {
            pivot = comparables[ende];
        }

        return pivot;
    }

    /**
     * swaps the two element at the given integers.
     * @param comparables
     * @param x to be replaced by y
     * @param y to be replaced by x
     */
    private <T extends Comparable<T>> void swap(T[] comparables, int x, int y) {
        T cacheContainer = comparables[x];
        comparables[x] = comparables[y];
        comparables[y] = cacheContainer;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getChoosePivotMethod() {
        return choosePivotMethod;
    }

    public void setChoosePivotMethod(int choosePivotMethod) {
        this.choosePivotMethod = choosePivotMethod;
    }
}
