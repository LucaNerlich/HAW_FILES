package AD.aufgabe2;

import java.util.Arrays;
import java.util.EmptyStackException;
/* Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2
 * Stack.java
 */

/**
 * This class represents our Stack => LiFo (Last in First out), FiLo(First in Last out)
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Stack implements Stackable {
    int amountOfStoredItems = 0;
    String[] store = null;

    public Stack(int maxAnzahl) {
        if (maxAnzahl <= 0) {
            throw new IllegalArgumentException("The number must be at least 1");
        }
        store = new String[maxAnzahl];
    }

    /**
     * The push method creates a new element on the stack.
     *
     * @param element
     */
    @Override
    public void push(String element) {

        if (amountOfStoredItems == store.length) {
            extendStore();
        }
        for (int i = 0; i < store.length; i++) {
            if (store[i] == null || store[i].equals("")) {
                store[i] = element;
                amountOfStoredItems++;
                break;
            }
        }
    }

    /**
     * This Method returns the top element of the stack without removing it.
     *
     * @return the top element in the stack.
     */
    @Override
    public String top() {
        String element = null;
        if (!isEmpty()) {
            element = store[amountOfStoredItems - 1]; //Index bedingt, da wir beim Array bei 0 anfangen
        }
        return element;
    }

    /**
     * The pop method fetches (away) the top element from the stack
     *
     * @throws EmptyStackException
     */
    @Override
    public void pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        store[amountOfStoredItems - 1] = null;
        amountOfStoredItems--;
    }

    /**
     * This Method checks if the stack is emtpy.
     *
     * @return true if stack is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return amountOfStoredItems <= 0;
    }

 /*   public void printAll() {
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i]);
        }
    }
*/

    /**
     * This Method returns the size of the Stack (Array-Size)
     *
     * @return size of the stack(int)
     */
    public int getSize() {
        return store.length;
    }

    /**
     * ToString represents our Stack
     */
    @Override
    public String toString() {
        return "MyStack [Elemente=" + Arrays.toString(store) + ", top=" + amountOfStoredItems + "]";
    }

    /**
     * This method helps us to expand the stack if its full.
     */
    private void extendStore() {
        System.out.println("STACK SUCCESSFULLY EXPANDED");
        store = Arrays.copyOf(store, store.length + 1);
    }
}

