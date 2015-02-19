package Uebungen.Kleinkram.GuiUebungen.MouseTracking;

import javafx.stage.Stage;

/**
 * Created by lnerlich on 17.02.2015.
 */
public class Controller implements ControllerInterface {

    private View view;

    public Controller() {
        this.view = new View(this);
    }

    public void show(Stage primaryStage) {
        view.show(primaryStage);
    }
}
