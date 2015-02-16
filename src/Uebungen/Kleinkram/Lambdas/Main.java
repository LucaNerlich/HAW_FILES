package Uebungen.Kleinkram.Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lnerlich on 13.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        // #### OLD ####

        List<String> myList = Arrays.asList("element1", "element2", "element3");
        List<Integer> myListInt = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        for (String element : myList) {
            System.out.println (element);
        }

        // #### NEW WITHOUT LAMBDA ####

        myList.forEach(new Consumer<String>() {
            public void accept(String element) {
                System.out.println(element);
            }
        });

        // #### NEW WITH LAMBDA ####

        myList.forEach((String element) -> System.out.println(element));
        myListInt.forEach((Integer element) -> System.out.println(element));
    }
}
