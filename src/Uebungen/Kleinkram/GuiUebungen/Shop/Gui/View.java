package Uebungen.Kleinkram.GuiUebungen.Shop.Gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by lnerlich on 17.02.2015.
 */
public class View {
    private final ControllerInterface controller;
    private final ContentBuilder contentBuilder;
    public Scene scene;

    public View(final ControllerInterface controller) {
        this.controller = controller;
        contentBuilder = new ContentBuilder();

        BorderPane borderPane = new BorderPane();
        scene = new Scene(borderPane);

        Button addProdukt = contentBuilder.createButton("Add produkt");
        borderPane.setBottom(addProdukt);
        addProdukt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.addProdukt();
            }
        });

    }

    public void show(Stage stage) {
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
}
