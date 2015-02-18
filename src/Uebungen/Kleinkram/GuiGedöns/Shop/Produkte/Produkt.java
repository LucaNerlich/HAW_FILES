package Uebungen.Kleinkram.GuiGedöns.Shop.Produkte;

/**
 * Created by lnerlich on 18.02.2015.
 */
public class Produkt {
    private String name;
    private float price;

    public Produkt(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
