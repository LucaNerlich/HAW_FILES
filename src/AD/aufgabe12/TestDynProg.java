package AD.aufgabe12;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 12
 * TestDynProg.java
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestDynProg {
    @Test
    public void test() {
        DynProg dynProg = new DynProg();

        Aktie legoland = new Aktie("Legoland", 33, 0.7f);
        Aktie monsters = new Aktie("Monsters Inc.", 38, -0.1f);
        Aktie dieFirma = new Aktie("Die Firma", 94, 0.6f);
        Aktie pangea = new Aktie("Pangea", 62, 0.8f);
        Aktie enterprise = new Aktie("Enterprise AG", 28, 0.2f);
        Aktie stern = new Aktie("Stern des Suedens", 20, 1.1f);
        Aktie astra = new Aktie("Astra", 58, -0.05f);
        Aktie maritim = new Aktie("Maritim e.V.", 48, 0.4f);

        Aktie[] aktien = new Aktie[8];

        aktien[0] = legoland;
        aktien[1] = monsters;
        aktien[2] = dieFirma;
        aktien[3] = pangea;
        aktien[4] = enterprise;
        aktien[5] = stern;
        aktien[6] = astra;
        aktien[7] = maritim;

        //248 nach Aussagen auf Facebook.
        System.out.println(dynProg.knapsackDynProg(150, aktien));
        assertEquals(248, dynProg.knapsackDynProg(150, aktien));
    }
}
