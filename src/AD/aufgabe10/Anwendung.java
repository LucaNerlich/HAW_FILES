package AD.aufgabe10;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 10
 * Anwendung.java
 */

import java.util.List;

/**
 * Application class for our Graph
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Anwendung {

    public static void main(String[] args) {
        IGraph<String> graph = getInstance();

        generateGraph(100, 250, graph);

        System.out.println("Anzahl Knoten: " + graph.getAnzahlKnoten());
        System.out.println("Anzahl Kanten: " + graph.getAnzahlKanten());

        //knotenKante(graph);
        printNachbarnAll(graph);
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
            Knoten<String> A = new Knoten<String>("Knoten_" + i);
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

        /*
        System.out.println("Gewicht: " + gewichtAB);
        System.out.println("IndexA: " + indexKanteA);
        System.out.println("Knoten A: " + graph.getKnoten(indexKanteA));
        System.out.println("IndexB: " + indexKanteB);
        System.out.println("Knoten B: " + graph.getKnoten(indexKanteB));
        System.out.println("");
        */
    }

    /**
     * Rundet einen gegebenen Wert auf die gewuenschte Anzahl von Nachkommastellen
     *
     * @param wert
     * @param anzahlNachkommastellen
     * @return
     */
    protected static double round(double wert, int anzahlNachkommastellen) {

        double s = Math.pow(10, anzahlNachkommastellen);
        return Math.round(wert * s) / s;
    }

    /**
     * Erzeugen der Instanz, die getestet werden soll - hier:
     * GraphAdjazenzListe.
     */
    public static IGraph<String> getInstance() {
        return new GraphAdjazenzListe<String>();
    }

    private static void knotenKante(IGraph graph) {
        int counter = 0;
        for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
            for (int j = 0; j < graph.getAnzahlKnoten(); j++) {
                if (graph.kanteExistiert(graph.getKnoten(i), graph.getKnoten(j))) {
                    counter++;
                    System.out.println(counter);
                    System.out.println("Kante A: " + graph.getKnoten(i));
                    System.out.println("Kante B: " + graph.getKnoten(j));
                    System.out.println("");
                }
            }
        }
    }

    protected static void printNachbarnAll(IGraph graph) {
        for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
            List list = graph.getNachbarn(graph.getKnoten(i));


            if (list.size() != 0) {
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("Knoten: " + graph.getKnoten(i));
                    if (list.get(j) != null) {
                        System.out.println(list.get(j));
                    }
                }
                System.out.println("");
            }
        }
    }
}
