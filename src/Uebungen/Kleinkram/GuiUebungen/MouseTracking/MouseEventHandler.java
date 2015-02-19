package Uebungen.Kleinkram.GuiUebungen.MouseTracking;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lnerlich on 17.02.2015.
 */
public class MouseEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSceneX() + ", " + event.getSceneY());
    }
}
