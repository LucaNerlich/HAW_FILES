package Uebungen.Kleinkram.Threads;

/**
 * Created by lnerlich on 13.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadedCounter threadedCounter = new ThreadedCounter();
        ThreadedCounter2nd threadedCounter2nd = new ThreadedCounter2nd();

        threadedCounter.start();
        threadedCounter2nd.start();
    }
}
