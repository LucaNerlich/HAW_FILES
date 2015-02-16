package AD.aufgabe1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * testInListe.java
 */

/**
 * Testclass for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestLinListe {

    @Test
    public void testListeNeu() {
        try {
        /* ################## SETUP ##################*/
            Node<String> startNode = new Node<String>("TEST_NODE_01");
            ListeNeu listeNeu = new ListeNeu(startNode);

            Node head = listeNeu.getStartNode();
            System.out.println("STARTNNODE: " + head.getData());

        /* ################## TEST STARTNODE##################*/
            int position = listeNeu.find(listeNeu.getStartNode().getData());

            // Position should equal the startNode
            assertTrue(position == 1);

            System.out.println("");
        /* ################## TEST INSERT AT 2 ##################*/
            System.out.println(">>TEST FOR INSERT AT POS 2:");
            System.err.println("BEFORE INSERT -> RETRIEVE(2): " + listeNeu.retrieve(2));
            listeNeu.insert(2, "TEST_NODE_02");
            System.out.println("AFTER INSERT -> RETRIEVE(2): " + listeNeu.retrieve(2));
            System.out.println("");
            //Get the data of the node following the startnode
            position = listeNeu.find(listeNeu.getStartNode().getNextNode().getData());

            assertTrue(position == 2);

        /* ################## TEST SECOND INSERT AT 2 ##################*/
            System.out.println(">>TEST FOR SECOND INSERT AT POS 2:");
            System.out.println("BEFORE SECOND INSERT -> RETRIEVE(2): " + listeNeu.retrieve(2));
            listeNeu.insert(2, "TEST_NODE_01.5");
            System.out.println("AFTER SECOND INSERT -> RETRIEVE(2): " + listeNeu.retrieve(2));
            System.out.println("AFTER SECOND INSERT -> RETRIEVE(3): " + listeNeu.retrieve(3));
            //Get the data of the node following the startnode -> pos 2
            position = listeNeu.find(listeNeu.getStartNode().getNextNode().getData());

            assertTrue(position == 2);
            assertEquals(listeNeu.getStartNode().getNextNode().getData(), "TEST_NODE_01.5");
            System.out.println("");
        /* ################## TEST DELETE 2 ##################*/
            System.out.println(">>TEST FOR DELETE AT POS 2:");
            System.out.println("BEFORE DELETE -> RETRIEVE(2): " + listeNeu.retrieve(2));
            listeNeu.delete(2);
            System.out.println("AFTER DELETE -> RETRIEVE(2): " + listeNeu.retrieve(2));
            System.out.println("");
            assertTrue(listeNeu.retrieve(2) == "TEST_NODE_02");

        /* ################## TEST FIND 2 ##################*/
            System.out.println(">>TEST FOR FIND AT POS 2:");
            System.out.println("RETRIEVE AT POS 2: " + listeNeu.retrieve(2));
            System.out.println("FIND AT: (" + listeNeu.retrieve(2) + "): " + listeNeu.find(listeNeu.retrieve(2)));
            assertTrue(listeNeu.find(listeNeu.retrieve(2)) == 2);
            System.out.println("");

        /* ################## TEST ELEMENT DOES NOT EXIST ##################*/
            System.out.println(">>TEST FOR NON EXISTING ELEMENT");
            //   System.out.println("Element:"+listeNeu.find("Test_Node"));
            assertTrue(listeNeu.find("Test_Node") == null);
            System.out.println("");

        /* ################## TEST CONCAT ##################*/
            System.out.println(">>TEST CONCAT");
            Node<String> startNode2 = new Node<String>("TEST2_NODE2_01");
            ListeNeu<String> listeNeu2 = new ListeNeu<String>(startNode2);

            listeNeu2.insert(2, "TEST2_NODE2_02");

            ListeNeu listeNeu3 = listeNeu.concat(listeNeu2);
            System.out.println("ListeNeu3 RETRIEVE AT POS 1: ");
            System.out.println(listeNeu3.retrieve(1));
            System.out.println("ListeNeu3 RETRIEVE AT POS 3: ");
            System.out.println(listeNeu3.retrieve(3));

            assertTrue(listeNeu3.retrieve(1) == "TEST_NODE_01");
            assertTrue(listeNeu3.retrieve(3) == "TEST2_NODE2_01");
            System.out.println("");

        /* ################## TEST EMPTY LIST##################*/
            System.out.println(">>TEST EMPTY LIST");
            Node<String> startNode4 = new Node<String>("TEST_NODE_02");
            ListeNeu<String> listeNeu4 = new ListeNeu<String>(startNode4);
            System.out.println("FIND NODE TEST_NODE_02 AT POS: " + listeNeu4.find("TEST_NODE_02"));
            System.out.println("DELETE NODE AT POS 1");
            listeNeu4.delete(1);
            assertNull(listeNeu4.retrieve(1));

            System.out.println("LIST IS EMPTY");
            listeNeu.concat(listeNeu4);
            System.out.println("EMPTY LIST -> FIND(TEST_NODE_02)");
            listeNeu4.find("TEST_NODE_02");
            System.out.println("");

        } catch (NullPointerException e) {
            System.out.println("FOUND NULL");
        }


    }
}
