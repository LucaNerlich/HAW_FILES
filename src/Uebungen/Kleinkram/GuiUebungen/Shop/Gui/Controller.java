package Uebungen.Kleinkram.GuiUebungen.Shop.Gui;

import Uebungen.Kleinkram.GuiUebungen.Shop.Lager;
import Uebungen.Kleinkram.GuiUebungen.Shop.Produkte.Produkt;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;


/**
 * Created by lnerlich on 17.02.2015.
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
        Stage stage = new Stage();
        String name = Dialogs.showInputDialog(stage, "Bitte geben Sie den Namen des Produkts ein:", "Name", "");
        String anzahl = Dialogs.showInputDialog(stage, "Bitte geben Sie die gewünschte Anzahl ein:", "Anzahl", "");
        int anzahlconfirmed = 0;

        try {
            int preisInt = Integer.parseInt(anzahl);
            anzahlconfirmed = preisInt;
        } catch (NumberFormatException e) {
        }
        if (anzahlconfirmed != 0) {
            Produkt produkt = new Produkt(name, 1);
            lager.addProdukt(produkt, anzahlconfirmed);
        } else {
            Dialogs.showErrorDialog(stage, "Falsche Eingabe!");
        }
    }

    @Override
    public void printLagerbestand() {
        System.out.println(lager.getInventarWert());
    }
}
