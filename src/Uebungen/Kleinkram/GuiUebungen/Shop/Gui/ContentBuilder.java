/**
 * Praktikum WIPR2, SS 2014
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4, Aufgabe 1
 * ContentBuilder.java
 */

package Uebungen.Kleinkram.GuiUebungen.Shop.Gui;

import javafx.collections.FXCollections;
import javafx.scene.control.*;


/**
 * Erzeugt Inhalte fuer die Gridpane etc
 * Vereinfachte Erstellung der GuiObjekte
 */
public class ContentBuilder {

    public ContentBuilder() {

    }

    /**
     * returned einen ToggleButton
     * <p>
     * text -> Inhalt des Buttons
     *
     * @return ToggleButton
     */
    public ToggleButton createToggleButton(String text) {
        ToggleButton tBtn = new ToggleButton();
        tBtn.setText(text);

        return tBtn;
    }

    /**
     * returned eine Combobox
     * <p>
     * vararg -> "x1", "x2" ... "xn"
     *
     * @return ComboBox
     * javaFX hat zus�tzliche Collection-Klassen
     */
    public ComboBox<String> createComboBox(String... content) {
        ComboBox<String> comboBox = new ComboBox<String>(
                FXCollections.observableArrayList(content));
        comboBox.setValue(content[1]);

        return comboBox;
    }

    /**
     * returned eine CheckBox /unchecked
     * <p>
     * text
     *
     * @return ComboBox
     */
    public CheckBox createCheckBox(String text) {
        CheckBox ckBox = new CheckBox(text);
        ckBox.setSelected(false);

        return ckBox;
    }

    /**
     * returned ein TextField
     * <p>
     * text
     *
     * @return TextField
     */
    public TextField createTextField(String text) {
        TextField txField = new TextField(text);

        return txField;
    }

    /**
     * returned einen Button
     * <p>
     * text
     *
     * @return Button
     */
    public Button createButton(String text) {
        Button btn = new Button(text);

        return btn;
    }
}
