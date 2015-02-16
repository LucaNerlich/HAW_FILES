package AD.aufgabe8;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 8
 * BinaryTree.java
 *
 * http://nn-tech-blog.blogspot.de/2009/03/binary-search-tree-implementation-in.html
 * http://www.straub.as/c-cpp-qt-fltk/c/binary-trees.html
 * http://www.vias.org/javacourse/chap17_09.html
 * http://codereview.stackexchange.com/questions/32270/generic-binary-search-tree-implementation
 *
 * Dies ist die Hauptklasse des Binaerbaums *
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class BinaryTree<T extends Comparable<T>, U> implements Sortable {

    private BinaryNode<T, U> wurzel;
    int counterPre = 0;
    int counterPost = 0;
    int counterIn = 0;

    /**
     * Konstruktor des Baums. Bekommt den Comparator uebergeben, nachdem die
     * Inhalte sortiert / angelegt werden sollen.
     */
    public BinaryTree(BinaryNode<T, U> wurzel) {
        this.wurzel = wurzel;
    }

    /**
     * Getter und Setter
     */
    public BinaryNode<T, U> getWurzel() {
        return wurzel;
    }

    /**
     * Hauptmethode des Baums. Bekommt einen neuen Knoten und platziert diesen
     * entsprechend. Geht rekursiv den vorhandenen Baum durch, um den besten
     * Platz zu finden.
     *
     * @param newNode -> repraesentiert den neuen Knoten
     * @param current -> repraesentiert den aktuellen Knoten
     * @throws NodeException -> Kann eine NodeException werfen wenn ein Knoten bereits mit
     *                       demselben Schluessel vorhanden ist
     */
    @Override
    public BinaryNode addNodeItem(BinaryNode current, BinaryNode newNode)
            throws NodeException {

        if (current == null) {
            current = newNode;

        } else if ((current.getSchluessel()).compareTo(newNode.getSchluessel()) < 0) {
            current.setRight(addNodeItem(current.getRight(), newNode));

        } else if ((current.getSchluessel()).compareTo(newNode.getSchluessel()) > 0) {
            current.setLeft(addNodeItem(current.getLeft(), newNode));

        } else {
            throw
                    new NodeException("Duplicate Element " + newNode.getSchluessel());
        }
        return current;
    }

  
    @Override
    public void printPreOrder(BinaryNode wurzel) {

        if (wurzel == null) {
            return;
        }
        counterPre++;
        System.out.println(counterPre + ":" + wurzel.getWert());

        printPreOrder(wurzel.getLeft());
        printPreOrder(wurzel.getRight());
    }

    @Override
    public void printPostOrder(BinaryNode wurzel) {

        if (wurzel == null) {
            return;
        }
        printPostOrder(wurzel.getLeft());
        printPostOrder(wurzel.getRight());

        counterPost++;
        System.out.println(counterPost + ":" + wurzel.getWert());
    }

    @Override
    public void printInOrder(BinaryNode wurzel) {

        if (wurzel == null) {
            return;
        }
        printInOrder(wurzel.getLeft());

        counterIn++;
        System.out.println(counterIn + ":" + wurzel.getWert());

        printInOrder(wurzel.getRight());
    }
}
