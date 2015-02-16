package Uebungen.Kleinkram.Dijkstra;

import java.util.List;

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

        /*

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
        */

        generateGraph(100, 100, graph);
        Node nodeA = graph.getNodes().get(1);
        Node nodeB = graph.getNodes().get(5);

        dijkstra.findShortestPath(nodeA, nodeB, graph);



    }

    public static void generateGraph(int anzahlKnoten, int anzahlKanten, Graph graph) {
        for (int i = 0; i < anzahlKnoten; i++) {
            Node A = new Node("Node_" + i);
            graph.addNode(A);
        }

        for (int j = 0; j < anzahlKanten; j++) {
            setzeKante(graph, j);
        }
    }

    protected static void setzeKante(Graph graph, int gewichtx) {
        int indexNodeA = (int) (Math.random() * (graph.getCountNodes()));
        int indexNodeB = (int) (Math.random() * (graph.getCountNodes()));

        int gewicht = (int) (Math.random() * 100);

        List<Node> node = graph.getNodes();
        Node nodeA = node.get(indexNodeA);
        Node nodeB = node.get(indexNodeB);

        graph.createVertice(nodeA, nodeB, gewichtx);
    }
}
