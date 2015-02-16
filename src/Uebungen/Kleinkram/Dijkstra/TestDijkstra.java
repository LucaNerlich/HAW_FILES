package Uebungen.Kleinkram.Dijkstra;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by lnerlich on 16.02.2015.
 */
public class TestDijkstra {

    @Test
    public void test(){

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

        assertTrue(dijkstra.findShortestPath(nodeA, nodeE, graph));
        assertTrue(nodeE.getValue() == 9);
    }
}
