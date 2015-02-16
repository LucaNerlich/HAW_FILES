package PR1.aufgabe1;

import java.io.*;
import java.util.Arrays;

/**
 * MHPrettyPrint Version 1.1
 *
 * @author Prof. Dr. Martin H�bner
 *         Zweck: Eine Java-Sourcecode-Datei mit
 *         Einr�ckungen nach { } versehen
 */

public class MHPrettyPrint {

    public static final boolean TEST_MODE = false;
    public static final String OUTFILE_NAME = "Output.java";

    private static int indentation = 3;     // Anzahl Leerzeichen f�r EINE Einr�ckung
    private static String inLine;           // Aktuelle Eingabezeile
    private static String outLine;          // Aktuelle Ausgabezeile
    private static boolean commentMode = false;
    private static boolean lineContinuationMode = false;

    /**
     * @param Dateiname einer Java-Source-Datei
     * @param OPTIONAL  Anzahl Leerzeichen an Einr�ckung (indentation)
     * @return Eine Datei Output.java im selben Verzeichnis (wird ggf.
     * �berschrieben)
     */
    public static void main(String[] args) {
      /* Variablen */
        String inFileName;
        BufferedReader inFile;
        BufferedWriter outFile;
        int bracketDiff = 0; // Differenz Anzahl { - Anzahl }
        int curIndent = 0;
        int commentDiff = 0; // Differenz Anzahl /* - Anzahl */
        int lineCounter = 0;


      /* Begr��ung */
        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("Willkommen zum einfachen PrettyPrinter der Vorlesung Programmieren 1!");

        if (args.length == 0) {
            System.out.println("-------> Bitte beim Aufruf den Dateinamen der Eingabedatei angeben!");
            return;
        }

      /* Eingabedatei �ffnen */
        inFileName = args[0];
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
        } catch (FileNotFoundException e) {
            System.out.println("-------> Fehler: Die Datei " + inFileName + " gibt es nicht, sorry!");
            return;
        }
        if (inFileName.equals(OUTFILE_NAME)) {
            System.out.println("-------> Fehler: Eingabedatei " + OUTFILE_NAME + " ist identisch mit der Ausgabedatei");
            return;
        }

      /* Optionales 2. Argument: indentation-Konstante */
        if (args.length > 1) {
            indentation = Integer.parseInt(args[1]);
            if (indentation < 1 || indentation > 10) {
                indentation = 3;
            }
        }

      /* Ausgabedatei �ffnen */
        try {
            outFile = new BufferedWriter(new FileWriter(OUTFILE_NAME));
        } catch (IOException e) {
            System.out.println("-------> Fehler: Auf die Datei " + OUTFILE_NAME + " konnte nicht zugegriffen werden!");
            return;
        }

      /* Statistik */
        long startTime = System.nanoTime();
        long usedNanos = 0;

      /* Jede Zeile lesen und verarbeiten */
        try {
            System.out.print("Die Datei " + inFileName + " wird verarbeitet ..");
            while ((inLine = inFile.readLine()) != null) {
                lineCounter++;
                commentDiff = countMatches(inLine, "/*")
                        - countMatches(inLine, "*/");
                if (commentMode) {
                    setOutLine(curIndent);
                    if (commentDiff < 0) {
                        commentMode = false;
                        curIndent = curIndent - 3;
                    }
                } else {
               /* kein CommentMode */
                    if (commentDiff > 0 && inLine.trim().startsWith("/*")) {
                        commentMode = true;
                  /* Aktuelle Zeile erzeugen, danach nach rechts einr�cken */
                        setOutLine(curIndent);
                        curIndent = curIndent + 3;
                    } else {
                  /* Nach { und } suchen */
                        bracketDiff = countMatches(inLine, "{")
                                - countMatches(inLine, "}");
                        if (bracketDiff > 0) {
                            setOutLine(curIndent);
                            curIndent = curIndent + indentation * bracketDiff;
                        } else {
                            if (bracketDiff < 0) {
                                curIndent = curIndent + indentation * bracketDiff; // diff ist NEGATIV!
                                setOutLine(curIndent);
                            } else {
                        /* Klammerzahl gleich */
                                if (inLine.indexOf("{") > inLine.indexOf("}")) {
                        /* schlie�ende vor �ffnender Klammer, z.B. } else { */
                                    curIndent = curIndent - indentation;
                                    setOutLine(curIndent);
                                    curIndent = curIndent + indentation;
                                } else {
                                    setOutLine(curIndent);
                                }
                            }
                        }
                    }
                }
                tout(outLine);  // Testausgabe
                outFile.write(outLine);
                outFile.newLine();
            }

         /* Dateien schlie�en */
            inFile.close();
            outFile.close();
        } catch (IOException e) {
            System.out.println("-------> Fehler beim Dateizugriff!");
            e.printStackTrace();
            return;
        }
      /* Verabschiedung */
        usedNanos = System.nanoTime() - startTime;
        System.out.println(".. fertig! \nDie Ausgabedatei ist: " + OUTFILE_NAME);
        System.out.println("Es wurden " + lineCounter + " Zeilen in "
                + String.format("%.5f Sekunden verarbeitet!", (double) usedNanos / 1000000000.0));
        System.out.println("************************************************************************");
    }

    private static void setOutLine(int spaces) {
      /* Bei unvollst�ndiger Anweisung 2. Teil zus�tzlich einr�cken (Fortsetzung)*/
        if (lineContinuationMode && !singleBracket()) {
            spaces = spaces + indentation + 3;
        }
      /* Erzeugen einer Ausgabezeile */
        outLine = createSpaces(spaces) + inLine.trim();
      /* Pr�fen, ob die Zeile unvollst�ndig ist, damit in der
         N�CHSTEN Zeile fortgsetzt wird (Zusatzeinr�ckung einer Zeile) */
        lineContinuationMode = checkContinuationMode(outLine);
    }

    private static boolean checkContinuationMode(String line) {
      /* R�ckgabe true, wenn eine Anweisung fortgesetzt wird */
        boolean result = true;

        line = line.trim();
        if (commentMode ||
                line.length() == 0 ||
                line.endsWith("{") ||
                line.endsWith("}") ||
                line.endsWith(";") ||
                line.endsWith(":") ||
                line.endsWith("*/") ||
                line.indexOf("//") >= 0) {
            result = false;
        }
        return result;
    }


    private static int countMatches(String str, String searchString) {
      /* R�ckgabe: Die Anzahl des Vorkommens von searchString in str */
        int lastIndex = 0;
        int count = 0;

        if (str != null && str.length() > 0) {
            while (lastIndex >= 0) {
                lastIndex = str.indexOf(searchString, lastIndex);
                if (lastIndex >= 0) {
                    count++;
                    lastIndex++;
                }
            }
        }
        return count;
    }

    private static String createSpaces(int len) {
      /* Leerzeichen-String der L�nge len zur�ckgeben */
        char[] spaces = new char[len];
        Arrays.fill(spaces, ' ');
        return new String(spaces);
    }

    private static boolean singleBracket() {
      /* True, wenn die Eingabezeile mit einer
         �ffnenden geschweiften Klammer beginnt. */
        if (inLine.trim().startsWith("{"))
            return true;
        else
            return false;
    }


    private static void tout(String out) {
        if (TEST_MODE) {
            System.out.println(out);
        }
    }
}
