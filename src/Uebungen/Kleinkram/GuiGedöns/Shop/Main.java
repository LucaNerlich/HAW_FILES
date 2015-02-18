package Uebungen.Kleinkram.GuiGedöns.Shop;

import Uebungen.Kleinkram.GuiGedöns.Shop.Produkte.Lebensmittel;
import Uebungen.Kleinkram.GuiGedöns.Shop.Produkte.Produkt;

import java.util.Date;

/**
 * Created by lnerlich on 18.02.2015.
 */
public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();

        Produkt milch = new Lebensmittel("milch", 1.1f, new Date(2015, 11, 12));
        Produkt kaese = new Lebensmittel("kaese", 2.67f, new Date(2015, 10, 5));

        shop.addProdukt(milch, 12);
        shop.printWarenbestand();
        shop.printInventatWert();
        shop.addProdukt(milch, 12);
        shop.printWarenbestand();
        shop.printInventatWert();
        System.out.println("###");
        shop.addProdukt(kaese, 111);
        shop.addProdukt(milch, 1);
        shop.addProdukt(kaese, 34);
        shop.printWarenbestand();
        shop.printInventatWert();
    }
}
