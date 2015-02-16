package Uebungen.Kleinkram.Counter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Luca on 10.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        boolean isOn = true;

        Scanner scanner = new Scanner(System.in);
        System.err.println("Zum beenden bitte einen beliebigen String in die Konsole schreiben. Danke.");
        try {
            while (isOn) {

                printInstructions();
                int chosenCounter = scanner.nextInt();

                System.out.println("Nun bitte den Int Wert um den sie den Counter erhöhen möchten: ");
                int wert = scanner.nextInt();

                counter.increaseCounter(chosenCounter, wert);
                printCurrentValues(counter);

            }
        } catch (InputMismatchException e) {
            System.err.println("Exit...");
        }
        scanner.close();
    }

    private static void printCurrentValues(Counter counter) {
        System.out.println("leicht: " + counter.getCounterLeicht());
        System.out.println("mittel: " + counter.getCounterMittel());
        System.out.println("schwer: " + counter.getCounterSchwer());
        System.out.println();
    }

    private static void printInstructions() {
        System.out.println("Please input a Number!");
        System.out.println("1 = CounterLeicht");
        System.out.println("2 = CounterMittel");
        System.out.println("3 = CounterSchwer");
    }
}
