package AD.aufgabe5;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5
 * PDBioCoeff.java
 */

/**
 * Calculates a row of the Pascal's triangle for a given integer.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 *
 *         //http://www.macuser.de/forum/thema/498757-Java-und-Binomialkoeffizient
 */
public class PDBioCoeff {

    private int counter;
    private boolean printLines = true;

    /**
     * Calculates a row of the Pascal's triangle for a given integer.
     *
     * @param row -> integer, represents the row.
     */
    public void getLineN(int row) {
        row = row - 1; //-1 da wir die erste Zeile mitzaehlen.
        counter++;

        for (int column = 0; column <= row; column++) {
            int binCoeff = getBioCoeff(row, column);
            counter++;

            if (printLines) {
                System.out.print(binCoeff + " ");
            }
        }
    }

    /**
     * Calculates the binominal coefficient of a specified row/column
     * O(N²) - wir rufen die Methode ja in einer for-schleife auf um alle Werte
     * der Zeile zu erhalten.
     *
     * @param row    -> integer, represents the row.
     * @param column -> integer, represents the column.
     * @return
     */
    public int getBioCoeff(int row, int column) {
        int bioCoeff = 1;
        counter++;
        if (column > row - column) {
            column = row - column;
        }

        // rechnen zeile ueber spalte: (zeile! / (spalte! * (zeile-spalte)!))
        for (int i = 1, m = row; i <= column; i++, m--) {
            bioCoeff = bioCoeff * m / i;
            counter += 3;
        }

        counter++;
        return bioCoeff;
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}
