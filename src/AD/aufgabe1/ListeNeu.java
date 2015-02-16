package AD.aufgabe1;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * ListeNeu.java
 */

/**
 * This class represents our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class ListeNeu<T> implements Listable<T> {

    private final int STARTPOSITION = 1;
    private Node startNode;
    private int findCountOp = 0;
    private int insertCountOp = 0;
    private int deleteCountOp = 0;
    private int retrieveCountOp = 0;
    boolean getCountAsLinear = false;
    private int itemCounter = 1;

    public ListeNeu() {
        startNode = null;
    }

    public ListeNeu(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * Helpermethod which checks recursivly if the current node hast the same element as passed.
     * int gets autoboxed
     * Complexity: O(n)
     *
     * @param element -> Object T, can be anything. Each node contains one.
     * @param current -> Saves the current Node for the recursive call
     * @param counter -> represents the index of each node.
     * @return -> the position of the node which hosts the passed element
     */
    private Integer findHelper(T element, Node<T> current, int counter) {
        if (current.getData().equals(element)) {
            findCountOp += 2;
            return counter;
        } else {
            findCountOp += 1;
            if (current.getNextNode() != null) {
                current = current.getNextNode();
                counter += 1;
                findCountOp += 4;
                return findHelper(element, current, counter);
            }
            //returns null, if the element does not exits.
            else {
                System.out.println("NO ELEMENT(" + element.toString() + ") FOUND");
                findCountOp += 2;
                return null;
            }
        }
    }

    /**
     * This method allows us to search for nodes (using findHelper)
     * Complexity: O(n)
     *
     * @param element Object T, can be anything. Each node contains one.
     * @return the element we are looking for or null if not found
     */
    @Override
    public Integer find(T element) {
        if (getCountAsLinear == true) {
            findCountOp = 0;
        }
        findCountOp += 1;
        return findHelper(element, startNode, STARTPOSITION);
    }

    /**
     * Returns the element of the Node at the given position.
     * Complexity: O(n)
     *
     * @param position -> position of the node from whom you want to get the element.
     * @return -> element (can be any object)
     */
    @Override
    public Object retrieve(int position) {

        if (getCountAsLinear == true) {
            retrieveCountOp = 0;
        }

        if (position <= 0) {
            System.err.println("Error: Es gibt keinen Knoten an der Position < 1");
            retrieveCountOp++;
            return null;
        }
        if (position == 1) {
            retrieveCountOp += 3;
            if (startNode == null) {
                return null;
            }
            return startNode.getData();
        } else {
            Node current = startNode;
            retrieveCountOp += 5;
            for (int i = 1; i < position; i++) {
                if ((current.getNextNode() == null) && (position != i)) {
                    System.err.println("Hier: '" + position + "' befindet sich kein Knoten!");
                    retrieveCountOp += 3;
                    return null;
                } else {
                    retrieveCountOp++;
                    current = current.getNextNode();
                }
            }
            retrieveCountOp += 2;
            return current.getData();
        }
    }

    /**
     * Inserts a new Node at the given Position
     * Complexity: O(n)
     *
     * @param position -> Index where you want to insert a new node
     * @param element  -> The element which the new Node should contain
     */
    @Override
    public void insert(int position, T element) {

        if (getCountAsLinear) {
            insertCountOp = 0;
        }

        Node newNode = new Node(element);
        Node currentNode = startNode;
        insertCountOp += 2;

        if (position <= 0) {
            System.err.println("cant insert here");
        }
        // fuege Element in leere Liste ein
        else if (position == 1 & retrieve(1) == null) {
            startNode = newNode;
        }

        //haenge vors erste Element:
        else if (position == 1) {
            Node<T> chacheStartNode = startNode;
            startNode = newNode;
            newNode.setNextNode(chacheStartNode);
            insertCountOp += 4;
        } else if (itemCounter + 1 < position || position < 1) { //Falls nicht das Ende der Liste gewählt wurde "invalid"
            System.out.println("Insert '" + position + "' invalid!");
        } else {
            for (int i = 1; i < position - 1 && currentNode.getNextNode() != null; i++) { //Einfuegen abhaengig der Position, ohne Luecken
                currentNode = currentNode.getNextNode();
                insertCountOp += 5;
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
            itemCounter++;
            insertCountOp += 2;
        }
    }

    /**
     * Deletes the Node at the given position / index.
     * Complexity: O(n)
     *
     * @param position -> int position of a node
     */
    @Override
    public void delete(int position) {

        if (getCountAsLinear == true) {
            deleteCountOp = 0;
        }

        if (position <= 0) {
            System.err.println("Here is no Node!");
            deleteCountOp += 2;
        }
        if (position == STARTPOSITION) {
            if (startNode.getNextNode() == null) {
                System.out.println("Node at '" + position + "' successfull deleted!");
                itemCounter--;
            }
            startNode = startNode.getNextNode();
            deleteCountOp += 2;
        } else {
            Node<T> current = startNode;
            Node<T> cache = startNode;
            deleteCountOp += 2;
            for (int i = 1; i < position; i++) {
                if (current == null) {
                    System.err.println("There is nothing to delete here!");
                    deleteCountOp += 3;
                } else {
                    if (current.getNextNode() == null) {
                        System.err.println("There is nothing to delete here!");
                        deleteCountOp += 2;
                    }
                    cache = current;
                    current = current.getNextNode();
                    deleteCountOp += 2;
                }
            }
            //Nachfolger auf uebernaechsten setzten und damit den gesuchten loeschen.
            //cache entspricht 1 vor dem zu loeschenden, current ist der zu loeschende
            if (current == null) {
                System.err.println("There is nothing to delete here!");
                deleteCountOp += 2;
            } else if (current.getNextNode() == null) {
                System.out.println("Node at '" + position + "' successfull deleted!");
                cache.setNextNode(null);
                deleteCountOp += 3;
                itemCounter--;
            } else {
                System.out.println("Node at '" + position + "' successfull deleted!");
                //der zu loeschende wird uebersprungen:
                cache.setNextNode(current.getNextNode());
                deleteCountOp += 2;
                itemCounter--;
            }
        }
    }

    /**
     * Attaches a given list to the one which calls the method
     * Complexity: O(n)
     *
     * @param secondList -> ListeNeu : List you would like to add to another
     * @return -> returns a new list, which contains the first and passed one.
     */
    @Override
    public ListeNeu concat(ListeNeu secondList) {
        ListeNeu combinedList = new ListeNeu(this.getStartNode());

        //Platzhalter fuer aktuellen Knoten
        Node<T> currentNode = combinedList.getStartNode();

        //Gehe zum Ende der ersten Liste
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(secondList.getStartNode()); //letzer Knoten in erster Liste bekommt ersten Knoten in zweiter Liste als Nachfolger
        return combinedList;
        //generiert im Moment 2 gleiche Listen. Die neue, haengt die Elemente aber auch an die alte!
    }

    public Node getStartNode() {
        return startNode;
    }

    public void getFindCountOp() {
        System.out.println("Find-Counter ist: " + findCountOp);
    }

    public void getInsertCountOp() {
        System.out.println("Insert-Counter ist: " + insertCountOp);
    }

    public void getDeleteCountOp() {
        System.out.println("Delete-Counter ist: " + deleteCountOp);
    }

    public void getRetrieveCountOp() {
        System.out.println("Retrieve-Counter ist: " + retrieveCountOp);
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }
}
