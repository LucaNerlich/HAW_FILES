package AD.aufgabe7;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 7
 * Sortable.java
 */

/**
 * This class represents our Interface,
 * classes which are implementing this Interface, are able to sort elements
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public interface Sortable<T> {

    public int getKey();

    public void setKey(int i);
}
