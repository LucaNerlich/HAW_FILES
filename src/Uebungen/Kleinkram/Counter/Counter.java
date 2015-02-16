package Uebungen.Kleinkram.Counter;

/**
 * Created by Luca on 10.02.2015.
 */
public class Counter {
    private int counterLeicht;
    private int counterMittel;
    private int counterSchwer;

    public Counter() {
        counterLeicht = 0;
        counterMittel = 0;
        counterSchwer = 0;
    }

    public void increaseCounter(int counterName, int wert) {
        switch (counterName) {
            case 1:
                counterLeicht += wert;
                break;
            case 2:
                counterMittel += wert;
                break;
            case 3:
                counterSchwer += wert;
                break;
            default:
                System.err.println("Sie müssen einen korrekten Counter (1 = leicht, 2 = mittel, 3 = schwer) angeben!");
                break;
        }
    }

    public int getCounterLeicht() {
        return counterLeicht;
    }

    public void setCounterLeicht(int counterLeicht) {
        this.counterLeicht = counterLeicht;
    }

    public int getCounterMittel() {
        return counterMittel;
    }

    public void setCounterMittel(int counterMittel) {
        this.counterMittel = counterMittel;
    }

    public int getCounterSchwer() {
        return counterSchwer;
    }

    public void setCounterSchwer(int counterSchwer) {
        this.counterSchwer = counterSchwer;
    }
}
