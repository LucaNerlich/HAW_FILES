package AD.aufgabe8;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 8
 * Anwendung.java
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Anwendung {

    public static void main(String[] args) {

        try {
            BinaryNode root = new BinaryNode(23, "23");
            BinaryTree binaryTree = new BinaryTree(root);


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

            // System.out.println(binaryTree.findNode(1.5));


            System.out
                    .println("\n-------------- Ausgabe PreOrder --------------");
            binaryTree.printPreOrder(binaryTree.getWurzel());

            System.out
                    .println("\n-------------- Ausgabe PostOrder --------------");
            binaryTree.printPostOrder(binaryTree.getWurzel());

            System.out
                    .println("\n-------------- Ausgabe InOrder --------------");
            binaryTree.printInOrder(binaryTree.getWurzel());

        } catch (NodeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("-------------- Binarytree to Array --------------");


        BinaryNode root = new BinaryNode(23, "23");
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(root);

        BinaryNode zwei = new BinaryNode(42, "42");
        BinaryNode drei = new BinaryNode(5, "5");
        BinaryNode vier = new BinaryNode(3, "3");
        BinaryNode fuenf = new BinaryNode(112, "112");
        BinaryNode sechs = new BinaryNode(22, "22");
        BinaryNode sieben = new BinaryNode(66, "66");

        binaryTreeArray.addNodeItem(root, zwei);
        binaryTreeArray.addNodeItem(root, drei);
        binaryTreeArray.addNodeItem(root, vier);
        binaryTreeArray.addNodeItem(root, fuenf);
        binaryTreeArray.addNodeItem(root, sechs);
        binaryTreeArray.addNodeItem(root, sieben);


        System.out
                .println("\n-------------- Ausgabe PreOrder --------------");
        binaryTreeArray.printPreOrder(root);

        System.out
                .println("\n-------------- Ausgabe PostOrder --------------");
        binaryTreeArray.printPostOrder(root);

        System.out
                .println("\n-------------- Ausgabe InOrder --------------");
        binaryTreeArray.printInOrder(root);

        System.out.println("ENDE");
    }
}