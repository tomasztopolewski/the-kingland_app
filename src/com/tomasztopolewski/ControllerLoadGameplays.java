package com.tomasztopolewski;

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
    Button buttonBackward;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonBackward.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerMain.showWelcomeStage();
                ControllerWelcome.closeLoadGameplaysStage();
        }
        });

    }
}
