package AD.aufgabe9;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 9
 * TestBinaryTree.java
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * jUnit Testclass for our BinaryTree as well as the get Sequenztask from AD 09
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestBinaryTree {
    @Test
    public void test() {
        try {
            BinaryNode root = new BinaryNode(8, 8);
            BinaryTreeZusatz treeZusatz = new BinaryTreeZusatz(root);

            BinaryNode vier = new BinaryNode(4, 4);
            BinaryNode zwoelf = new BinaryNode(12, 12);
            BinaryNode zwei = new BinaryNode(2, 2);
            BinaryNode sechs = new BinaryNode(6, 6);
            BinaryNode zehn = new BinaryNode(10, 10);
            BinaryNode vierzehn = new BinaryNode(14, 14);

            treeZusatz.addNodeItem(root, vier);
            treeZusatz.addNodeItem(root, zwoelf);
            treeZusatz.addNodeItem(root, zwei);
            treeZusatz.addNodeItem(root, sechs);
            treeZusatz.addNodeItem(root, zehn);
            treeZusatz.addNodeItem(root, vierzehn);

            System.out.println("#### subtree m= 5 ; M= 12");
            System.out.println("Sequenzsumme: " + treeZusatz.getSeq(5, 12));
            //aus aufgabe
            assertEquals(36, treeZusatz.getSeq(5, 12));
            //kompletter Baum
            assertEquals(56, treeZusatz.getSeq(1, 15));
            //nur ein Knoten
            assertEquals(2, treeZusatz.getSeq(1, 3));

            //Beispiel fuer einen nicht balancierten Baum:

            BinaryNode root2 = new BinaryNode(1, 1);
            BinaryTreeZusatz treeZusatz2 = new BinaryTreeZusatz(root2);

            BinaryNode zwei2 = new BinaryNode(2, 2);
            BinaryNode drei2 = new BinaryNode(3, 3);
            BinaryNode vier2 = new BinaryNode(4, 4);
            treeZusatz2.addNodeItem(root2, zwei2);
            treeZusatz2.addNodeItem(root2, drei2);
            treeZusatz2.addNodeItem(root2, vier2);

            //kompletter Baum
            assertEquals(10, treeZusatz2.getSeq(0, 5));



        } catch (NodeException e) {
            e.printStackTrace();
        }
    }
}
