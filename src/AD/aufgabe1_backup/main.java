package AD.aufgabe1_backup;

/**
 * Created by Luca on 23.09.2014.
 */
public class main {
    public static void main(String[] args) {
        AD.aufgabe1.Node node1 = new AD.aufgabe1.Node("node1");
        AD.aufgabe1.Node node2 = new AD.aufgabe1.Node("node2");
        AD.aufgabe1.Node node3 = new AD.aufgabe1.Node("node3");
        AD.aufgabe1.Node node4 = new AD.aufgabe1.Node("node2.5");
        AD.aufgabe1.Node node5 = new AD.aufgabe1.Node("node2.7");
        AD.aufgabe1.Node node6 = new AD.aufgabe1.Node("node1.5");

        LinListe linListe = new LinListe(node1);

        System.out.println(linListe.retrieve(1));
        System.out.println("index node 1: " + linListe.retrieve(1));

        linListe.insert(2, node2);
        System.out.println("index node 2: " + linListe.retrieve(2));

        linListe.insert(3, node3);
        System.out.println("index node 3: " + linListe.retrieve(3));

        linListe.insert(2, node4);
        linListe.insert(3, node5);
        linListe.insert(7, node6);
        System.out.println("index node 4: " + linListe.retrieve(4));

        System.out.println("index node 3: " + linListe.retrieve(3));

        linListe.delete(3);

        System.out.println("index node 3: " + linListe.retrieve(3));

        linListe.insert(-7, node4);
        System.out.println(linListe.retrieve(2));

        System.out.println("node2 pos: " + linListe.find(node2));
    }

}
