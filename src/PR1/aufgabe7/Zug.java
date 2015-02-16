package PR1.aufgabe7;

/**
 * Praktikum WIPR1, WS 2013/2014 Gruppe: Luca Nerlich
 * (Lucasteffen.Nerlich@haw-hamburg.de) Daniel Sommerlig
 * (Daniel.Sommerlig@haw-hamburg.de) Aufgabe: Aufgabenblatt 4 - OOP Einleitung -
 * Aufgabe 7 Zug.java Version 1.0 Zweck: Die Klasse Zug mit Hilfe von Exceptions weiter absichern
 */

public class Zug {
    private Lokomotive lok;

    /**
     * Konstruktor
     *
     * @param lok
     * @throws ZugException
     */
    public Zug(Lokomotive lok) throws NullPointerException, ZugException {

        if (lok.getName() == null) {
            throw new NullPointerException(
                    "Es muss ein Objekt uebergeben werden! (NullPointerException)");
        }
        if (lok.getErsterWagen() != null) {
            throw new ZugException(
                    "An der �bergebenen Lok h�ngen bereits Wagen (nicht zul�ssig, weil fehleranf�llig).");
        }
        this.lok = lok;
    }

    /**
     * Gibt das object der lok zur�ck.
     *
     * @return lok
     */
    public Lokomotive getLok() {
        return lok;
    }

    /**
     * Startmethode um einen Wagen hinzuzuf�gen.
     *
     * @param neuerWagen
     */

    public void addWagen(Wagen neuerWagen) throws NullPointerException, ZugException {

        if (neuerWagen == null) {
            throw new NullPointerException("Es muss ein Objekt uebergeben werden! (NullPointerException)");
        }
        if (neuerWagen.getNaechsterWagen() != null) {
            throw new ZugException("Der �bergebene Wagen hat noch weitere Nachfolger (nicht zul�ssig, weil fehleranf�llig).");
        }
        lok.addWagen(neuerWagen);
    }


    /**
     * Gibt den ersten Wagen zur�ck, der entfernt werden soll.
     *
     * @return
     */
    public Wagen removeErstenWagen() {
        return lok.removeErstenWagen();
    }

    /**
     * Gibt den letzten Wagen zur�ck. Hilfsmethode.
     *
     * @return
     */
    private Wagen getLetztenWagen() {
        return lok.getLetztenWagen();
    }

    /**
     * Haengt die Wagen des zweiten Zugs ab und haengt sie an den ersten Zug
     * hinten an.
     *
     * @param andererZug
     */
    public void appendZug(Zug andererZug) throws NullPointerException,
            ZugException {

        if (andererZug == null) {
            throw new NullPointerException(
                    "Es muss ein Objekt uebergeben werden! (NullPointerException)");
        }
        if (andererZug == this) {
            throw new ZugException(
                    "Derselbe Zug kann nicht hinten an gehaengt werden!");
        }
        if (lok.getErsterWagen() == null) {
            lok.setErsterWagen(andererZug.getLok().getErsterWagen());
        } // end of if
        else {
            getLetztenWagen().setNaechsterWagen(
                    andererZug.getLok().getErsterWagen());
        } // end of if-else
    }

    /**
     * Ausgabe / Teste Klasse. Gibt alle Zuege und Wagen mit Parametern aus.
     * Catch bleibt als Backup da. Falls irgendwoanders ein Fehler auftreten
     * sollten, wird er sp�testens in der Ausgabe abgefangen.
     */
    public void info() {
        try {
            System.out.println();
            System.out.println("Zug Name: " + lok.getName());
            System.out.println(lok.parameterPrint());
            System.out.println("Anzahl der Wagen im Zug: " + getWagenAnzahl());
            System.out.println("Der Zug ist " + getZugLaenge()
                    + " Einheiten lang.");
            System.out.println("Der Zug kann " + getKapazitaet()
                    + " Passagiere transportieren.");
            System.out.println("Der Zug besteht aus folgenden Wagen:");
            System.out.println(gibWagenParameter());
        } catch (NullPointerException exceptionObject) {
            System.out.println();
            System.out
                    .println("Es kann keine Ausgabe von Nichts erzeugt werden!");

            System.out.println("Stacktrace: ");
            exceptionObject.printStackTrace();
            return;
        }
    }

    /**
     * Gibt die Parameter des Wagens zurueck.
     *
     * @return parameterWagen
     */
    public String gibWagenParameter() {
        String parameterWagen = "";

        for (Wagen x = lok.getErsterWagen(); x != null; x = x
                .getNaechsterWagen()) {
            parameterWagen += x.parameterPrint();
        } // end of for

        return parameterWagen;
    }

    /**
     * Gibt die Anzahl der Wagen am Zug zurueck.
     *
     * @return anzahlDerWagen
     */
    public int getWagenAnzahl() {
        int anzahlDerWagen = 0;

        for (Wagen x = lok.getErsterWagen(); x != null; x = x
                .getNaechsterWagen()) {
            anzahlDerWagen++;
        } // end of for

        return anzahlDerWagen;
    }

    /**
     * Gibt die Laenge des Zuges zurueck.
     *
     * @return laengeDesZuges
     */
    public int getZugLaenge() {
        int laengeDesZuges = lok.getLaenge();

        for (Wagen x = lok.getErsterWagen(); x != null; x = x
                .getNaechsterWagen()) {
            laengeDesZuges += x.getLaenge();
        } // end of for

        return laengeDesZuges;
    }

    /**
     * Gibt die Passagierkapazitaet zurueck.
     *
     * @return kapazitaetDesZuges
     */
    public int getKapazitaet() {
        int kapazitaetDesZuges = 0;

        for (Wagen x = lok.getErsterWagen(); x != null; x = x
                .getNaechsterWagen()) {
            kapazitaetDesZuges += x.getPassagierkapazitaet();
        } // end of for

        return kapazitaetDesZuges;
    }
  
  /*
  * public void testeInfo(){ System.out.println(); try {
  * System.out.println("Erster Wagen: " +
  * lok.getErsterWagen().parameterPrint()); } catch (Exception e) {
  * System.out.println("Es gibt keinen ersten Wagen!"); }
  * 
  * try { System.out.println("N�chster Wagen: " +
  * lok.getErsterWagen().getNaechsterWagen() .parameterPrint()); } catch
  * (Exception e) { System.out.println("Es gibt keinen n�chsten Wagen!"); }
  * 
  * }
  */
  
  /*
  * // public void info():
  * 
  * try { while (lok.getErsterWagen().getNaechsterWagen() != null) {
  * System.out.println(lok.getErsterWagen().parameterPrint());
  * lok.removeErstenWagen(); } // end of while
  * 
  * System.out.println(lok.getErsterWagen().parameterPrint()); } catch
  * (Exception e) { System.out.println("Es gibt keinen ersten Wagen!"); }
  */
}
