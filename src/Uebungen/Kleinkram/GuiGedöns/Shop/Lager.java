package Uebungen.Kleinkram.GuiGedöns.Shop;

import Uebungen.Kleinkram.GuiGedöns.Shop.Produkte.Produkt;

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

    public void addProdukt(Produkt produkt, int anzahl) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].equals(produkt)) {
                lagerBestand[i] = lagerBestand[i] + anzahl;
                break;
            }
            if (lager[i] == null) {
                lager[i] = produkt;
                lagerBestand[i] = lagerBestand[i] + anzahl;
                break;
            }
        }
    }

    public void printLagerbestand() {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                System.out.println(lager[i].getName() + " - Bestand: " + lagerBestand[i]);
            }
        }
    }

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
