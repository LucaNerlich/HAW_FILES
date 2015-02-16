package PR1.aufgabe5.textverarbeitung;

/**
 * Praktikum WIPR1, WS 2013/2014
 * Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 5, Aufgabe 2
 * Vorlage.java
 * Version 1.0
 * Zweck: Darstellung eines Textverarbeitungssystems
 */

class Absatz {
    /* -------- Objektvariablen -------- */
    private String eingabeText = "";

    /**
     * -------- Konstruktoren --------
     * Ein Absatz erh�lt bei Erzeugung seinen gesamten Text in Form eines Strings
     * Trennung vom Text erfolgt mit genau einem Leerzeichen, keine Newline-Zeichen
     * Beim Speichern vom Text f�hrendes und anschlie�endes Leerzeichen bereinigen.
     */
    public Absatz(String eingabeText) {
        this.eingabeText = eingabeText;
        this.leerzeichenEntfernen();
    }

    /* -------- Setter und Getter-Methoden -------- */
    public String getEingabeText() {
        return eingabeText;
    }

    public String setEingabeText(String neu) {
        this.eingabeText = neu;

        return this.eingabeText;
    }

    /**
     * Diese Methode soll den gesamten Absatz-Text als String ohne Newlines
     * zur�ckliefern.
     */
    public String getText() {
        return this.eingabeText;
    }

    /**
     * Liefert die Anzahl der W�rter im Text
     */
    public int getWortAnzahl() {
    /*
    int zaehler = 0;
    int anzahlLeerzeichen = 0;
    char leerzeichen = 32;
    
    for (int j = 0;j < eingabeText.lastIndexOf(32);j++ ) {
    getWort(j);
    anzahlLeerzeichen++;
    } // end of for
    return anzahlLeerzeichen;
    */
        int zaehler = 1;

        for (int i = 0; i < eingabeText.length(); i++) {
            char leerzeichen = 32;

            if (eingabeText.charAt(i) == leerzeichen) { //vergleicht die Chars mit 32 und z�hlt so die Leerzeichen
                zaehler++;
            } // end of if
        } // end of for

        return zaehler;
    }

    /**
     * Diese Methode soll in den Absatz-Text Newlines einf�gen und den gesamten
     * Text als einen String zur�ckliefern, Newlines so einf�gen, dass maximale
     * Anzahl an Zeichen pro Zeile den Wert maxBreite nicht �bersteigt. Wenn das
     * Wort nicht in die Zeile passt, anstatt Leerzeichen Newline als Trennzeichen.
     * maxBreite darf nur �berschritten werden wenn das Wort l�nger ist als maxBreite
     */
    public String getText(int maxBreite) {
        int zaehler = 0;
        int wortanzahl = getWortAnzahl();
        int index = 0;

        String zeile = "";
        String textausgabe = "";

        while (zaehler < wortanzahl) {
            String einzelnesWort = getWort(index); //liest jedes einzelne Wort ein
            zaehler++;

            int wortLaenge = einzelnesWort.length();
            index = index + wortLaenge + 1; // index = Wortlaenge+Leerzeichen f�r den n�chsten Schleifen Durchlauf

            // Wenn die Anzahl der Zeichen in der Zeile die maxBreite �bersteigt f�gen wir Newline ein
            if ((zeile.length() + wortLaenge + 1) > maxBreite) {
                textausgabe = textausgabe + zeile + "\n";
                zeile = ""; //Zeile wird wieder "geleert"
            }

            zeile = zeile + " " + einzelnesWort;
            zeile = zeile.trim();
        }

        textausgabe = textausgabe + zeile;

        return textausgabe;
    }

    /**
     * Liefert den Teilstring ab der startPosition (als Index) bis zum n�chsten
     * Leerzeichen oder Textende
     */
    public String getWort(int startPosition) {
        String findeWort = eingabeText.substring(startPosition); //Teilstring ab startPosition bis zum Ende liefern
        char leerzeichen = 32; //Zeichencode f�r Leerzeichen
        int indexleerzeichen = findeWort.indexOf(leerzeichen); //Index der ersten Fundstelle von Leerzeichen liefern
        int stringLaenge = eingabeText.trim().length(); //Leerzeichen am Anfang und Ende entfernen und die L�nge des gesamten Strings ermitteln
        int endPosition = startPosition + indexleerzeichen; // Ermittelt die Postion der W�rter

        if (indexleerzeichen == -1) { // bei -1 wurde kein Leerzeichen gefunden
            endPosition = stringLaenge;
        }

        // liefert den Teilstring (Wort vom Textteil) von der StartPosition bis zur endPosition
        String neuerText = eingabeText.substring(startPosition, endPosition);

        return neuerText;
    }

  /* -------- Hauptmethoden -------- */

    /**
     * Repr�sentiert das Objekt
     */
    public String toString() {
        return "Der Folgende Text wird bearbeitet: " + "\r\n" + getText() + "\r\n" +
                "Die Anzahl der W�rter betr�gt: " + getWortAnzahl() + "\r\n";
    }

  /* -------- Hilfsmethoden -------- */

    /**
     * Methode entfernt die ersten und letzten Leerzeichen
     */
    private String leerzeichenEntfernen() {
        String getrimterText = setEingabeText(eingabeText.trim());

        return getrimterText;
    }
}
