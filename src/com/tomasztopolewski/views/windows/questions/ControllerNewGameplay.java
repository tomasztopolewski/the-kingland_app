package com.tomasztopolewski.views.windows.questions;

import com.tomasztopolewski.views.windows.ControllerWelcome;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNewGameplay implements Initializable {

    public final static String versionOfControllerNewGameplay = "1.00.000";
    public final static double heightNewGameplayView = 280.0, widthNewGameplayView = 320.0;

    @FXML
    Button buttonSave;

    @FXML
    Button buttonCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**** OBSŁUGA WIDOKU KONTROLERA
         * Obsługa okna konfiguracji nowej rozgrywki.
         */
        buttonCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerWelcome.closeNewGameplay();
            }
        });


    }
}
