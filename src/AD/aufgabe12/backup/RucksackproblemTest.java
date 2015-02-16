package AD.aufgabe12.backup;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RucksackproblemTest extends TestCase {

    public static int ANZAHLAKTIENPAKETE = 40;
    public static int KAPAZITAET = 100;

    @Test
    public void testAdd() throws Exception {

        System.out.println("### Aufgabenblatt Test ###");

        List<Aktienpaket> liste = new ArrayList<Aktienpaket>();
        liste.add(new Aktienpaket("Legoland", 33, 0.7F));
        liste.add(new Aktienpaket("Mosters Inc.", 38, -0.1F));
        liste.add(new Aktienpaket("Die Firma", 94, 0.6F));
        liste.add(new Aktienpaket("Pangea", 62, 0.8F));
        liste.add(new Aktienpaket("Enterprise AG", 28, 0.2F));
        liste.add(new Aktienpaket("Stern des Suedens", 20, 1.1F));
        liste.add(new Aktienpaket("Astra", 58, -0.05F));
        liste.add(new Aktienpaket("Maritim e.V.", 48, 0.4F));

        Rucksackproblem rucksackproblem = new Rucksackproblem(150, liste);

        Set<Aktienpaket> loesung = rucksackproblem.findeLoesung();
        System.out.println("Capacity: " + 150);
        System.out.println("Value: " + AktienpaketUtil.getValue(loesung));
        System.out.println("Weight: " + AktienpaketUtil.getWeight(loesung));
        System.out.println("\nControll:");
        int weight = 0;
        int value = 0;
        for (Aktienpaket paket : loesung) {
            System.out.println(paket.getName() + ": " + paket.getWeight());
            weight += paket.getWeight();
            value += paket.getValue();
        }
        System.out.println("Weight: " + weight);
        System.out.println("Value: " + value);
        System.out.println();


        //
        double startTime = System.nanoTime();
        System.out.println();


        System.out.println("### Dynamischer Test ###");
        RandomAktienpakete randomAktienpakete = new RandomAktienpakete(ANZAHLAKTIENPAKETE);
        Rucksackproblem rucksackTest = new Rucksackproblem(KAPAZITAET, randomAktienpakete.getAktienpakete());

        System.out.println("Anzahl Aktienpakete: " + randomAktienpakete.getAktienpakete().size());
        Set<Aktienpaket> dynamischeLoesung = rucksackTest.findeLoesung();
        System.out.println("Capacity: " + KAPAZITAET);
        System.out.println("Value: " + AktienpaketUtil.getValue(dynamischeLoesung));
        System.out.println("Weight: " + AktienpaketUtil.getWeight(dynamischeLoesung));
        System.out.println();

        weight = 0;
        value = 0;
        for (Aktienpaket paket : dynamischeLoesung) {
            System.out.println(paket.getName() + ": " + paket.getWeight());
            weight += paket.getWeight();
            value += paket.getValue();
        }
        System.out.println();

        System.out.println("Weight: " + weight);
        System.out.println("Value: " + value);

        System.out.println();

        double endTime = System.nanoTime();
        double timeElapsed = endTime - startTime;
        System.out.format("Zugriffszeit Eintraege: %10.1f ns %n", timeElapsed);
    }
}