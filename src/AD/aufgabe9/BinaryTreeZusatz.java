package AD.aufgabe9;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 9
 * Anwendung.java
 * <p/>
 * Extended Binary Tree for AD09
 * Implements the m <= ai <= M getSequenz Method.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class BinaryTreeZusatz extends BinaryTree implements Sortable {

    private int seqSumme = 0;
    private BinaryNode minNodeFromSeq;
    private BinaryNode maxNodeFromSeq;

    /**
     * BinaryTree in dem jeder Knoten noch Zusatzwerte hat.
     * http://stackoverflow.com/questions/2597301/problem-with-building-tree-bottom-up
     * http://en.wikipedia.org/wiki/Binary_search_tree
     *
     * @param wurzel -> pass the first / root node.
     */
    public BinaryTreeZusatz(BinaryNode wurzel) {
        super(wurzel);
    }

    /**
     * print alls Subtree Values, inOrder order.
     *
     * @param wurzel -> pass the root node of the tree
     */
    public void printAlleZusatzWerte(BinaryNode wurzel) {

        if (wurzel == null) {
            return;
        }
        printAlleZusatzWerte(wurzel.getLeft());

        counterIn++;
        System.out.println(counterIn + ":" + wurzel.getWert());
        System.out.println("Zusatzwert: " + wurzel.getWertDesSubtrees());

        printAlleZusatzWerte(wurzel.getRight());

    }

    /**
     * Fuegt einen neuen Knoten rekursiv in den BST ein. Dabei wird auch fuer jeden Knoten der Wert des kompletten
     * Subtrees mit hinzugefuegt.
     * best case o(logn)
     * worst case o(n)
     * <p/>
     * wir gehen rekursiv bis zum Einfuegen des Knotens. Da wir beim Aufruf immer schon wieder in die Rekursion reinspringen,
     * stauen sich die setInfo aufrufe quasi auf. Sind wir mit setLeft am Ende angekommen, vollenden wir Schrittweise die Aufrufe.
     * Indem wir jetzt Zeile 75 zb durchfuehren.
     *
     * @param current -> repraesentiert den aktuellen Knoten
     * @param newNode -> repraesentiert den neuen Knoten
     * @return -> binary node. not used
     * @throws NodeException
     */
    public BinaryNode addNodeItem(BinaryNode current, BinaryNode newNode) throws NodeException {

        if (current == null) {
            current = newNode;
            current.setWertDesSubtrees(current.getWert());
        } else if ((current.getSchluessel()).compareTo(newNode.getSchluessel()) > 0) { //wenn newNode < current
            current.setLeft(addNodeItem(current.getLeft(), newNode));

            //addiert den Wert des neuen Knotens zum Vaterknoten.
            current.setWertDesSubtrees(current.getWertDesSubtrees() + (int) newNode.getWert());
        } else if ((current.getSchluessel()).compareTo(newNode.getSchluessel()) < 0) { //wenn newNode > current
            current.setRight(addNodeItem(current.getRight(), newNode));

            //addiert den Wert des neuen Knotens zum Vaterknoten.
            current.setWertDesSubtrees(current.getWertDesSubtrees() + (int) newNode.getWert());
        } else {
            throw new NodeException("Duplicate Element " + newNode.getSchluessel());
        }
        return current;
    }

    /**
     * Gibt den Wert der Knoten innerhalb der min-max Grenze addiert wieder.
     * o(n), da wir jeden Knoten genau ein Mal anfassen
     *
     * @param min kleinM - Untergrenze
     * @param max großM - Obergrenze
     * @return summe int, sum of all values from nodes between min - max
     */
    public int getSeq(int min, int max) {

        getSeqHelper(wurzel, min, max);
        int summe = getSeqSumme();
        //reset Sequenzsumme!
        setSeqSumme(0);

        return summe;
    }


    /**
     * Laeuft im InOrder Alogrithmus den BinarySearchTree durch und addiert die entsprechenden Knoten.
     *
     * @param current -> stores the current Node for the recursive access.
     * @param min     -> see getSeq()
     * @param max     -> see getSeq()
     */
    private void getSeqHelper(BinaryNode current, int min, int max) {

        if (current == null) {
            return;
        }
        getSeqHelper(current.getLeft(), min, max);

        if (((int) current.getWert() >= min) & ((int) current.getWert() <= max)) {
            setSeqSumme(getSeqSumme() + (int) current.getWert());
            System.out.println("Current Node Key: " + current.getSchluessel());
            System.out.println("Current Node Wert: " + current.getWert());
            System.out.println("Subtree wert: " + current.getWertDesSubtrees());
            System.out.println("Summe: " + seqSumme);
            System.out.println("");
        }
        getSeqHelper(current.getRight(), min, max);
    }

    /**
     * gibt den Knoten mit dem kleinesten Wert >= min wieder.
     *
     * @param current
     * @param min
     * @return
     */
    public BinaryNode getMinNode(BinaryNode current, int min) throws Exception {
        getMinNodeHelper(current, min);
        if (getMinNodeFromSeq() == null) {
            throw new Exception("Alle Knoten sind kleiner als der angegebene Wert!");
        }
        return getMinNodeFromSeq();
    }

    private void getMinNodeHelper(BinaryNode current, int min) {
        if (current == null) {
            return;
        }
        getMinNodeHelper(current.getLeft(), min);

        setMinNode(current, min);

        getMinNodeHelper(current.getRight(), min);
    }

    /**
     * vergleicht den aktuell gesetzten min Knoten mit dem naechsten
     * @param current
     * @param min
     */
    private void setMinNode(BinaryNode current, int min) {
        if (getMinNodeFromSeq() == null) {
            if ((int) current.getWert() >= min) {
                setMinNodeFromSeq(current);
            }

        } else {
            if ((int) current.getWert() < (int) getMinNodeFromSeq().getWert()) {
                setMinNodeFromSeq(current);
            }
        }
    }

    /**
     * gibt den Knoten mit dem groessten Wert <= max wieder.
     * @param current
     * @param max
     * @return
     */
    public BinaryNode getMaxNode(BinaryNode current, int max) throws Exception {
        getMaxNodeHelper(current, max);

        if (getMaxNodeFromSeq() == null) {
            throw new Exception("Alle Knoten sind groesser als der angegebene Wert!");
        }

        return getMaxNodeFromSeq();
    }

    private void getMaxNodeHelper(BinaryNode current, int max) {
        if (current == null) {
            return;
        }
        getMaxNodeHelper(current.getLeft(), max);

        setMaxNode(current, max);

        getMaxNodeHelper(current.getRight(), max);
    }

    private void setMaxNode(BinaryNode current, int max) {
        if (getMaxNodeFromSeq() == null) {
            if ((int) current.getWert() <= max) {
                setMaxNodeFromSeq(current);
            }
        } else if ((int) current.getWert() > (int) getMaxNodeFromSeq().getWert() & (int) current.getWert() <= max) {
            setMaxNodeFromSeq(current);
        }
    }

    public int getSeqSumme() {
        return seqSumme;
    }

    public void setSeqSumme(int seqSumme) {
        this.seqSumme = seqSumme;
    }

    private BinaryNode getMinNodeFromSeq() {
        return minNodeFromSeq;
    }

    private void setMinNodeFromSeq(BinaryNode minNodeFromSeq) {
        this.minNodeFromSeq = minNodeFromSeq;
    }

    private BinaryNode getMaxNodeFromSeq() {
        return maxNodeFromSeq;
    }

    private void setMaxNodeFromSeq(BinaryNode maxNodeFromSeq) {
        this.maxNodeFromSeq = maxNodeFromSeq;
    }
}
