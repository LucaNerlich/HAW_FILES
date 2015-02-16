package AD.aufgabe8;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 8
 * BinaryTreeArray.java
 */

import java.util.Arrays;

/**
 * Implements a binary tree based on an array
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class BinaryTreeArray<T extends Comparable<T>, U> implements Sortable {

    private BinaryNode<T, U>[] tree;
    private int arrayGroesse;
    int counterPre = 0;
    int counterPost = 0;
    int counterIn = 0;

    public BinaryTreeArray(BinaryNode root) {
        arrayGroesse = 2;
        tree = new BinaryNode[arrayGroesse];
        tree[1] = root;
    }

    @Override
    public BinaryNode addNodeItem(BinaryNode current, BinaryNode newNode) {

        arrayGroesse++;
        if (arrayGroesse >= tree.length) {
            expandTreeArray();
        }

        //root @ 1
        if (tree[1] == null) {
            //set new Node as root
            tree[1] = newNode;
        } else {
            addHelper(1, newNode);
        }
        return current;
    }

    private void addHelper(int i, BinaryNode newNode) {

        if (((i * 2) + 1) <= tree.length) {

            if (((T) tree[i].getSchluessel()).compareTo((T) newNode.getSchluessel()) > 0) {
                if (tree[(i * 2)] == null) {
                    tree[(i * 2)] = newNode;
                    System.out.println("ADDED: " + newNode.getWert());
                    return;
                } else {
                    i = i * 2;
                    addHelper(i, newNode);
                }

            } else if (((T) tree[i].getSchluessel()).compareTo((T) newNode.getSchluessel()) < 0) {
                if (tree[(i * 2) + 1] == null) {
                    tree[(i * 2) + 1] = newNode;
                    System.out.println("ADDED: " + newNode.getWert());
                    return;
                } else {
                    i = (i * 2) + 1;
                    addHelper(i, newNode);
                }
            }
        }
    }

    @Override
    public void printPreOrder(BinaryNode wurzel) {
        preOrderHelper(1);
    }

    private void preOrderHelper(int i) {

        if (tree[i] == null) {
            return;
        }
        counterPre++;
        System.out.println(counterPre + ":" + tree[i].getWert());

        if (i * 2 > tree.length) {
            return;
        }
        preOrderHelper(i * 2);
        preOrderHelper((i * 2) + 1);
    }

    @Override
    public void printPostOrder(BinaryNode wurzel) {
        postOrderHelper(1);
    }

    private void postOrderHelper(int i) {
        if (tree[i] == null) {
            return;
        }

        if (i * 2 < tree.length) {
            postOrderHelper(i * 2);
        }
        if ((i * 2) + 1 < tree.length) {
            postOrderHelper((i * 2) + 1);
        }

        counterPost++;
        System.out.println(counterPost + ":" + tree[i].getWert());
    }

    @Override
    public void printInOrder(BinaryNode wurzel) {
        inOrderHelper(1);
    }

    private void inOrderHelper(int i) {
        if (tree[i] == null) {
            return;
        }

        if (i * 2 < tree.length) {
            inOrderHelper(i * 2);
        }

        counterIn++;
        System.out.println(counterIn + ":" + tree[i].getWert());

        if ((i * 2) + 1 < tree.length) {
            inOrderHelper((i * 2) + 1);
        }
    }

    /**
     * Expands our Array if necessary
     */
    private void expandTreeArray() {
        System.out.println("STACK SUCCESSFULLY EXPANDED");
        tree = Arrays.copyOf(tree, (tree.length * 10) + 1);
    }

    public BinaryNode getItemAtIndex(int index) {
        return tree[index];
    }
}
