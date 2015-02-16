package Uebungen.Kleinkram.Strategy;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 11.02.15
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Hund hund = new Hund(new Gehen(), "Hund");
        Taube taube = new Taube(new Fliegen(), "Taube?");

        System.out.println(hund.getName());
        hund.move();

        System.out.println(taube.getName());
        taube.move();

        taube.changeSpeed(2);
        System.out.println(taube.getGeschwindigkeit());

    }
}
