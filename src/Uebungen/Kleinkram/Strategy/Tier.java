package Uebungen.Kleinkram.Strategy;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 11.02.15
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class Tier implements LaufVerhalten {

    private LaufVerhalten laufVerhalten;
    private String name;
    private int gewicht;
    private boolean geschlecht;
    private float geschwindigkeit = 1.0f;

    public Tier(LaufVerhalten laufVerhalten, String name) {
        this.laufVerhalten = laufVerhalten;
        this.name = name;
    }

    @Override
    public void move() {
        laufVerhalten.move();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LaufVerhalten getLaufVerhalten() {
        return laufVerhalten;
    }

    public void setLaufVerhalten(LaufVerhalten laufVerhalten) {
        this.laufVerhalten = laufVerhalten;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(boolean geschlecht) {
        this.geschlecht = geschlecht;
    }

    public float getGeschwindigkeit() {
        return geschwindigkeit;
    }

    protected void setGeschwindigkeit(float geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void changeSpeed(float geschwindigkeit) {
        setGeschwindigkeit(geschwindigkeit);
    }
}
