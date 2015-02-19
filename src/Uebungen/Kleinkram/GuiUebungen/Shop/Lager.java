package Uebungen.Kleinkram.GuiUebungen.Shop;

import Uebungen.Kleinkram.GuiUebungen.Shop.Produkte.Produkt;

/**
 * Created by lnerlich on 18.02.2015.
 */
public class Lager {
    // Produkt / Bestand
    private Produkt[] lager;
    private int[] lagerBestand;

    public Lager(int lagergroesse) {
        lager = new Produkt[lagergroesse];
        lagerBestand = new int[lagergroesse];
    }

    /**
     * fuegt ein Produkt in uebergebener Anzahl dem Lager hinu
     *
     * @param produkt
     * @param anzahl
     */
    public void addProdukt(Produkt produkt, int anzahl) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].getName().equals(produkt.getName()) && lager[i].getPrice() == produkt.getPrice()) {
                lagerBestand[i] = lagerBestand[i] + anzahl;
                break;
            }
            if (lager[i] == null) {
                lager[i] = produkt;
                lagerBestand[i] = anzahl;
                break;
            }
        }
    }

    /**
     * print das Lagerinventar in der Console
     */
    public void printLagerbestand() {
        System.out.println("------");
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                System.out.println(lager[i].getName() + " - Bestand: " + lagerBestand[i] + " - Preis: " + lager[i].getPrice());
            }
        }
    }

    /**
     * addiert die Preise aller Produkte im Lager
     * @return
     */
    public float getInventarWert() {
        float wert = 0f;

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                wert += (lager[i].getPrice() * lagerBestand[i]);
            }
        }
        return wert;
    }
}
