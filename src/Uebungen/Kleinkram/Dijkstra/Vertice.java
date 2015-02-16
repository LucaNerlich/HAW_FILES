package Uebungen.Kleinkram.Dijkstra;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 12.02.15
 * Time: 09:56
 * To change this template use File | Settings | File Templates.
 */
public class Vertice {

    private Node start;
    private Node end;
    private int value;

    public Vertice(Node start, Node end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
