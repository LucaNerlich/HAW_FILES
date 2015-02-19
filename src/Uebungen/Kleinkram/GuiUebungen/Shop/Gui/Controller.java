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

        int anzahlconfirmed = getAnzahl();
        float preisconfirmed = getPrice();

        if (anzahlconfirmed != 0) {
            Produkt produkt = new Produkt(resultName.toString(), preisconfirmed);
            lager.addProdukt(produkt, anzahlconfirmed);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Falsche Eingabe!");
            alert.showAndWait();
        }
    }

    private int getAnzahl() {
        int anzahlconfirmed = 0;

        TextInputDialog dialogAnzahl = new TextInputDialog("anzahl");
        dialogAnzahl.setTitle("Add Produkt");
        dialogAnzahl.setContentText("Anzahl: ");

        //nur in dieser Reihenfolge kann ich nen int Wert uebergeben 0o
        Optional<String> resultAnzahl = dialogAnzahl.showAndWait();
        String intresult = dialogAnzahl.getResult();


        try {
            int preisInt = Integer.parseInt(intresult);
            anzahlconfirmed = preisInt;
        } catch (NumberFormatException e) {
            System.out.println("PARSING FEHLER");
        }

        return anzahlconfirmed;
    }

    private float getPrice() {
        float priceconfirmed = 0f;

        TextInputDialog dialogAnzahl = new TextInputDialog("price");
        dialogAnzahl.setTitle("Add Produkt");
        dialogAnzahl.setContentText("Preis: ");

        //nur in dieser Reihenfolge kann ich nen int Wert uebergeben 0o
        Optional<String> resultAnzahl = dialogAnzahl.showAndWait();
        String intresult = dialogAnzahl.getResult();


        try {
            float preisFloat = Float.parseFloat(intresult);
            priceconfirmed = preisFloat;
        } catch (NumberFormatException e) {
            System.out.println("PARSING FEHLER");
        }

        return priceconfirmed;
    }

    @Override
    public void printLagerbestand() {
        lager.printLagerbestand();
    }

    @Override
    public void printInventarWert() {
        System.out.println(lager.getInventarWert());
    }


}
