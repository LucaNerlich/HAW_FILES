package AD.aufgabe6;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6
 * Main.java
 */

/**
 * Application class for our Quicksort
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Main {

    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        Container[] containers = new Container[10];

        /*
        System.out.println("####### AUSGABE #######");
        for (int i = 0; i < containers.length; i++) {
            System.out.print(containers[i].getName());
            System.out.print(": " + containers[i].getDataNumber());
            System.out.println();
        } */

        double mittelWertK1;
        double counterK1 = 0;

        System.out.println("####### SORTIERT PIVOT : ENDE #######");
        for (int i = 0; i < 10; i++) {
            // 10^1
            long startTime;
            long endTime;
            long totalTime;

            fillArray(containers);
            quicksort.setChoosePivotMethod(0);

            startTime = 0 + System.currentTimeMillis(); //returns Nanoseconds

            quicksort.sort(containers);

            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            counterK1 += totalTime;

            //System.out.println("SWAP COUNTER: " + quicksort.getCounter());
            quicksort.setCounter(0);
            //System.out.println();
            System.out.println(i + " : " + totalTime);

        }

        mittelWertK1 = counterK1 / 10;
        System.out.println("Mittelwert 10^1: " + mittelWertK1);
        /*
        System.out.println("####### SORTIERT PIVOT : MITTE #######");
        fillArray(containers);
        quicksort.setChoosePivotMethod(1);
        quicksort.sort(containers);
        System.out.println("SWAP COUNTER: " + quicksort.getCounter());
        quicksort.setCounter(0);
        System.out.println();

        System.out.println("####### SORTIERT PIVOT : RANDOM #######");
        fillArray(containers);
        quicksort.setChoosePivotMethod(2);
        quicksort.sort(containers);
        System.out.println("SWAP COUNTER: " + quicksort.getCounter());
        quicksort.setCounter(0);
        System.out.println();
        */

    }

    /**
     * generates random integers for our Array
     *
     * @param containers -> Container you want to fill up.
     */
    private static void fillArray(Container[] containers) {
        for (int i = 0; i < containers.length; i++) {
            int rndm = (int) (Math.random() * containers.length);
            containers[i] = new Container(rndm, "name" + i);
            ;
        }
    }
}
