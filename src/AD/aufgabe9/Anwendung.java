package AD.aufgabe9;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 9
 * Anwendung.java
 *
 * Application class for our BST.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Anwendung {

    public static void main(String[] args) {

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

            System.out
                    .println("\n-------------- Ausgabe PreOrder --------------");
            treeZusatz.printPreOrder(root);

            System.out
                    .println("\n-------------- Ausgabe PostOrder --------------");
            treeZusatz.printPostOrder(root);

            System.out
                    .println("\n-------------- Ausgabe InOrder --------------");
            treeZusatz.printInOrder(root);

            System.out.println("ENDE");

            treeZusatz.printAlleZusatzWerte(root);

            System.out.println("#### subtree m= 5 ; M= 12");
            System.out.println("Sequenzsumme: " + treeZusatz.getSeq(5, 12));

            System.out.println((treeZusatz.getMinNode(root, 99).getWert()));
            System.out.println((treeZusatz.getMaxNode(root, 12).getWert()));

        } catch (NodeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}