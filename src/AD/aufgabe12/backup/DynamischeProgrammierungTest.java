package AD.aufgabe12.backup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamischeProgrammierungTest {

    public static int ANZAHLAKTIENPAKETE = 10000000;
    public static int KAPAZITAET = 500;

    @Test
    public void testFindeLoesung() throws Exception {

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

        DynamischeProgrammierung test = new DynamischeProgrammierung(150, liste);

        System.out.println("Anzahl Aktienpakete: " + liste.size());
        System.out.println("Maximaler Ertrag: " + test.findeLoesung());
        System.out.println();

        //
        System.out.println("### Dynamischer Test ###");
        RandomAktienpakete randomAktienpakete = new RandomAktienpakete(ANZAHLAKTIENPAKETE);
        DynamischeProgrammierung dynamicTest = new DynamischeProgrammierung(KAPAZITAET, randomAktienpakete.getAktienpakete());

        System.out.println("Anzahl Aktienpakete: " + randomAktienpakete.getAktienpakete().size());
        System.out.println("Maximaler Ertrag: " + dynamicTest.findeLoesung());
        System.out.println();
    }
}