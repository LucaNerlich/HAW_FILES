package AD.aufgabe12;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 12
 * DynProg.java
 * Application class for our list
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class DynProg {

    public DynProg() {
    }

    /**
     * loest das Rucksackproblem auf die Eingabe eines Aktien Arrays.
     *
     * @param rucksackGr
     * @param aktien
     * @return
     */
    public int knapsackDynProg(int rucksackGr, Aktie[] aktien) {
        return solveKnapsack(rucksackGr, aktien);
    }

    private int solveKnapsack(int rucksackGr, Aktie[] aktien) {
        int anzahlAktien = aktien.length;
        int[][] mOpti = new int[anzahlAktien + 1][rucksackGr + 1];

        for (int i = 1; i <= anzahlAktien; i++) {
            for (int j = 0; j <= rucksackGr; j++) {
                if (aktien[i - 1].getPreis() <= j) {
                    int wertCurrent = (int) (aktien[i - 1].getPreis1Year());
                    mOpti[i][j] = Math.max(mOpti[i - 1][j], mOpti[i - 1][j - aktien[i - 1].getPreis()] + wertCurrent);
                } else {
                    mOpti[i][j] = mOpti[i - 1][j];
                }
            }
        }
        int optimaleSumme = mOpti[anzahlAktien][rucksackGr];
        return optimaleSumme;
    }
}
