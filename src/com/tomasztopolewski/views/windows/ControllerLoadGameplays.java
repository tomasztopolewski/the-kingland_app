package com.tomasztopolewski.views.windows;

import com.tomasztopolewski.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLoadGameplays implements Initializable {

    public final static String versionOfControllerLoadGameplays = "1.00.000";

    @FXML // loadGameplays.fxml
    Label labelTitleAndVersion;

    @FXML // loadGameplays.fxml
    Button buttonBackward;

    @FXML // loadGameplays.fxml
    Button buttonNewGameplay;

    @FXML // loadGameplays.fxml
    Button buttonGameplay1;

    @FXML // loadGameplays.fxml
    Button buttonGameplay2;

    @FXML // loadGameplays.fxml
    Button buttonGameplay3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**** OBSŁUGA WIDOKU KONTROLERA
         * Obsługa okna z rozgrywkami.
         */
        labelTitleAndVersion.setText(Main.nameOfGame + " ver." + Main.versionOfGame + " " + Main.typeVersionOfGame);
        buttonGameplay1.setDisable(false);

        buttonBackward.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerMain.showWelcomeStage();
                ControllerWelcome.closeLoadGameplaysStage();
        }
        });

        buttonGameplay1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Kliknęto mnie :D");
            }
        });

    }
}
