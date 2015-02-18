package Uebungen.Kleinkram.GuiGedöns.Shop;

import Uebungen.Kleinkram.GuiGedöns.Shop.Produkte.Produkt;

/**
 * Created by lnerlich on 18.02.2015.
 */
public class Shop {

    private Lager lager;

    public Shop() {
        lager = new Lager(100);
    }

    public void addProdukt(Produkt produkt, int anzahl) {
        lager.addProdukt(produkt, anzahl);
    }

    public void printWarenbestand() {
        lager.printLagerbestand();
    }

    public void printInventatWert() {
        System.out.println(lager.getInventarWert());
    }
}
