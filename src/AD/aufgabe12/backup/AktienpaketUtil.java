package AD.aufgabe12.backup;

import java.util.Set;

public class AktienpaketUtil {
    public static int getValue(Set<Aktienpaket> aktienpakete) {
        if (aktienpakete == null)
            return 0;
        int value = 0;
        for (Aktienpaket paket : aktienpakete)
            value += paket.getValue();
        return value;
    }

    public static int getWeight(Set<Aktienpaket> aktienpakete) {
        if (aktienpakete == null)
            return 0;
        int weight = 0;
        for (Aktienpaket paket : aktienpakete)
            weight += paket.getWeight();
        return weight;
    }
}