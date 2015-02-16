package AD.aufgabe5;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5
 * Main.java
 */

/**
 * Application class for our pascal's triangle
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Main {

    public static void main(String[] args) {

        PDIterativ pdIterativ = new PDIterativ();
        pdIterativ.setUp(11);
        PDRekursiv pdRekursiv = new PDRekursiv();
        PDBioCoeff pdBioCoeff = new PDBioCoeff();

        System.out.println("pdIterativ triangle with 10 lines: ");
        pdIterativ.getLineN(10);
        System.out.println();
        System.out.println("Counter: " + pdIterativ.getCounter());
        pdIterativ.resetCounter();
        System.out.println();
        System.out.println("Counter for Line 10: ");
        System.out.println(pdIterativ.getCounterForLine(10));
        System.out.println();

        System.out.println("pdRekursiv Line 10: ");
        pdRekursiv.getLineN(10);
        System.out.println();
        System.out.println("Counter: " + pdRekursiv.getCounter());
        pdRekursiv.resetCounter();
        System.out.println();

        System.out.println("pdBioCoeff Line 10: ");
        pdBioCoeff.getLineN(10);
        System.out.println();
        System.out.println("Counter: " + pdBioCoeff.getCounter());
        pdBioCoeff.resetCounter();
        System.out.println();

        System.out.println("############### ITERATIV ###############");

        for (int i = 1; i < 51; i++) {
            PDIterativ pdIterativ1 = new PDIterativ();
            pdIterativ1.setUp(i + 1);
            System.out.println(pdIterativ1.getCounter());
            pdIterativ1.resetCounter();

        }

        System.out.println("############### REKURSIV ###############");

        for (int i = 1; i < 25; i++) {
            PDRekursiv pdRekursiv1 = new PDRekursiv();
            pdRekursiv1.getLineN(i);
            System.out.println(pdRekursiv1.getCounter());
            pdRekursiv1.resetCounter();
        }

        System.out.println("############### BINOM COEFF ###############");

        for (int i = 1; i < 32; i++) {
            PDBioCoeff pdBioCoeff1 = new PDBioCoeff();
            pdBioCoeff1.getLineN(i);
            System.out.println(pdBioCoeff1.getCounter());
            pdBioCoeff1.resetCounter();
        }
        System.out.println("##################################################################");
        pdRekursiv.resetCounter();
        System.out.println(pdRekursiv.lineHelper(2, 1));


    }
}
