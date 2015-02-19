package Uebungen.Kleinkram.GuiUebungen.Shop.Gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        GridPane gridPane = new GridPane();
        scene = new Scene(borderPane);

        borderPane.setBottom(gridPane);

        Text bgTitle = new Text("Shop! - JavaFX");
        bgTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        borderPane.setTop(bgTitle);

        Button addProdukt = contentBuilder.createButton("Add produkt");
        gridPane.add(addProdukt, 0, 0);
        addProdukt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.addProdukt();
            }
        });

        Button printLagerbestandButton = contentBuilder.createButton("Print Lagerbestand!");
        gridPane.add(printLagerbestandButton, 0, 1);
        printLagerbestandButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.printLagerbestand();
            }
        });

    }

    public void show(Stage stage) {
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
}
