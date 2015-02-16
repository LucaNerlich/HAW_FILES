package AD.aufgabe9;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 9
 * Anwendung.java
 *
 * Binary Node class. Represents a Node. Each node has a Key, Value and stores the current subtree value.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class BinaryNode<T extends Comparable<T>, U> {

    private T schluessel;
    private U wert;
    private int wertDesSubtrees;
    private BinaryNode<T, U> left;
    private BinaryNode<T, U> right;

    /**
     * Konstruktor des Knoten. Kriegt einen Schluessel und einen Wert. Mit
     * diesem wird er im Baum repraesentiert.
     */
    public BinaryNode(T schluessel, U wert) {
        this.schluessel = schluessel;
        this.wert = wert;
        setWertDesSubtrees(wert);
    }

    /**
     * Getter und Setter
     */
    public BinaryNode<T, U> getLeft() {
        return left;
    }

    public BinaryNode<T, U> getRight() {
        return right;
    }

    public void setLeft(BinaryNode<T, U> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T, U> right) {
        this.right = right;
    }

    public T getSchluessel() {
        return schluessel;
    }

    public void setSchluessel(T schluessel) {
        this.schluessel = schluessel;
    }

    public U getWert() {
        return wert;
    }

    public void setWert(U wert) {
        this.wert = wert;
    }

    public int getWertDesSubtrees() {
        return wertDesSubtrees;
    }

    public void setWertDesSubtrees(Object wertDesSubtrees) {
        this.wertDesSubtrees = (int) wertDesSubtrees;
    }

    /**
     * Gibt den Wert und den Schluessel des Knoten aus.
     */
    @Override
    public String toString() {
        return "BinaryNode [schluessel=" + schluessel + ", wert=" + wert + "]";
    }

}
