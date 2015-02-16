package AD.aufgabe5;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5
 * PDRekursiv.java
 */

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class PDRekursiv {

    private int counter;
    private boolean printLines = true;

    public void getLineN(int row) {
        for (int i = 0; i < row; i++) {
            if (printLines) {
                System.out.print(lineHelper(row - 1, i));
                System.out.print(" ");
            } else {
                lineHelper(row - 1, i);
            }
        }
    }

    public int lineHelper(int row, int column) {
        counter++;
        if (row * column == 0 || row == column) {
            return 1;
        } else {
            return (lineHelper(row - 1, column - 1) + lineHelper(row - 1, column));
        }
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}
