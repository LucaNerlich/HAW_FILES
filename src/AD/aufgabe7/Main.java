package AD.aufgabe7;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 7
 * main.java
 */

/**
 * Application class for our CountingSort
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Main {

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] containers;

        //Zwischenspeicher fuer die Computingtime Zaehler.
        double mittelWertK1;
        double counterK1 = 0;
        double mittelWertK2;
        double counterK2 = 0;
        double mittelWertK3;
        double counterK3 = 0;
        double mittelWertK4;
        double counterK4 = 0;
        double mittelWertK5;
        double counterK5 = 0;
        double mittelWertK6;
        double counterK6 = 0;

        //  printArrayInt(containers);
        // countingSort.sort(containers, 0, 100 000 000);

        for (int i = 0; i < 10; i++) {
            // 10^1
            long startTime;
            long endTime;
            long totalTime;

            containers = new int[10];
            fillArrayInt(containers);
            startTime = 0 + System.currentTimeMillis(); //returns Nanoseconds
            countingSort.sort(containers, 0, 1000);
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK1 += totalTime;
            System.out.println(i + " <- 10^1: " + totalTime);
        }
        for (int i = 0; i < 10; i++) {
            // 10^2
            long startTime;
            long endTime;
            long totalTime;

            containers = new int[100];
            fillArrayInt(containers);
            startTime = 0 + System.currentTimeMillis();
            countingSort.sort(containers, 0, 10000);
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK2 += totalTime;
            System.out.println(i + " <- 10^2: " + totalTime);
        }
        for (int i = 0; i < 10; i++) {
            // 10^3
            long startTime;
            long endTime;
            long totalTime;

            containers = new int[1000];
            fillArrayInt(containers);
            startTime = 0 + System.currentTimeMillis();
            countingSort.sort(containers, 0, 100000);
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK3 += totalTime;
            System.out.println(i + " <- 10^3: " + totalTime);
        }
        for (int i = 0; i < 10; i++) {
            // 10^4
            long startTime = 0;
            long endTime = 0;
            long totalTime = 0;

            containers = new int[10000];
            fillArrayInt(containers);
            startTime = 0 + System.currentTimeMillis();
            countingSort.sort(containers, 0, 1000000);

            //int containers2[] = countingSort.countingSort2(containers, 1000000);

            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK4 += totalTime;
            System.out.println(i + " <- 10^4: " + totalTime);
        }
        for (int i = 0; i < 10; i++) {
            // 10^5
            long startTime;
            long endTime;
            long totalTime;

            containers = new int[100000];
            fillArrayInt(containers);
            startTime = 0 + System.currentTimeMillis();
            countingSort.sort(containers, 0, 10000000);

            // int containers2[] = countingSort.countingSort2(containers, 10000000);

            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK5 += totalTime;
            System.out.println(i + " <- 10^5: " + totalTime);
        }

        for (int i = 0; i < 10; i++) {

            // 10^6
            long startTime;
            long endTime;
            long totalTime;

            containers = new int[1000000];
            fillArrayInt(containers);
            startTime = System.currentTimeMillis();
            countingSort.sort(containers, 0, 100000000);

            //int containers2[] = countingSort.countingSort2(containers, 100000000);

            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK6 += totalTime;
            System.out.println(i + " <- 10^6: " + totalTime);
        }
        mittelWertK1 = counterK1 / 10;
        System.out.println("Mittelwert 10^1: " + mittelWertK1);

        mittelWertK2 = counterK2 / 10;
        System.out.println("Mittelwert 10^2: " + mittelWertK2);

        mittelWertK3 = counterK3 / 10;
        System.out.println("Mittelwert 10^3: " + mittelWertK3);

        mittelWertK4 = counterK4 / 10;
        System.out.println("Mittelwert 10^4: " + mittelWertK4);

        mittelWertK5 = counterK5 / 10;
        System.out.println("Mittelwert 10^5: " + mittelWertK5);

        mittelWertK6 = counterK6 / 10;
        System.out.println("Mittelwert 10^6: " + mittelWertK6);
    }

    private static void fillArray(Container[] containers) {
        for (int i = 0; i < containers.length; i++) {
            int rndm = (int) (Math.random() * (100 * i)); //800 - 700
            containers[i] = new Container(rndm, "name" + (i));
        }
    }

    private static void printArray(Container[] containers) {
        System.out.println("####### AUSGABE #######");
        for (int i = 0; i < containers.length; i++) {
            System.out.print(containers[i].getName());
            System.out.print(": " + containers[i].getKey());
            System.out.println();
        }
    }

    private static void fillArrayInt(int[] containers) {
        for (int i = 0; i < containers.length; i++) {
            int rndm = (int) (Math.random() * (100 * i)); //800 - 700
            containers[i] = rndm;
        }
    }

    private static void printArrayInt(int[] containers) {
        System.out.println("####### AUSGABE #######");
        for (int i = 0; i < containers.length; i++) {
            System.out.print(containers[i]);
            System.out.println();
        }
    }
}
