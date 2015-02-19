package Uebungen.Kleinkram.GuiUebungen.Shop.Gui;

import Uebungen.Kleinkram.GuiUebungen.Shop.Lager;
import Uebungen.Kleinkram.GuiUebungen.Shop.Produkte.Produkt;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;


/**
 * Created by lnerlich on 17.02.2015.
 * https://jdk8.java.net/download.html
 */
public class Controller implements ControllerInterface {

    Lager lager;
    private View view;

    public Controller(Lager lager) {
        this.view = new View(this);
        this.lager = lager;
    }

    public void show(Stage primaryStage) {
        view.show(primaryStage);
    }

    @Override
    public void addProdukt() {

        // ATM anscheinend unmoeglich integers zu parsen

        TextInputDialog dialogName = new TextInputDialog("produkt");
        dialogName.setTitle("Add Produkt");
        dialogName.setContentText("Name: ");
        Optional<String> resultName = dialogName.showAndWait();

        TextInputDialog dialogAnzahl = new TextInputDialog("anzahl");
        dialogAnzahl.setTitle("Add Produkt");
        dialogAnzahl.setContentText("Anzahl: ");

        //nur in dieser Reihenfolge kann ich nen int Wert uebergeben 0o
        Optional<String> resultAnzahl = dialogAnzahl.showAndWait();
        String intresult = dialogAnzahl.getResult();

        //resultName.ifPresent(name -> System.out.println("Your name: " + name));

        int anzahlconfirmed = 0;

        try {
            int preisInt = Integer.parseInt(intresult);
            anzahlconfirmed = preisInt;
        } catch (NumberFormatException e) {
            System.out.println("PARSING FEHLER");
        }
        if (anzahlconfirmed != 0) {
            Produkt produkt = new Produkt(resultName.toString(), 1f);
            lager.addProdukt(produkt, anzahlconfirmed);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Falsche Eingabe!");
            alert.showAndWait();
        }
    }

    @Override
    public void printLagerbestand() {
        System.out.println(lager.getInventarWert());
    }
}
