package Uebungen.Kleinkram.GuiGedöns.Shop.Produkte;

import java.util.Date;

/**
 * Created by lnerlich on 18.02.2015.
 */
public class Lebensmittel extends Produkt {

    private Date ablaufDatum;

    public Lebensmittel(String name, float price, Date ablaufDatum) {
        super(name, price);
        this.ablaufDatum = ablaufDatum;
    }
}
