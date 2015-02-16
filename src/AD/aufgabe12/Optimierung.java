package AD.aufgabe12;

import java.util.ArrayList;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 12
 * Optimierung.java
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Optimierung {


    public int knapsack(int rucksackGr, Aktie[] aktien) {
        ArrayList<Aktie> solutions = new ArrayList<>();
        return knapsackHelper(aktien.length - 1, rucksackGr, aktien, solutions);
    }

    private int knapsackHelper(int i, int rucksackGr, Aktie[] aktien, ArrayList<Aktie> solutions) {
        //http://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming
        //http://ranger.uta.edu/~kosmopo/cse2320/lectures/05-Recursion_DynamicProgramming.pdf
        //http://stackoverflow.com/questions/19285021/recursive-knapsack-java
        //http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
        //http://stackoverflow.com/questions/20342386/printing-out-result-in-0-1-knapsack-recursive-brute-force


        //wenn i leer
        if (i < 0) {
            return 0;
        }

        //aktueller Wert ist groeßer als der Rucksack
        if (aktien[i].getPreis() > rucksackGr) {
            return knapsackHelper(i - 1, rucksackGr, aktien, solutions);

            //wenn nicht, das maximum der anderen Werte finden.
        } else {
            int preWithSize = solutions.size();
            int with = knapsackHelper(i - 1, rucksackGr - aktien[i].getPreis(), aktien, solutions) + (int) aktien[i].getPreis1Year();

            int preWithoutSize = solutions.size();
            int without = knapsackHelper(i - 1, rucksackGr, aktien, solutions);

            if (with > without) {
                if (solutions.size() > preWithoutSize) {
                    //http://stackoverflow.com/questions/2289183/why-is-javas-abstractlists-removerange-method-protected
                    solutions.subList(preWithoutSize, solutions.size()).clear();
                }
                solutions.add(aktien[i]);

                System.out.println("###");
                for (int x = 0; x < solutions.size(); x++) {
                    System.out.println(solutions.get(x).getName());
                }

                return with;
            } else {
                if (preWithoutSize > preWithSize) {
                    solutions.subList(preWithSize, preWithoutSize).clear();
                }
                System.out.println("###");
                for (int x = 0; x < solutions.size(); x++) {
                    System.out.println(solutions.get(x).getName());
                }
                return without;
            }
            // return Math.max(with, without);
        }
    }

    private int berechneArraySumme(ArrayList<Aktie> aktien) {
        int summe = 0;
        if (aktien == null) {
            return 0;
        }
        for (Aktie aktie : aktien) {
            summe += aktie.getPreis1Year();
        }

        return summe;
    }

    public ArrayList<Aktie> calcKnapsackRec(int rucksackGr, ArrayList<Aktie> aktien) {
        return knapsackRec(aktien.size() - 1, rucksackGr, aktien);
    }

    private ArrayList<Aktie> knapsackRec(int index, int rucksackGr, ArrayList<Aktie> aktien) {
        if (index < 0) {
            return null;
        }
        if (aktien.get(index).getPreis() > rucksackGr) {
            return knapsackRec(index - 1, rucksackGr, aktien);
        } else {
            ArrayList<Aktie> nichtNehmen = knapsackRec(index - 1, rucksackGr, aktien);
            ArrayList<Aktie> nehmen = knapsackRec(index - 1, rucksackGr - aktien.get(index).getPreis(), aktien);
            int a = berechneArraySumme(nichtNehmen);
            int b = berechneArraySumme(nehmen) + (int) aktien.get(index).getPreis1Year();
            if (b > a) {
                if (nehmen == null) {
                    nehmen = new ArrayList<Aktie>();
                }
                nehmen.add(aktien.get(index));
                return nehmen;
            }
            return nichtNehmen;
        }
    }
}

