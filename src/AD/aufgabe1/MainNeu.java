package AD.aufgabe1;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * mainNeu.java
 */

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class MainNeu {
    public static void main(String[] args) {
        Node node1 = new Node("node1");
        Node node4 = new Node("node2.5");

        ListeNeu listeNeu = new ListeNeu(node1);

        System.out.println(listeNeu.retrieve(1));
        System.out.println("LISTENEU index node 1: " + listeNeu.retrieve(1));

        listeNeu.insert(2, "Node 2");
        listeNeu.insert(1, "Node neuer erster");
        System.out.println("LISTENEU index new node 1: " + listeNeu.retrieve(1));
        System.out.println("index node 1 moved: " + listeNeu.find("node1"));
        listeNeu.insert(3, "Node 3");
        System.out.println("Find node 3: " + listeNeu.find("Node 3"));
        listeNeu.insert(2, "Node 4");
        listeNeu.insert(3, "Node 5");
        listeNeu.insert(7, "Node 6");
        System.out.println("Find node 3: " + listeNeu.find("Node 3"));
        System.out.println("Element index 6: " + listeNeu.retrieve(6));
        System.out.println("Element index 7: " + listeNeu.retrieve(7));

        System.out.println("Element index 3: " + listeNeu.retrieve(3));
        listeNeu.delete(3);
        System.out.println("Element index 3: " + listeNeu.retrieve(3));
        System.out.println("Element index 5: " + listeNeu.retrieve(5));

        //listeNeu.insert(-7, node4);

        System.out.println("\n"+"--- New List---");
        Node node11 = new Node("node11");

        ListeNeu listeNeuZwei = new ListeNeu(node11);
        listeNeuZwei.insert(2, "Node 22");
        listeNeuZwei.insert(3, "Node 33");
        listeNeuZwei.insert(2, "Node 21");

        System.out.println("Element index 4: " + listeNeuZwei.retrieve(4));
        ListeNeu listeDrei = listeNeu.concat(listeNeuZwei);
        //System.out.println(listeDrei);

        listeDrei.insert(1, "Node 44");
        System.out.println(listeDrei.find("Node 33"));
        System.out.println("Node at Pos 8: "+listeDrei.retrieve(8));
        System.out.println("Node at Pos 9: "+listeDrei.retrieve(9));
        System.out.println("Node at Pos 10: "+listeDrei.retrieve(10));
        listeDrei.delete(9);
        listeDrei.delete(8);


        System.out.println("Node at Pos 8: "+listeDrei.retrieve(8));
        System.out.println("Node at Pos 9: "+listeDrei.retrieve(9));
        listeDrei.delete(listeDrei.find("Node 33"));
        System.out.println("Node at Pos 8: "+listeDrei.retrieve(8));

        System.out.println("END");

        ListeNeu listeNeu5 = new ListeNeu();
        listeNeu5.insert(1, "TEST LEERE LISTE");
    }
}
