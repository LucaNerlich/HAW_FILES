package AD.aufgabe10;/**
 * Created by Luca on 23.11.2014.
 */

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * mainNeu.java
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */

public class AnwendungDijkstraBackUp extends Anwendung {
    public static void main(String[] args) {

        IGraph<String> graph = getInstance();

        /*
        generateGraph(100, 250, graph);

        System.out.println("Anzahl Knoten: " + graph.getAnzahlKnoten());
        System.out.println("Anzahl Kanten: " + graph.getAnzahlKanten());

        dijkstra((KnotenDijkstra) graph.getKnoten(1), (KnotenDijkstra) graph.getKnoten(5), graph);
        //knotenKante(graph);
        //printNachbarnAll(graph);
        System.out.println("ENDE");
        */

        KnotenDijkstra<String> A = new KnotenDijkstra<String>("A");
        graph.addKnoten(A);

        KnotenDijkstra<String> B = new KnotenDijkstra<String>("B");
        graph.addKnoten(B);

        KnotenDijkstra<String> C = new KnotenDijkstra<String>("C");
        graph.addKnoten(C);

        KnotenDijkstra<String> D = new KnotenDijkstra<String>("D");
        graph.addKnoten(D);

        KnotenDijkstra<String> E = new KnotenDijkstra<String>("E");
        graph.addKnoten(E);

        KnotenDijkstra<String> F = new KnotenDijkstra<String>("F");
        graph.addKnoten(F);

        KnotenDijkstra<String> G = new KnotenDijkstra<String>("G");
        graph.addKnoten(G);


        double gewichtAB = 4.0;
        graph.addKante(A, B, gewichtAB);

        double gewichtAG = 5.0;
        graph.addKante(A, G, gewichtAG);

        double gewichtAF = 10.0;
        graph.addKante(A, F, gewichtAF);

        double gewichtBG = 2.0;
        graph.addKante(B, G, gewichtBG);

        double gewichtBC = 7.0;
        graph.addKante(B, C, gewichtBC);

        double gewichtCG = 1.0;
        graph.addKante(C, G, gewichtCG);

        double gewichtCD = 12.0;
        graph.addKante(C, D, gewichtCD);

        double gewichtDE = 4.0;
        graph.addKante(D, E, gewichtDE);

        double gewichtEF = 3.0;
        graph.addKante(E, F, gewichtEF);

        double gewichtFG = 4.0;
        graph.addKante(F, G, gewichtFG);

        double gewichtEG = 8.0;
        graph.addKante(E, G, gewichtEG);

        long startTime;
        long endTime;
        long totalTime;
        startTime = 0 + System.currentTimeMillis(); //returns Nanoseconds

        dijkstra(A, D, graph);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Totaltime Dijkstra: " + totalTime);
    }


    /**
     * Algorithmus analog zu Script Seite 110, findet die 'schnellste' Verbindung zwischen Start- und Zielknoten.
     *
     * @param startKnoten KnotenDijkstra, Startknoten
     * @param zielKnoten  KnotenDijkstra, Zielknoten
     * @param graph       IGraph, Knoten befinden sich in diesem Graphen.
     */
    private static boolean dijkstra(KnotenDijkstra startKnoten, KnotenDijkstra zielKnoten, IGraph graph) {
        boolean pfadExistiert = false;
        KnotenDijkstra startCache = startKnoten;

        //Initialisierung
        dijkstraSetup(startKnoten, zielKnoten, graph);

        List listeNachbarn = graph.getNachbarn(startKnoten);
        for (int i = 0; i < listeNachbarn.size(); i++) {
            KnotenDijkstra setPredCache = (KnotenDijkstra) listeNachbarn.get(i);
            setPredCache.setPred(startKnoten);
        }

        while (listeNachbarn.size() != 0) {

            //finde den billigsten Nachbarn und entferne ihn aus der Liste
            KnotenDijkstra lowestCostKnoten = getLowestCost(startCache, listeNachbarn, graph);
            listeNachbarn.remove(lowestCostKnoten);
            lowestCostKnoten.setMarked(true);

            // ##Rand ergaenzen: ##

            List listeNachbarnCache = graph.getNachbarn(lowestCostKnoten);

            //kick alle die markiert sind:
            for (int i = 0; i < listeNachbarnCache.size(); i++) {
                if (((KnotenDijkstra) listeNachbarnCache.get(i)).isMarked()) {
                    listeNachbarnCache.remove(listeNachbarnCache.get(i));
                    i--;
                }
            }

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
            //Listen zusammenfuehren:

            mergeListen(listeNachbarn, listeNachbarnCache);
            /*
            for (int x = 0; x < listeNachbarnCache.size(); x++) {
                KnotenDijkstra currentNew = (KnotenDijkstra) listeNachbarnCache.get(x);
                boolean isInList = false;

                for (int y = 0; y < listeNachbarn.size(); y++) {
                    KnotenDijkstra currentOld = (KnotenDijkstra) listeNachbarn.get(y);
                    if (currentNew.equals(currentOld)) {
                        isInList = true;
                    }
                }
                if (!isInList) {
                    listeNachbarn.add(currentNew);
                }
            }
            */
            startCache = lowestCostKnoten;
        }

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
            System.out.println("Cost: " + markierteKnoten.get(b).getPred().getCost());
            System.out.println("");
        }

