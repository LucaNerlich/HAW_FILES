package Uebungen.Kleinkram.GuiUebungen.MouseTracking;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by lnerlich on 16.02.2015.
 */
public class Main extends Application {
    // Tastaturinput testen
    // objekt mit maus steuern, ball bewegt sich paralelle zur maus
    // eventuell auf zeit durch nen Labyrinth

    public static void main(String[] args) {
        try {
            launch(args); //wird zum Starten der Anwendung verwendet
        } catch (Exception e) {
            System.out.println("Fehler beim Starten der Anwendung! =(");
        }
    }

    public void start(Stage primaryStage) {
        Controller controller = new Controller();
        controller.show(primaryStage); //Der Controller zeigt die GUI an
    }
}
