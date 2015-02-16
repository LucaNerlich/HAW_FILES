package Uebungen.Kleinkram.Dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 12.02.15
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public class Dijkstra {
    boolean found = false;

    /**
     * Finds the shortest path from start to goal in a given graph.
     *
     * @param start
     * @param goal
     * @param graph
     * @return
     */
    public boolean findShortestPath(Node start, Node goal, Graph graph) {
        Node startNode = start;

        //initialize Startnode
        startNode.setValue(0);
        startNode.setPredecessor(startNode);

        List<Node> neighborNodes = new ArrayList<>();

        refreshNeighborNodes(neighborNodes, graph, startNode);

        while (!neighborNodes.isEmpty()) {
            Node cheapestNode = getLowestCostNode(neighborNodes);
            cheapestNode.setMarked(true);
            neighborNodes.remove(cheapestNode);

            addNewNeighbors(neighborNodes, graph, cheapestNode);
        }

        printPath(goal, graph);

        System.out.println("Path found? " + found);
        return found;
    }

    /**
     * Creates the inital list. Adds every Node adjacent to the startnode.
     * @param list
     * @param graph
     * @param startNode
     */
    private void refreshNeighborNodes(List list, Graph graph, Node startNode) {
        for (Vertice vertice : startNode.getVertices()) {
            if (vertice.getEnd() != startNode) {
                list.add(vertice.getEnd());
                Node endNode = vertice.getEnd();

                //check cost
                double chacheValue = endNode.getValue() + startNode.getValue();
                if (endNode.getValue() == Double.POSITIVE_INFINITY || (endNode.getValue() > chacheValue)) {
                    endNode.setValue(vertice.getValue() + startNode.getValue());
                    endNode.setPredecessor(startNode);
                }
            }
        }

        startNode.setMarked(true);
    }

    /**
     * Returns the Node with the lowest cost.
     * @param list
     * @return
     */
    private Node getLowestCostNode(List<Node> list) {
        Node cheapestNode = list.get(0);

        for (Node currentNode : list) {
            if (currentNode.getValue() < cheapestNode.getValue()) {
                cheapestNode = currentNode;
            }
        }

        return cheapestNode;
    }

    /**
     * Adds the adjacents Nodes to the list, checks their costs and edits them if needed.
     * @param list
     * @param graph
     * @param startNode
     */
    private void addNewNeighbors(List<Node> list, Graph graph, Node startNode) {

        for (Vertice vertice : startNode.getVertices()) {

            Node currentNode = vertice.getEnd();
            if (!currentNode.isMarked()) {
                if (currentNode != startNode) {
                    if (currentNode.getValue() == Double.POSITIVE_INFINITY || (currentNode.getValue() > startNode.getValue() + vertice.getValue())) {
                        currentNode.setValue(vertice.getValue() + startNode.getValue());
                        if (currentNode != startNode) {
                            currentNode.setPredecessor(vertice.getStart());
                        }
                    }
                    list.add(currentNode);
                }
            }
        }
    }

    /**
     * Prints all Nodes with their respective value and predecessor to the console.
     * @param ziel
     * @param graph
     */
    private void printPath(Node ziel, Graph graph) {
        for (Node node : graph.getNodes()) {
            if(node.getPredecessor() != null) {
                System.out.println(node.getName() + " Value: " + node.getValue());
                System.out.println("PRED: " + node.getPredecessor().getName());
                System.out.println();
            }
        }
        if (ziel.getValue() != Double.POSITIVE_INFINITY) {
            found = true;
        }
    }
}
