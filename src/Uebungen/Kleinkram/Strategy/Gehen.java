package Uebungen.Kleinkram.Strategy;

/**
 * Created with IntelliJ IDEA.
 * User: lnerlich
 * Date: 11.02.15
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class Gehen implements LaufVerhalten {
    @Override
    public void move() {
        System.out.println("ein kleiner Schritt...");
    }
}
