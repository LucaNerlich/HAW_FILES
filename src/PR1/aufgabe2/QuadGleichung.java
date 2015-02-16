package PR1.aufgabe2;/* QuadGleichung.java
   Praktikum WIPR1, WS 2013/2014
   Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
           Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
   Version 1.0
   Vorlesung Programmieren 1 HAW Hamburg
   Autor: Luca Nerlich & Daniel Sommerlig
   Zweck: QuadratischeGleichung (Aufgb. 4)
*/

/*
Idee:
     3 Variablen (a,b,c) einlesen. Diese in der vorgegebenen Formel verarbeiten.
     Bibliotheksmethoden verwenden (pow.xy -> hoch / ^(1/2) -> Wurzel)
*/
class QuadGleichung {
    public static void main(String[] args) {
        //  Deklaration der Variablen
        double ergebnisPLUS;
        double ergebnisMINUS;
        double zwischenErg = 0;

        //Benutzereingabe
        double a = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(null,
                "Bitte Wert a:"));

        if (a <= 0) {
            System.out.println("Bitte geben Sie a groeßer als 0 an!");
        } else {
            double b = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(null,
                    "Bitte Wert b:"));
            double c = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(null,
                    "Bitte Wert c:"));
            System.out.println("Ihre Eingaben sind: " + "a= " + a + ", " + "b= " + b +
                    ", " + "c= " + c);
            System.out.println();

      /*
      x = ((-b +- wurzel(b^2 - 4ac))/ 2a;
      */

            //Zwischenvariablen einfuegen
            double diskriminante;

            //Anweisung zur Berechnung
            diskriminante = (b * b) - (4 * a * c);

            System.out.println("Die Diskriminante ist: " + diskriminante);
            System.out.println();

            if (diskriminante > 0) {
                System.out.println("Es gibt '2' reelle Loesungen.");
                System.out.println();
            } // end of if
            else if (diskriminante == 0) {
                System.out.println("Es gibt '1' reelle Loesung.");
                System.out.println();
            } // end of if-else
            else if (diskriminante < 0) {
                System.out.println("Es gibt keine reelle Loesung!");
                System.out.println();
            } // end of if-else

            zwischenErg = (Math.pow(b, 2) - (4 * a * c));

            //Berechnung fortfuehren und positives Ergebnis ausgeben
            ergebnisPLUS = (-b + (Math.pow(zwischenErg, 0.5))) / 2;
            System.out.println("Das Ergebnis mit '+' ist: " + ergebnisPLUS);

            System.out.println();

            //Berechnung fortfuehren und negatives Ergebnis ausgeben
            ergebnisMINUS = (-b - (Math.pow(zwischenErg, 0.5))) / 2;
            System.out.println("Das Ergebnis mit '-' ist: " + ergebnisMINUS);
            System.out.println();
        }
    }
}