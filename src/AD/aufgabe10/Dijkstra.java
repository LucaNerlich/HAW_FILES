package AD.aufgabe10;

import java.util.ArrayList;
import java.util.List;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 10
 * Dijkstra.java
 * Implements the Dijkstra Algorithm.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Dijkstra {

    /**
     * Algorithmus analog zu Script Seite 110, findet die 'schnellste' Verbindung zwischen Start- und Zielknoten.
     *
     * @param startKnoten KnotenDijkstra, Startknoten
     * @param zielKnoten  KnotenDijkstra, Zielknoten
     * @param graph       IGraph, Knoten befinden sich in diesem Graphen.
     */
    private boolean printPfad = true;

    public boolean findPath(KnotenDijkstra startKnoten, KnotenDijkstra zielKnoten, IGraph graph) {
        boolean pfadExistiert = false;
        KnotenDijkstra startCache = startKnoten;

        //Initialisierung
        dijkstraSetup(startKnoten, graph);

        List listeNachbarn = graph.getNachbarn(startKnoten);
        for (int i = 0; i < listeNachbarn.size(); i++) {
            KnotenDijkstra setPredCache = (KnotenDijkstra) listeNachbarn.get(i);
            setPredCache.setPred(startKnoten);
        }

        //Laeuft bis es keine markierten Knoten mehr gibt, wir also alle moeglichen einmal angeguckt haben.
        while (listeNachbarn.size() != 0) {

            KnotenDijkstra lowestCostKnoten = getLowestCost(startCache, listeNachbarn, graph);
            listeNachbarn.remove(lowestCostKnoten);
            lowestCostKnoten.setMarked(true);

            // ## Rand ergaenzen: ##
            List listeNachbarnCache = graph.getNachbarn(lowestCostKnoten);

            //kick alle die markiert sind:
            for (int i = 0; i < listeNachbarnCache.size(); i++) {
                if (((KnotenDijkstra) listeNachbarnCache.get(i)).isMarked()) {
                    listeNachbarnCache.remove(listeNachbarnCache.get(i));
                    i--;
                }
            }

            //Check alle Nachbarn und vergleich mit den vorherigen. Setzt Kosten neu, wenn es jetzt kuerzere Wege gibt.
            checkNachbarnSetCosts(lowestCostKnoten, listeNachbarn, listeNachbarnCache, graph);

            //Listen zusammenfuehren:
            mergeListen(listeNachbarn, listeNachbarnCache);

            // Setz naechste 'startknoten' fuer den Algorithmus.
            startCache = lowestCostKnoten;
        }

        //Check ob der Zielknoten markiert wurde, wenn ja, existiert ein Weg.
        if (zielKnoten.isMarked()) {
            pfadExistiert = true;
        }

        if (printPfad == true & pfadExistiert == true) {
            printAllPaths(graph);
        }
        return pfadExistiert;
    }

    /**
     * Check alle Nachbarn und vergleich mit den vorherigen. Setzt Kosten neu, wenn es jetzt kuerzere Wege gibt.
     *
     * @param lowestCostKnoten
     * @param listeNachbarn
     * @param listeNachbarnCache
     * @param graph
     */
    private void checkNachbarnSetCosts(KnotenDijkstra lowestCostKnoten, List listeNachbarn, List listeNachbarnCache, IGraph graph) {

        // Fuer alle Nachbarn vom billigsten Knoten finden und setzten wir die Kantenkosten
        for (int i = 0; i < listeNachbarnCache.size(); i++) {
            double cost = graph.getKantenGewicht(lowestCostKnoten, (KnotenDijkstra) listeNachbarnCache.get(i));

            if (((KnotenDijkstra) listeNachbarnCache.get(i)).getCost() == 0) {
                ((KnotenDijkstra) listeNachbarnCache.get(i)).setCost(lowestCostKnoten.getCost() + (cost));
                ((KnotenDijkstra) listeNachbarnCache.get(i)).setPred(lowestCostKnoten);
            }
            KnotenDijkstra current = (KnotenDijkstra) listeNachbarnCache.get(i);

            //wir vergleichen nur Knoten die vorher schon eine Verbindung hatten.
            for (int j = 0; j < listeNachbarn.size(); j++) {
                if (listeNachbarn.get(j).equals(listeNachbarnCache.get(i))) {
                    //wenn es eine Verbindung vom Vorgaenger zum naechsten gibt:
                    if (cost + lowestCostKnoten.getCost() < current.getCost()) {
                        // wenn die Kosten ueber den Mittelknoten kleiner sind, setzen wir nie Kosten neu
                        ((KnotenDijkstra) listeNachbarnCache.get(i)).setCost(cost + lowestCostKnoten.getCost());
                        ((KnotenDijkstra) listeNachbarnCache.get(i)).setPred(lowestCostKnoten);
                    }
                }
            }
        }
    }

    /**
     * Gibt alle Knoten und deren Vorgäger aus.
     * Hier laesst sich der Weg vom angegeben Startknoten zum Zielknoten ablesen.
     *
     * @param graph -> hier wird der Weg vom Startknoten zum Zielknoten gesucht.
     */
    private void printAllPaths(IGraph graph) {
        //hier alle marked checken
        List<KnotenDijkstra> markierteKnoten = new ArrayList<KnotenDijkstra>();
        for (int a = 0; a < graph.getAnzahlKnoten(); a++) {
            KnotenDijkstra knoten = (KnotenDijkstra) graph.getKnoten(a);
            if (knoten.isMarked()) {
                markierteKnoten.add(knoten);
            }
        }

        for (int b = 0; b < markierteKnoten.size(); b++) {

                System.out.println("Knoten: " + markierteKnoten.get(b));
                System.out.println("Cost : " + markierteKnoten.get(b).getCost());
                System.out.println("Sein Vorgaenger: " + markierteKnoten.get(b).getPred());
            if (markierteKnoten.get(b).getPred() != null) {
                System.out.println("Cost: " + markierteKnoten.get(b).getPred().getCost());
            }
                System.out.println("");


        }
    }

    /**
     * Fuegt verbleibende Knoten der alten Liste hinzu.
     *
     * @param old
     * @param addToOld
     */
    private void mergeListen(List old, List addToOld) {
        for (int x = 0; x < addToOld.size(); x++) {
            KnotenDijkstra currentNew = (KnotenDijkstra) addToOld.get(x);
            boolean isInList = false;

            for (int y = 0; y < old.size(); y++) {
                KnotenDijkstra currentOld = (KnotenDijkstra) old.get(y);
                if (currentNew.equals(currentOld)) {
                    isInList = true;
                }
            }
            if (!isInList) {
                old.add(currentNew);
            }
        }
    }

    /**
     * Initialisierungalle Knoten außer Startknoten:
     * k.pred = undefniert;
     * k.cost = 1;
     * k.marked = false;
     * Der Startknoten o:
     * o.pred = ;
     * o.cost = 0;
     * o.marked = true;
     *
     * @param startKnoten
     * @param graph
     */
    private void dijkstraSetup(KnotenDijkstra startKnoten, IGraph graph) {
        for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
            KnotenDijkstra knoten = (KnotenDijkstra) graph.getKnoten(i);
            if (knoten != startKnoten) {
                knoten.setPred(null);
                //knoten.setCost(0);
                knoten.setMarked(false);
            } else { //also der Startknoten
                knoten.setPred(knoten);
                knoten.setCost(0);
                knoten.setMarked(true);
            }
        }
    }

    /**
     * Sucht den Nachbarknoten, der mit den geringsten Kosten zu erreichen ist.
     * Setzt außerdem die Kantenkosten im Knoten B.
     *
     * @param startknoten
     * @param listeNachbarn
     * @param graph
     * @return
     */
    private KnotenDijkstra getLowestCost(KnotenDijkstra startknoten, List listeNachbarn, IGraph graph) {
        // https://www-m9.ma.tum.de/material/de/spp-dijkstra/
        // kosten a - i = costen vom startknoten + (kante von startknoten bis i)
        // setze diese kosten bei i
        // speichere zwischen, waehle billigsten
        // ## THIRD TRY ##

        KnotenDijkstra currentLowestCost = null;
        double costCurrent; //vom startknoten bis current
        List nurNachbarn = graph.getNachbarn(startknoten);

        //set Kosten:
        for (int i = 0; i < listeNachbarn.size(); i++) {
            KnotenDijkstra current = (KnotenDijkstra) listeNachbarn.get(i);
            costCurrent = graph.getKantenGewicht(startknoten, current) + startknoten.getCost();

            if (!Double.isInfinite(current.getCost())) {
                costCurrent += current.getCost();
            }

            //wenn wir den Knoten zum Ersten mal angucken, setzten wir den Wert der Kante.
            if (Double.isInfinite(current.getCost())) {
                ((KnotenDijkstra) listeNachbarn.get(i)).setCost(costCurrent + startknoten.getCost());
            }if(Double.isInfinite(costCurrent)){
                                             //do nothing
            }
            else if (costCurrent < current.getCost()) {
                ((KnotenDijkstra) listeNachbarn.get(i)).setCost(costCurrent);
            } else {
                // do nothing
            }
        }

        //get lowestKosten:

        for (int i = 0; i < listeNachbarn.size(); i++) {
            KnotenDijkstra currentLow = (KnotenDijkstra) listeNachbarn.get(i);

            if (currentLowestCost == null) {
                currentLowestCost = currentLow;
            } else if (currentLowestCost.getCost() > currentLow.getCost()) {
                currentLowestCost = (KnotenDijkstra) listeNachbarn.get(i);
            }
        }

        return currentLowestCost;
    }

    private double getMinDist(KnotenDijkstra node) {
        double cost = node.getCost();
        if (cost == Double.POSITIVE_INFINITY) {
            return Double.MAX_VALUE;
        } else {
            return cost;
        }
    }
}
