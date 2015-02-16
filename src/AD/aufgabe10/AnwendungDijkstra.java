package AD.aufgabe10;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 10
 * AnwendungDijkstra.java
 * Application class for our dijkstra Algorithm
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */

public class AnwendungDijkstra extends Anwendung {
    public static void main(String[] args) {

        long startTime;
        long endTime;
        long totalTime;

        long startTimeGenerate;
        long endTimeGenerate;
        long totalTimeGenerate;

        IGraph<String> graph = getInstance();
        Dijkstra dijkstra = new Dijkstra();

        startTimeGenerate = 0 + System.currentTimeMillis();

        generateGraph(10, 10, graph);

        endTimeGenerate = System.currentTimeMillis();
        totalTimeGenerate = endTimeGenerate - startTimeGenerate;
        System.out.println("Totaltime Dijkstra: " + totalTimeGenerate);

        System.out.println("Anzahl Knoten: " + graph.getAnzahlKnoten());
        System.out.println("Anzahl Kanten: " + graph.getAnzahlKanten());


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


        // KnotenDijkstra A = (KnotenDijkstra) graph.getKnoten(2);
        // KnotenDijkstra D = (KnotenDijkstra) graph.getKnoten(5);

        startTime = 0 + System.currentTimeMillis();

        System.out.println("Pfad gefunden? : " + dijkstra.findPath(A, D, graph));

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Totaltime Dijkstra: " + totalTime);

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
