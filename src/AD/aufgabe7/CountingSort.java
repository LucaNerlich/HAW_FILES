package AD.aufgabe7;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 7
 * CountingSort.java
 */

import java.util.Arrays;

/**
 * This class represents our CountingSort
 * sorts numerics in O(n)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 *
 *         http://en.wikipedia.org/wiki/Counting_sort
 */
public class CountingSort {

    public void sort(int[] arrayToSort, int low, int high) {
        int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
        for (int x : arrayToSort)
            counts[x - low]++; // - low so the lowest possible value is always 0
        //counts how many times each key occurs

        int current = 0;
        for (int i = 0; i < counts.length; i++) {
            Arrays.fill(arrayToSort, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
            current += counts[i]; // leap forward by counts[i] steps
        }

        /*
        for (int j = current; j < current + counts[j]; j++)
                arrayToSort[j].setKey(j + low);
            current += counts[i]; // leap forward by counts[i] steps
         */
    }

    //http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
    int[] countingSort2(int[] a, int k) {
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;

        for (int i = 1; i < k; i++)
            c[i] += c[i - 1];

        int b[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--)
            b[--c[a[i]]] = a[i];
        return b;
    }
}
