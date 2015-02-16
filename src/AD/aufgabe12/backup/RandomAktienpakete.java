package AD.aufgabe12.backup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CR on 14.12.14.
 */
public class RandomAktienpakete {

    private List<Aktienpaket> aktienpaket;

    public RandomAktienpakete(int size) {

        this.aktienpaket = new ArrayList<Aktienpaket>();

        for (int i = 0; i < size; i++) {
            this.aktienpaket.add(generateAktienpaket());
        }

    }

    public List<Aktienpaket> getAktienpakete() {
        return aktienpaket;
    }

    private Aktienpaket generateAktienpaket() {

        String randomString = new RandomString(10).toString();
        int randomWeight = (int) (Math.random() * 100) + 1;
        float randomPerformance = 10f - (0.1f * (float) ((int) (Math.random() * 111)));

        return new Aktienpaket(randomString, randomWeight, randomPerformance);
    }


}
