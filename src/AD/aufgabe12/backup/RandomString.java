package AD.aufgabe12.backup;

import java.util.Random;

/**
 * Created by CR on 07.12.14.
 */
public class RandomString {

    private final String randomString;

    /**
     * constructor
     */
    public RandomString(int length) {
        this.randomString = generateString(length);
    }

    /**
     * method to create a random String
     *
     * @param length length of the String (quantity of chars)
     * @return random String
     */
    public String generateString(int length) {
        String alphabet =
                new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz "); //9
        int n = alphabet.length(); //10

        String result = new String();
        Random r = new Random(); //11

        for (int i = 0; i < length; i++) //12
            result = result + alphabet.charAt(r.nextInt(n)); //13

        return result;
    }

    /**
     * method to represent the String object
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.randomString;
    }
}
