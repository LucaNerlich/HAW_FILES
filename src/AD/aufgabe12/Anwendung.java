package AD.aufgabe12;

import java.util.ArrayList;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 12
 * Anwendung.java
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Anwendung {
    public static void main(String[] args) {
        Optimierung optimierung = new Optimierung();
        DynProg dynProg = new DynProg();

        long startTime;
        long endTime;
        long totalTime;

        Aktie legoland = new Aktie("Legoland", 33, 0.7f);
        Aktie monsters = new Aktie("Monsters Inc.", 38, -0.1f);
        Aktie dieFirma = new Aktie("Die Firma", 94, 0.6f);
        Aktie pangea = new Aktie("Pangea", 62, 0.8f);
        Aktie enterprise = new Aktie("Enterprise AG", 28, 0.2f);
        Aktie stern = new Aktie("Stern des Suedens", 20, 1.1f);
        Aktie astra = new Aktie("Astra", 58, -0.05f);
        Aktie maritim = new Aktie("Maritim e.V.", 48, 0.4f);
        Aktie[] aktien = new Aktie[8];

        ArrayList<Aktie> aktienListe = new ArrayList<Aktie>();
        aktienListe.add(new Aktie("Legoland", 33, 0.7F));
        aktienListe.add(new Aktie("Mosters Inc.", 38, -0.1F));
        aktienListe.add(new Aktie("Die Firma", 94, 0.6F));
        aktienListe.add(new Aktie("Pangea", 62, 0.8F));
        aktienListe.add(new Aktie("Enterprise AG", 28, 0.2F));
        aktienListe.add(new Aktie("Stern des Suedens", 20, 1.1F));
        aktienListe.add(new Aktie("Astra", 58, -0.05F));
        aktienListe.add(new Aktie("Maritim e.V.", 48, 0.4F));

        aktien[0] = legoland;
        aktien[1] = monsters;
        aktien[2] = dieFirma;
        aktien[3] = pangea;
        aktien[4] = enterprise;
        aktien[5] = stern;
        aktien[6] = astra;
        aktien[7] = maritim;

        //int preis = (int) (legoland.getPreis1Year() + dieFirma.getPreis1Year() + stern.getPreis1Year());
        //System.out.println(preis);
        //optimierung.printList();

        startTime = 0 + System.currentTimeMillis();

        // System.out.println(optimierung.knapsack(150, aktien));

        ArrayList<Aktie> loesungen = optimierung.calcKnapsackRec(150, aktienListe);
        //ArrayList<Aktie> loesungen = optimierung.calcKnapsackRec(100, generateAktienList(5));
        // optimierung.knapsack(5500, generateAktien(50));
        //ystem.out.println(dynProg.knapsackDynProg(5500, generateAktien(100000)));

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Totaltime optimierung: " + totalTime);

        int finalValue = 0;
        for (Aktie aktie : loesungen) {
            System.out.println(aktie.getName());
            System.out.println(aktie.getPreis());
            System.out.println(aktie.getPerformance());
            System.out.println(aktie.getPreis1Year());
            finalValue += aktie.getPreis1Year();
            System.out.println("");
        }

        //hier elemente aus loesungen printen
        System.out.println("Final Value: " + finalValue);
        System.out.println("ENDE");
    }

    private static Aktie[] generateAktien(int anzahlAktien) {
        Aktie[] aktienGen = new Aktie[anzahlAktien];
        Optimierung optimierung2 = new Optimierung();

        for (int i = 0; i < anzahlAktien; i++) {
            aktienGen[i] = new Aktie("Aktie" + i, (int) (Math.random() * (i) + 1), (int) (Math.random() * (13) - 2) * 1f);
            //System.out.println(aktienGen[i].getName());
            //System.out.println(aktienGen[i].getPerformance());
            //System.out.println(aktienGen[i].getPreis());
            //System.out.println(aktienGen[i].getPreis1Year());
        }
        return aktienGen;
    }

    private static ArrayList<Aktie> generateAktienList(int anzahlAktien) {
        ArrayList<Aktie> aktienListe = new ArrayList<>();

        for (int i = 0; i < anzahlAktien; i++) {
            aktienListe.add(new Aktie("Aktie" + i, (int) (Math.random() * (i) + 1), (int) (Math.random() * (13) - 2) * 1f));
        }
        return aktienListe;

    }
}


