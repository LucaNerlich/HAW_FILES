package AD.aufgabe1;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * printCounter.java
 */

/**
 * Application class to count operations of our methods
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class PrintCounter {

    public static void main(String[] args) {
        Node node1 = new Node("11");
        int loopCountInsert = 2;
        int loopCountRetrieve = 1;
        int loopCountFind = 1;
        int loopCountDelete = 11;

        ListeNeu listeNeu = new ListeNeu(node1);

        for (; loopCountInsert < 11; loopCountInsert++) {
            listeNeu.insert(loopCountInsert, "" + loopCountInsert + "" + loopCountInsert);
            System.out.println("loopcountinsert : " + loopCountInsert);
            listeNeu.getInsertCountOp();
        }

        System.out.println("######################");

        for (; loopCountRetrieve < 11; loopCountRetrieve++) {
            listeNeu.retrieve(loopCountRetrieve);
            System.out.println("loopcountRetrieve : " + loopCountRetrieve);
            listeNeu.getRetrieveCountOp();
        }

        System.out.println("######################");

        for (; loopCountFind < 11; loopCountFind++) {
            String element = (String) listeNeu.retrieve(loopCountFind);
            listeNeu.find(element);
            System.out.println("loopcountFind : " + loopCountFind);
            listeNeu.getFindCountOp();
        }

        System.out.println("######################");

        for (; loopCountDelete > 0; loopCountDelete--) {
            listeNeu.delete(loopCountDelete);
            System.out.println("loopcountDelete : " + loopCountDelete);
            listeNeu.getDeleteCountOp();
        }
    }
}