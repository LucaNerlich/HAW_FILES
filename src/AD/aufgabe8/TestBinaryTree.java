package AD.aufgabe8;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 8
 * TestBinaryTree.java
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Application class for our BinaryTree test
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestBinaryTree {
    @Test
    public void test() {
        try {
            BinaryNode root = new BinaryNode(2, "23");
            BinaryTree binaryTree = new BinaryTree(root);
            BinaryTreeArray binaryTreeArray = new BinaryTreeArray(root);

            BinaryNode zwei = new BinaryNode(42, "42");
            BinaryNode drei = new BinaryNode(5, "5");
            BinaryNode vier = new BinaryNode(3, "3");
            BinaryNode fuenf = new BinaryNode(112, "112");
            BinaryNode sechs = new BinaryNode(22, "22");
            BinaryNode sieben = new BinaryNode(66, "66");

            binaryTree.addNodeItem(root, zwei);
            binaryTree.addNodeItem(root, drei);
            binaryTree.addNodeItem(root, vier);
            binaryTree.addNodeItem(root, fuenf);
            binaryTree.addNodeItem(root, sechs);
            binaryTree.addNodeItem(root, sieben);

            binaryTree.printInOrder(root);

            binaryTreeArray.addNodeItem(root, zwei);
            binaryTreeArray.addNodeItem(root, drei);
            binaryTreeArray.addNodeItem(root, vier);
            binaryTreeArray.addNodeItem(root, fuenf);
            binaryTreeArray.addNodeItem(root, sechs);
            binaryTreeArray.addNodeItem(root, sieben);

            assertEquals(root, binaryTreeArray.getItemAtIndex(1));
            assertEquals(zwei, binaryTreeArray.getItemAtIndex(3));
            assertEquals(fuenf, binaryTreeArray.getItemAtIndex(7));
            assertEquals(sieben, binaryTreeArray.getItemAtIndex(14));

        } catch (NodeException e) {
            e.printStackTrace();
        }
    }
}
