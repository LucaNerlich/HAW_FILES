package AD.aufgabe9;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 9
 * Sortable.java
 */

/**
 * This class represents our Interface,
 * classes which are implementing this Interface, are able to sort elements
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public interface Sortable<T extends Comparable<T>, U> {

    /**
     * Hauptmethode des Baums. Bekommt einen neuen Knoten und platziert diesen
     * entsprechend. Geht rekursiv den vorhandenen Baum durch, um den besten
     * Platz zu finden.
     *
     * @param neu     -> repraesentiert den neuen Knoten
     * @param current -> repraesentiert den aktuellen Knoten
     * @throws NodeException -> Kann eine NodeException werfen wenn ein Knoten bereits mit
     *                       demselben Schluessel vorhanden ist
     */
    public BinaryNode<T, U> addNodeItem(BinaryNode<T, U> current, BinaryNode<T, U> neu) throws NodeException;

    /**
     * Ausgabe fuer die Hauptreihenfolge
     *
     * @param wurzel
     */
    public void printPreOrder(BinaryNode<T, U> wurzel);

    /**
     * Ausgabe fuer die Nebenreihenfolge
     *
     * @param wurzel
     */
    public void printPostOrder(BinaryNode<T, U> wurzel);

    /**
     * Symmetrische Ausgabe
     *
     * @param wurzel
     */
    public void printInOrder(BinaryNode<T, U> wurzel);
}
