package PR1.aufgabe5.textverarbeitung;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5, Aufgabe 2
 * AbsatzTest.java
 * Version 1.0
 * Zweck: Testklasse zur Darstellung eines Textverarbeitungssystems
 */

class AbsatzTest {
    public static void main(String[] args) {
        /**
         * Das Objekt mit dem Aufgabentext erzeugen und Leerzeichen vorne und hinten einbauen.
         */
        Absatz text = new Absatz("  Der Sehnsucht entgegen, sie erleben. Wer kann das schon. Den Tr�umen entgegen, sie erleben. Wer macht das schon. Den Gef�hlen entgegen, sie erleben. Wer wagt das schon. Der Liebe entgegen, sie erleben. Wer darf das schon.  ");
        // Absatz text = new Absatz (" Wer kann das schon dasdasdas.");

        /**
         * Aufruf der toString-Methode Repr�sentiert das Objekt
         * beinhaltet text.getText() und text.getWortAnzahl()
         */
        System.out.println(text.toString());

        /**
         * Text mit der Zeichenbreite 5
         */
        System.out.println("Text mit der Zeichenbreite 5: \r\n" + text.getText(5) + "\r\n");

        /**
         * Text mit der Zeichenbreite 10
         */
        System.out.println("Text mit der Zeichenbreite 10: \r\n" + text.getText(10) + "\r\n");

        /**
         * Text mit der Zeichenbreite 20
         */
        System.out.println("Text mit der Zeichenbreite 20: \r\n" + text.getText(20) + "\r\n");

        /**
         * Text mit der Zeichenbreite 80
         */
        System.out.println("Text mit der Zeichenbreite 80: \r\n" + text.getText(80) + "\r\n");

        //text.getText(50);
        //System.out.println("Ab Startposition bis Leerzeichen oder Textende: " + text.getWort(1));


        teste(text.getWortAnzahl() == 36);
        teste(text.getEingabeText().equals("Der Sehnsucht entgegen, sie erleben. Wer kann das schon. Den Tr�umen entgegen, sie erleben. Wer macht das schon. Den Gef�hlen entgegen, sie erleben. Wer wagt das schon. Der Liebe entgegen, sie erleben. Wer darf das schon."));

        System.out.println("\r\nTests durchlaufen. Falls bisher keine Exception zu sehen war, ist alles ok!");
    }

    public static void teste(boolean bedingung) {
    /* Ausgabe des StackTrace, wenn die Bedingung false ist */
        if (!bedingung) {
            new Exception("Testfehler gefunden").printStackTrace();
        }
    }

}

