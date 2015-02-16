package AD.aufgabe11;

import java.util.ArrayList;
import java.util.List;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 11
 * Hashing.java
 *
 * Hashing class. Hashes a key String and stores the given Value
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Hashing {
    public List[] hashs;

    public Hashing(int hashSize) {
        this.hashs = new List[hashSize];
        for (int i = 0; i < hashs.length; i++) {
            hashs[i] = new ArrayList();
        }
    }

    /**
     * Inserts a value at an index which is determined by the key and its correspondig hashvalue.
     * @param key -> String will be hashed.
     * @param value -> String will be stored.
     * @throws ArrayIndexOutOfBoundsException
     */
    public void insertKey(String key, String value) throws ArrayIndexOutOfBoundsException {
        insertKeyHelper(key, value, 0);
    }

    /**
     * @param key -> String will be hashed.
     * @param value -> String will be stored.
     * @param iterationCounter -> counts the collisions.
     */
    private void insertKeyHelper(String key, String value, int iterationCounter) {
        int hashIndex = getHashIndex(key);
        List keyValueStore = new ArrayList(2);
        keyValueStore.add(key);
        keyValueStore.add(value);

        if (hashIndex < 0) {
            throw new ArrayIndexOutOfBoundsException("Der Wert liegt entweder außerhalb des Arrays oder ist > " + Integer.MAX_VALUE);
        }

        // Seperate Chaining, wenn belegt, wirds neu gehashed mit hi(k) + i;
        if (hashs[hashIndex].size() == 0) {
            hashs[hashIndex].add(0, keyValueStore);
            // System.out.println("List was empty, added value: " + value + " at the position: " + iterationCounter);
            // System.out.println();
            iterationCounter++;
        } else if (hashs[hashIndex].size() > iterationCounter) {
            insertKeyHelper(key, value, iterationCounter + 1);
            // System.out.println("Liste bei Index " + iterationCounter + " war bereits belegt -> Kollision!");
        } else {
            //wenn Liste nicht voll, wird das Element hinzugefuegt
            hashs[hashIndex].add(iterationCounter, keyValueStore);
            // System.out.println("Succesfully inserted a value with the key: " + key + " at the position: " + hashIndex + "/itC: " + iterationCounter);
            iterationCounter++;
            //  System.out.println();
        }
    }

    /**
     * Gibt eine Liste der Werte zurueck, die bei dem Hashwert des Keys hinterlegt sind.
     * @param key String -> gets hashed. Values will be stored at that index.
     * @return
     */
    public String findByKey(String key) {
        int hashIndex = getHashIndex(key);

        //The HashIndex Element has a List with which contains another list for each collision item.
        // This "Third" list contains each key and its corresponding value
        for (int i = 0; i < hashs[hashIndex].size(); i++) {
            List checkForKey = (List) hashs[hashIndex].get(i);
            for (int j = 0; j < checkForKey.size(); j++) {
                if (checkForKey.get(0).equals(key)) {
                    return checkForKey.get(1).toString();
                }
            }
            //System.out.println(hashs[hashIndex].get(i));
        }

        if (hashs[hashIndex].size() == 0) {
            System.err.println("Es gibt keinen zum Schluessel passenden Wert!");
        }

        //returns the list which includes every value with the given key.
        return "Es gibt keinen zum Schluessel passenden Wert!";
    }

    /**
     * Returns the hashvalue for a given String
     * @param key -> String which you want to hash.
     * @return -> int hashvalue
     */
    private int getHashIndex(String key) {
        long hashValue = 0;
        int hashIndex;

        int arraySize = getArraySize();
        //double goldenerSchnitt = (Math.sqrt(5) - 1) / 2;
        for (int i = 0; i < key.length(); i++) {
            // hashValue += Math.pow(key.charAt(i) * 31, key.length());
            // einfaches mupltiplizieren mit 31
            // arrayindex = hashwert % arraylaenge
            // arraylaenge = primzahl x
            // hashValue += key.charAt(i) * Math.pow(31, key.length() - i);
            // hashValue += key.charAt(i) * 3.1415927;
            hashValue += Math.pow(key.charAt(i) * 31, key.length() - i);
            // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
            //System.out.println("Hashvalue after Function: " + hashValue);

            //256^1, 256^2 ... 256^n
            // mit dem goldenen Schnitt
            // hashValue += (key.charAt(i)* goldenerSchnitt);
        }

        //add i bei zweiten durchgang, if kollision in liste
        //hashValue = hashValue * 31;
        hashValue = hashValue % arraySize;
        //System.out.println("HashValue after Modulo: " + hashValue);
        //  hashIndex = hashValue % arraySize;
        hashIndex = (int) hashValue;
        return hashIndex;
    }

    public int getArraySize() {
        return hashs.length;
    }
}
