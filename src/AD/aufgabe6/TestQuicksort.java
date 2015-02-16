package AD.aufgabe6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6
 * Main.java
 */

/**
 * Testclass for our Quicksort
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestQuicksort {

    @Test
    public void testQuicksort() {
        Quicksort quicksort = new Quicksort();
        Container[] containerEnde = new Container[5];
        Container[] containerMitte = new Container[5];
        Container[] containerRandom = new Container[5];

        // FILL ARRAYS
        containerEnde[0] = new Container(1, "name1");
        containerEnde[1] = new Container(5, "name2");
        containerEnde[2] = new Container(3, "name3");
        containerEnde[3] = new Container(4, "name4");
        containerEnde[4] = new Container(2, "name5");

        containerMitte[0] = new Container(1, "name1");
        containerMitte[1] = new Container(5, "name2");
        containerMitte[2] = new Container(3, "name3");
        containerMitte[3] = new Container(4, "name4");
        containerMitte[4] = new Container(2, "name5");

        containerRandom[0] = new Container(1, "name1");
        containerRandom[1] = new Container(5, "name2");
        containerRandom[2] = new Container(3, "name3");
        containerRandom[3] = new Container(4, "name4");
        containerRandom[4] = new Container(2, "name5");

        assertFalse(containerEnde[4].equals(containerEnde[4].getDataNumber() == 5));

        //PIVOT ENDE
        quicksort.setChoosePivotMethod(0);
        quicksort.sort(containerEnde);
        System.out.println(containerEnde[4].getDataNumber());
        assertEquals(1, containerEnde[4].getDataNumber());
        assertEquals(2, containerEnde[3].getDataNumber());
        assertEquals(3, containerEnde[2].getDataNumber());
        assertEquals(4, containerEnde[1].getDataNumber());
        assertEquals(5, containerEnde[0].getDataNumber());


        //PIVOT MITTE
        quicksort.setChoosePivotMethod(1);
        quicksort.sort(containerMitte);
        System.out.println(containerMitte[4].getDataNumber());
        assertEquals(1, containerMitte[4].getDataNumber());
        assertEquals(2, containerMitte[3].getDataNumber());
        assertEquals(3, containerMitte[2].getDataNumber());
        assertEquals(4, containerMitte[1].getDataNumber());
        assertEquals(5, containerMitte[0].getDataNumber());

        //PIVOT RANDOM
        quicksort.setChoosePivotMethod(2);
        quicksort.sort(containerRandom);
        System.out.println(containerRandom[4].getDataNumber());
        assertEquals(1, containerRandom[4].getDataNumber());
        assertEquals(2, containerRandom[3].getDataNumber());
        assertEquals(3, containerRandom[2].getDataNumber());
        assertEquals(4, containerRandom[1].getDataNumber());
        assertEquals(5, containerRandom[0].getDataNumber());
    }


}
