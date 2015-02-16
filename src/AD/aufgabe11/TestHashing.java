package AD.aufgabe11;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 11
 * TestHashing.java
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testclass for your hashing algorithm
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */

public class TestHashing {

    @Test
    public void test() {
        Hashing hashing = new Hashing(7); //primzahl x

        //insert values:
        hashing.insertKey("key1", "value1");
        hashing.insertKey("key2", "value2");
        hashing.insertKey("key3", "value3");
        hashing.insertKey("key4", "value4");
        hashing.insertKey("key5", "value5");
        hashing.insertKey("key6", "value6");
        hashing.insertKey("key7", "value7");

        for (int i = 0; i < hashing.hashs.length; i++) {
            System.out.println(hashing.hashs[i].size());
        }

        //find value by key:
        System.out.println("key 1, value1");
        System.out.println(hashing.findByKey("key1"));

        assertEquals("value1", hashing.findByKey("key1"));
    }
}
