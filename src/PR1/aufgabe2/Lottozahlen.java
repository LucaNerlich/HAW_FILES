package PR1.aufgabe2;/* Lottozahlen.java
   Gruppe: Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
           Luca Nerlich (Luca.Nerlich@haw-hamburg.de)
   Version 1.0
   Vorlesung Programmieren 1 HAW Hamburg
   Autor: L. Nerlich & D. Sommerlig
   Zweck: PR1 P Aufg. 2 - 3.
*/

/*
Entwurf:

        1.
        Var x initialisieren
        und in diese dann per for schleife nach einander 6 werte schreiben.
        Die Werte ermittle ich per Math.random. Nach rechere gibt diese Methode double zurueck.
        Also muss noch per (int) die Ausgabe in einen Integer Wert gewandelt werden.

        2.
        Math.random 6x ausfuehren und den Wert jedesmal in einer neuen Variablen speichern. Diese 6 Variablen dann in einer Zeile Ausgeben.
*/
class Lottozahlen {
    public static void main(String[] args) {
        // 1.
        int x;

        for (int i = 1; i <= 6; i++) {
            x = (int) (Math.random() * 50); //(int) wandelt double in int
            System.out.println(x);
        } // end of for

        System.out.println();

        // 2.
        int a = (int) (Math.random() * 50);
        int b = (int) (Math.random() * 50);
        int c = (int) (Math.random() * 50);
        int d = (int) (Math.random() * 50);
        int e = (int) (Math.random() * 50);
        int f = (int) (Math.random() * 50);

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);

        // 3. Variante mit Array (Entwurf)
    /*
    int ar[] = [a, b, c, d, e];
    for(int i = 0, i < ar.length(), i++)
    {
    system.out.printf("%d ", ar[i]);
    }
    system.out.println();
    */
    }
}
