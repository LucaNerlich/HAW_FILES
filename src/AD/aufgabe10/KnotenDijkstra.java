package AD.aufgabe10;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 10
 * KnotenDijkstra.java
 * Represents our nodes for dijkstra
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */

public class KnotenDijkstra<T> extends Knoten {

    private KnotenDijkstra<T> pred;
    //private double cost;
    private double cost = Double.POSITIVE_INFINITY;
    private boolean marked;

    public KnotenDijkstra(Object element) {
        super(element);
    }

    public KnotenDijkstra<T> getPred() {
        return pred;
    }

    public void setPred(KnotenDijkstra<T> pred) {
        this.pred = pred;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
