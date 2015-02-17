package Uebungen.Kleinkram.GuiGedöns;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by lnerlich on 17.02.2015.
 */
public class View {
    private final Controller controller;
    public Scene scene;

    public View(final Controller controller) {
        this.controller = controller;

        BorderPane borderPane = new BorderPane();
        scene = new Scene(borderPane);
        borderPane.addEventHandler(MouseEvent.MOUSE_MOVED, new MouseEventHandler());

    }

    public void show(Stage stage) {
        stage.setTitle("TEST");
        stage.setScene(scene);
        stage.show();
    }
}
