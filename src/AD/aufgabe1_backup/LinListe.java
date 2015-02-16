package AD.aufgabe1_backup;

/**
 * Created by Luca on 23.09.2014.
 */
public class LinListe<T> {

    private final int STARTPOSITION = 1;
    private AD.aufgabe1.Node startNode;

    public LinListe(AD.aufgabe1.Node startNode) {
        this.startNode = startNode;
    }

    /**
     * inserts node at the given position. Sets the original node, as the new successor
     * and sets itself as the successor of the previous one.
     *
     * @param position -> int value, where you want to place your node
     * @param node     -> node you want to insert into the list.
     */
    public void insert(int position, AD.aufgabe1.Node<T> node) {
        //TODO wenn position groesser als letzter node, wirds einfach ans ende gehaengt
        AD.aufgabe1.Node current = startNode;

        if (position <= 0) {
            System.out.println("cant insert here");
        } else {
            for (int i = 1; i < position; i++) {
                //&& (position != i)
                /*if ((current.getNextNode() == null) ) {
                    System.out.println("cant insert here");
                } else {
                    current = current.getNextNode();
                } */

                if (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
            }
            node.setNextNode(current.getNextNode());
            current.setNextNode(node);
        }
    }

    public void delete(int position /* -> n */) {
        if (position == STARTPOSITION) {
            startNode = startNode.getNextNode();
        } else {
            //n-1
            AD.aufgabe1.Node child = retrieve(position - 1);
            child.setNextNode(retrieve(position).getNextNode());
        }
    }

    public AD.aufgabe1.Node<T> retrieve(int position) {
        if (position <= 0) {
            return null;
        }
        if (position == 1) {
            return startNode;
        }

        //else{
        //    return retrieveHelper(startNode, position, STARTPOSITION);
        //}

        else {
            AD.aufgabe1.Node<T> current = startNode;
            for (int i = 1; i < position; i++) {
                if ((current.getNextNode() == null) && (position != i)) {
                    return null;
                } else {
                    current = current.getNextNode();
                }
            }
            return current;
        }
    }

    /*
    public LinListe concat(LinListe liste1, LinListe liste2) {
        LinListe newListe;

        return newListe;
    }
*/

    /**
     * Passes the startnode to findhelper
     *
     * @param node
     * @return
     */
    public int find(AD.aufgabe1.Node<T> node) {
        return findHelper(node, startNode, STARTPOSITION);
    }

    /**
     * @param node    -> pass the Node which position you want to find out!
     * @param current
     * @param counter
     * @return
     */
    private int findHelper(AD.aufgabe1.Node<T> node, AD.aufgabe1.Node<T> current, int counter) {

        /* recursive check if the 'current' node is the same as the passed node. */
        if (current == node) {
            return counter;
        } else {
            current = current.getNextNode();
            counter += 1;
            return findHelper(node, current, counter);
        }
    }

    /**
     * @param currentNode
     * @param position
     * @param currentPos
     * @return private Node<T> retrieveHelper(Node<T> currentNode, int position, int currentPos) {
    Node<T> node;
    if (position == STARTPOSITION) {
    node = startNode;
    } else if (position == currentPos) {
    node = currentNode;
    } else {
    currentPos = +1;
    node = currentNode.getNextNode();
    return retrieveHelper(node, position, currentPos);
    }
    return node;
    }*/
}
