package AD.aufgabe12.backup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abp860 on 12.12.2014.
 */
public class Rucksackproblem {

    private final int capacity;
    private final List<Aktienpaket> aktienpakete;

    public Rucksackproblem(int capacity) {
        this.capacity = capacity;
        this.aktienpakete = new ArrayList<Aktienpaket>();
    }

    public Rucksackproblem(int capacity, List<Aktienpaket> aktienpakete) {
        this.capacity = capacity;
        this.aktienpakete = aktienpakete;
    }

    public void add(Aktienpaket aktienpaket) {
        aktienpakete.add(aktienpaket);
    }

    public Set<Aktienpaket> getAktienpakete() {
        Set<Aktienpaket> aktienpakete = new HashSet<Aktienpaket>();
        for (Aktienpaket paket : this.aktienpakete)
            aktienpakete.add(paket);
        return aktienpakete;
    }

    public Set<Aktienpaket> findeLoesung() {
        return findeLoesung(aktienpakete.size() - 1, capacity);
    }

    private Set<Aktienpaket> findeLoesung(int itemIndex, int capacity) {
        if (itemIndex < 0)
            return null;
        if (aktienpakete.get(itemIndex).getWeight() > capacity) {
            return findeLoesung(itemIndex - 1, capacity);
        } else {
            Set<Aktienpaket> leave = findeLoesung(itemIndex - 1, capacity);
            Set<Aktienpaket> take = findeLoesung(itemIndex - 1, capacity - aktienpakete.get(itemIndex).getWeight());
            int a = AktienpaketUtil.getValue(leave);
            int b = AktienpaketUtil.getValue(take) + aktienpakete.get(itemIndex).getValue();
            if (b > a) {
                if (take == null)
                    take = new HashSet<Aktienpaket>();
                take.add(aktienpakete.get(itemIndex));
                return take;
            }

            return leave;
        }
    }


}