package AD.aufgabe4;/**
 * Created by Luca on 15.10.2014.
 */

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * mainNeu.java
 */

/**
 * Application class for our list
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */

public class Rekursion {

    private static int counter = 0;
    private static int counter2 = 0;

    public static void main(String[] args) {
        //rek(1);
        //System.out.println(getCounter());

        //System.out.println(addRek(5));
        System.out.println(facRek(6));
        System.out.println(forFac(6));
        //System.out.println(gauß(4));
    }

    public static void rek(int n) {
        if (n == 1) {
            return;
        }
        counter++;
        rek(n / 2);
        rek(n / 2);

    }

    public static int getCounter() {
        return counter;
    }

    public static int addRek(int n) {
        if (n > 0) {
            counter2++;
            System.out.println(counter2);
            return n + (n * addRek(n - 1));
        } else {
            return 0;
        }
    }

    public static int facRek(int n) {
        {
            int result;
            if (n == 0 || n == 1) {
                return 1;
            }

            result = facRek(n - 1) * n;
            return result;
        }
    }

    public static int gauß(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int forFac(int n) {
        int solution = 1;
        for (int i = 1; i <= n; i++) {
            solution = solution * i;
        }
        return solution;
    }
}