        if (zielKnoten.isMarked()) {
            pfadExistiert = true;
        }
        return pfadExistiert;
    }

    private static void mergeListen(List old, List addToOld) {
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
     * @param zielKnoten
     * @param graph
     */
    private static void dijkstraSetup(KnotenDijkstra startKnoten, KnotenDijkstra zielKnoten, IGraph graph) {
        for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
            KnotenDijkstra knoten = (KnotenDijkstra) graph.getKnoten(i);
            if (knoten != startKnoten) {
                knoten.setPred(null);
                knoten.setCost(0);
                knoten.setMarked(false);
            } else { //also der Startknoten
                knoten.setPred(knoten);
                knoten.setCost(0);
                knoten.setMarked(true);
            }
        }
    }

    /**
     * Sucht den Nachbarknoten der mit den geringsten Kosten zu erreichen ist.
     * Setzt außerdem die Kantenkosten im Knoten B.
     *
     * @param startknoten
     * @param listeNachbarn
     * @param graph
     * @return
     */
    private static KnotenDijkstra getLowestCost(KnotenDijkstra startknoten, List listeNachbarn, IGraph graph) {

        KnotenDijkstra currentLowestCost = ((KnotenDijkstra) listeNachbarn.get(0));
        double cost;
        double costCache;

        if (currentLowestCost.getCost() == 0.0) {
            cost = graph.getKantenGewicht(startknoten, currentLowestCost);
            ((KnotenDijkstra) listeNachbarn.get(0)).setCost(cost);
        } else {
            cost = ((KnotenDijkstra) listeNachbarn.get(0)).getCost();
        }

        // Knoten mit den niedrigsten Kosten aus der Nachbarliste suchen.
        for (int i = 1; i < listeNachbarn.size(); i++) {

            //double costCache = graph.getKantenGewicht(startknoten, (KnotenDijkstra) listeNachbarn.get(i));

            costCache = graph.getKantenGewicht(startknoten, (KnotenDijkstra) listeNachbarn.get(i));
            if (costCache > 0) {

                if (((KnotenDijkstra) listeNachbarn.get(i)).getCost() == 0.0) {
                    ((KnotenDijkstra) listeNachbarn.get(i)).setCost(costCache);
                }
                //if (costCache < cost) {
                if (costCache < currentLowestCost.getCost()) {
                    currentLowestCost = (KnotenDijkstra) listeNachbarn.get(i);
                }
            }
        }

        return currentLowestCost;
    }

    /**
     * generates a Graph with the specified amount of verticies and edges.
     *
     * @param anzahlKnoten -> int, pass the amount of verticies.
     * @param anzahlKanten -> int, pass the amount of edges.
     * @param graph        -> IGraph, verticies and edges will be added here.
     */
    public static void generateGraph(int anzahlKnoten, int anzahlKanten, IGraph graph) {
        for (int i = 0; i < anzahlKnoten; i++) {
            KnotenDijkstra<String> A = new KnotenDijkstra<String>("Knoten_" + i);
            graph.addKnoten(A);
        }

        for (int j = 0; j < anzahlKanten; j++) {
            setzeKante(graph);
        }
    }

    /**
     * setzt eine Kante zwischen 2 zufaelligen Knoten.
     */
    protected static void setzeKante(IGraph graph) {
        int indexKanteA = (int) (Math.random() * (graph.getAnzahlKnoten()));
        int indexKanteB = (int) (Math.random() * (graph.getAnzahlKnoten()));

        double gewichtAB = round(Math.random() + 1, 2);
        graph.addKante(graph.getKnoten(indexKanteA), graph.getKnoten(indexKanteB), gewichtAB);
    }
}
