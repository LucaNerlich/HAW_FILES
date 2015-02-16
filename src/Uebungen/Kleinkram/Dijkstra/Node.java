package Uebungen.Kleinkram.Dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 12.02.15
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class Node {

    private String name;
    private double value = Double.POSITIVE_INFINITY;
    private List<Vertice> vertices = new ArrayList<>();
    private boolean marked = false;

    //haelt Vorgaenger fuer kuerzesten Weg
    private Node predecessor = null;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }
}
