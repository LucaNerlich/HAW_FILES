package PR1.aufgabe4.amoebe;

/* AmoebeTest.java
   Version 1.0
   Vorlesung Programmieren 1 HAW Hamburg
   Autor: M. Huebner
   Zweck: Testklasse Praktikum 4 Teilaufgabe 1
   */
class AmoebeTest {
    /* Testklasse fuer Amoeben */
    public static void main(String[] args) {
        Amoebe m0 = new Amoebe(false); //Erzeugt ein Objekt mit dem Namen m0 und uebergibt das Argument weiblich=false
        Amoebe m1 = new Amoebe(false);
        Amoebe w2 = new Amoebe(true);
        Amoebe w3 = new Amoebe(true);
        Amoebe m4;             // Es wird die Referenzvariable deklariert
        Amoebe w5;

        teste(!m0.istWeiblich());
        teste(w2.istWeiblich());
        teste(m1.getGroesse() == 1);
        teste(w3.getGroesse() == 1);

        m1.futter();
        w3.futter();

        for (int i = 1; i < 10; i++) {
            m0.futter();          //m0 wurde auf 10 gefuettert
            m1.hunger();      //schrumpfen bis zur 1
            w2.futter();
            w3.hunger();
        }

        teste(m0.getGroesse() == 10); //die Werte aus der For-Schleife testen
        teste(m1.getGroesse() == 1);
        teste(w2.getGroesse() == 10);
        teste(w3.getGroesse() == 1);

        m4 = m0.teile();      //Die Referenzvariable m4 wird durch die Methode teile mit Leben gefuellt wenn die amoebe groesser als 5 ist
        //Der Rueckgabewert der Methode teile wird M4 zugewiesen, dabei handelt es sich um ein neues Objekt
        teste(m0.getGroesse() == 5);
        teste(m4.getGroesse() == 5);
        teste(!m4.istWeiblich());

        w5 = m1.teile();
        teste(m1.getGroesse() == 1);
        teste(w5 == null);

        w5 = m0.vereinige(m1); //dem Objekt w5 wird m0 und m1 zusammen zugewiesen
        teste(w5 == null);

        w5 = m1.vereinige(w3);
        teste(w5 == null);

        w5 = m0.vereinige(w2);
        teste(w5.getGroesse() == 1);
        teste(w5.istWeiblich());

        boolean kampf = w2.angreifen(w5);
        teste(!kampf);

        kampf = m0.angreifen(m4);
        teste(!kampf);

        m1.futter();
        m1.futter();

        kampf = m0.angreifen(m1);

        teste(kampf);
        teste(m0.getGroesse() == 7);
        teste(m1.getGroesse() == 1);

        m1.futter();
        m1.futter();
        kampf = m1.angreifen(m0);
        teste(kampf);
        teste(m0.getGroesse() == 9);
        teste(m1.getGroesse() == 1);

        System.out.println("Tests durchlaufen. Falls bisher keine Exception zu sehen war, ist alles ok!");

        m0.ausgeben();
        m1.ausgeben();
        w2.ausgeben();
        w3.ausgeben();
        m4.ausgeben();
        w5.ausgeben();
    }

    public static void teste(boolean bedingung) {
    /* Ausgabe des StackTrace, wenn die Bedingung false ist */
        if (!bedingung) {
            new Exception("Testfehler gefunden").printStackTrace();
        }
    }
}
