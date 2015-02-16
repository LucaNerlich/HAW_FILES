package AD.aufgabe5;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5
 * PDIterativ.java
 */

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class PDIterativ {

    int zeile;
    long[][] pascal;
    private int counter;
    private boolean printLines = true;

    public void setUp(int zeile) {
        this.zeile = zeile;
        pascal = new long[this.zeile][this.zeile];
        createPascal();
    }

    private void createPascal() {
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < i; j++) {

                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                    counter++;
                } else {
                    //1 hoch und 1 nach links + 1 hoch = Ergebnis fuer aktuelles Feld
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                    counter += 2;
                }
            }
        }
    }

    public void printPascal() {
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < i; j++) {
                if (printLines) {
                    System.out.print(pascal[i][j]);
                    System.out.print(" ");
                }
            }
            if (printLines) {
            System.out.println();
            }
        }
    }

    public void getLineN(int n) {
        for (int j = 0; j < n; j++) {
            System.out.print(pascal[n][j]);
            System.out.print(" ");
        }
    }

    /**
     * local pascal triangle which returns the counter for a given row.
     * O(N²)
     *
     * @param row
     * @return -> integer counter
     */
    public int getCounterForLine(int row) {
        int lineCounter = 0;
        int[][] pascalForCounter;
        pascalForCounter = new int[row][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {

                if (j == 0 || j == i) {
                    pascalForCounter[i][j] = 1;
                    lineCounter++;
                } else {
                    //1 hoch und 1 nach links + 1 hoch = Ergebnis fuer aktuelles Feld
                    pascalForCounter[i][j] = pascalForCounter[i - 1][j - 1] + pascalForCounter[i - 1][j];
                    lineCounter += 2;
                }
            }
        }

        return lineCounter;
    }

    public long getItemFromArray(int row, int column) {
        return pascal[row][column];
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}
