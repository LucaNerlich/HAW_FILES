package Uebungen.Kleinkram.Dijkstra;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 12.02.15
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        Dijkstra dijkstra = new Dijkstra();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.createVertice(nodeA, nodeE, 20);
        graph.createVertice(nodeA, nodeB, 2);
        graph.createVertice(nodeB, nodeC, 3);
        graph.createVertice(nodeB, nodeD, 4);
        graph.createVertice(nodeC, nodeF, 7);
        graph.createVertice(nodeD, nodeE, 3);
        graph.createVertice(nodeD, nodeF, 5);
        graph.createVertice(nodeE, nodeF, 1);

        dijkstra.findShortestPath(nodeA, nodeF, graph);
    }
}
