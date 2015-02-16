package Uebungen.Kleinkram.Dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 12.02.15
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class Graph {

    private List<Node> nodes = new ArrayList<>();
    private List<Vertice> vertices = new ArrayList<>();

    private int countNodes = 0;

    public void addNode(Node node) {
        nodes.add(node);
        countNodes++;
    }

    public void createVertice(Node startNode, Node endNode, int value) {
        Vertice vertice = new Vertice(startNode, endNode, value);
        vertices.add(vertice);
        startNode.addVertice(vertice);
        endNode.addVertice(vertice);

        //andereRichtung
        Vertice vertice2 = new Vertice(endNode, startNode, value);
        vertices.add(vertice2);
        startNode.addVertice(vertice2);
        endNode.addVertice(vertice2);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public int getCountNodes() {
        return countNodes;
    }
}
