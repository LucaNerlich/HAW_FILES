package AD.aufgabe12.backup;

import java.util.List;

/**
 * Created by abp860 on 12.12.2014.
 */
public class DynamischeProgrammierung {

    private int k;
    private List<Aktienpaket> aktienpakete;
    private int[][] array;

    public DynamischeProgrammierung(int k, List<Aktienpaket> aktienpakete) {
        this.k = k;
        this.aktienpakete = aktienpakete;
        this.array = new int[aktienpakete.size() + 1][k + 1];
    }

    public int findeLoesung() {

        // erste Zeile mit 0 initialisieren
        for (int i = 0; i < k + 1; i++) {
            array[0][i] = 0;
        }

        // algorithmus
        for (int i = 1; i <= aktienpakete.size(); i++) {
            for (int j = 0; j <= k; j++) {
                if (aktienpakete.get(i - 1).getWeight() <= j) {
                    array[i][j] = Math.max(array[i - 1][j], array[i - 1][j - aktienpakete.get(i - 1).getWeight()] + aktienpakete.get(i - 1).getValue());
                } else {
                    array[i][j] = array[i - 1][j];
                }
            }
        }
        return array[aktienpakete.size()][k];
    }
}
