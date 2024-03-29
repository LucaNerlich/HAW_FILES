/**
 * Praktikum WIPR2, SS 2014  
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1
 * CustomerTesting.java
 */
package PR2.aufgabe1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Diese Klasse repr�sentiert den JUnit-Test f�r unsere beiden Comparatoren
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class CustomerTesting {

    @Test
    public void testNachnameVornameComparator() {
        NachnameVornameComparator comp = new NachnameVornameComparator();

        /**
         * Den return-Wert der compare Methode zwischenspeichern und
         * entsprechend auf 1,-1 oder 0 pr�fen.
         */
        int result = comp.compare(new Customer("", "aNachname"), new Customer(
                "", "zNachname"));
        assertTrue(result < 0);

        result = comp.compare(new Customer("", "zNachname"), new Customer("",
                "aNachname"));
        assertTrue(result > 0);

        result = comp.compare(new Customer("", "aNachname"), new Customer("",
                "aNachname"));
        assertEquals(result, 0);

        result = comp.compare(new Customer("aVorname", "aNachname"),
                new Customer("zVorname", "aNachname"));
        assertTrue(result < 0);

        result = comp.compare(new Customer("zVorname", "aNachname"),
                new Customer("aVorname", "aNachname"));
        assertTrue(result > 0);

        result = comp.compare(new Customer("aVorname", "bNachname"),
                new Customer("aVorname", "bNachname"));
        assertEquals(result, 0);

    }

    @Test
    public void testIdComparator() {
        IdComparator idComp = new IdComparator();
        // Customer erst erstellen, damit wir die IDs klar definiert haben.

        Customer customer1 = new Customer("aVName", "bNName");
        Customer customer2 = new Customer("cVName", "dNName");
        Customer customer3 = new Customer("eVName", "fNName");

        // Nur die ID pr�fen
        assertEquals(idComp.compare(customer1, customer2), -1);
        assertEquals(idComp.compare(customer2, customer1), 1);
        assertEquals(idComp.compare(customer2, customer2), 0);
        assertEquals(idComp.compare(customer1, customer3), -1);
    }

    @Test
    public void testAddRemv() {
        WebShop webShopTest = new WebShop();

        webShopTest.addCustomer("Paul", "Panzer");

        int result = webShopTest.getSize();
        assertTrue(result == 1);

        webShopTest.removeCustomer("Paul", "Panzer");
        result = webShopTest.getSize();
        assertTrue(result == 0);
    }
}
