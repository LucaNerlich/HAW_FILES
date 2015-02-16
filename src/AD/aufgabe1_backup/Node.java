package AD.aufgabe1_backup;

/**
 * Created by Luca on 23.09.2014.
 */
public class Node<T> {

    private T data;
    private Node<T> nextNode = null;


    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
