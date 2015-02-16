package AD.aufgabe5;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5
 * TestPascal.java
 */

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Testclass for our Pascal's triangle
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestPascal {

    @Test
    public void testPascal() {

        //###############-Setup-###############

        PDIterativ pdIterativ = new PDIterativ();
        pdIterativ.setUp(11);
        PDRekursiv pdRekursiv = new PDRekursiv();
        PDBioCoeff pdBioCoeff = new PDBioCoeff();

        //###############-Test Interativ-###############

        System.out.println("###############-Test Interativ-###############");
        pdIterativ.getLineN(10);
        System.out.println("");
        System.out.println("Zahl in Zeile 10 und Spalte 8: " + pdIterativ.getItemFromArray(10, 7)); //Index fängt bei 0 an, daher +1
        assertTrue(pdIterativ.getItemFromArray(10, 7) == 36);

        //###############-Test Rekursiv-###############
        System.out.println("\n" + "###############-Test Rekursiv-###############");
        pdRekursiv.getLineN(10);
        // assertTrue();
        System.out.println("");

        //###############-Test Coeff-###############
        System.out.println("\n" + "###############-Test Coeff-###############");
        pdBioCoeff.getLineN(11);
        System.out.println("\n" + "Binomialkoeffizient für Zeile 11 Spalte 7: " + pdBioCoeff.getBioCoeff(10, 6));
        assertTrue(pdBioCoeff.getBioCoeff(10, 6) == 210);
        // Berechnet den Spalteneintrag für die folgende Zeile
    }
}
