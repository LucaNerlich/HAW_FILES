package AD.aufgabe11;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 11
 * Anwendung.java
 *
 * https://computinglife.wordpress.com/2008/11/20/why-do-hash-functions-use-prime-numbers/
 * http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
 *
 * http://docs.oracle.com/javase/6/docs/api/java/lang/String.html#hashCode%28%29
 *
 * Application class for our hashing.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Anwendung {
    static String testKey;
    static String testValue;

    public static void main(String[] args) {

        long startTime;
        long endTime;
        long totalTime;

        Hashing hashing = new Hashing(1153); //primzahl x
/*
        hashing.insertKey("person1", "lucanerlich");
        hashing.insertKey("person2", "lucanerlich2");

        System.out.println();
        System.out.println(hashing.findByKey("person1"));
        System.out.println(hashing.findByKey("person2"));
        System.out.println();

        */

// ..
        generateRandomValues(1000, hashing);

        startTime = 0 + System.currentTimeMillis();

        System.out.println(testValue);
        System.out.println(hashing.findByKey(testKey));

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Totaltime findByKey: " + totalTime);

        System.out.println("ENDE");
    }

    private static void generateRandomValues(int anzahlValues, Hashing hashing) {
        int randomNumber;
        String value;
        String key;
        String uuid;
        int test = (int) Math.random() * anzahlValues;
        for (int i = 0; i < anzahlValues; i++) {
            char c = '\0'; //empty char
            String x = "" + c;
            for (int j = 0; j < 4; j++) {
                randomNumber = (int) (Math.random() * 255);
                c = (char) randomNumber;
                x += c;
            }

            //saves test values for findkey
            if (i == test) {
                testKey = x;
                testValue = x;
            }
            //System.out.println(x);
            //  uuid = UUID.randomUUID().toString();
            // System.out.println("uuid = " + uuid);
            // randomNumber = (int)(Math.random() * hashing.getArraySize());
            // value = "value" + randomNumber;
            // key = "key" + randomNumber;

            hashing.insertKey(x, x);
        }
    }
}
