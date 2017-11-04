package com.tomasztopolewski.views.windows.questions;

import com.tomasztopolewski.Main;
import com.tomasztopolewski.views.windows.ControllerMain;
import com.tomasztopolewski.views.windows.ControllerWelcome;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuestionExit implements Initializable {

    public final static String versionOfQuestionExit = "1.00.000";
    public final static double heightQuestionExitView = 125.0, widthQuestionExitView = 335.0;


    @FXML
    Button buttonYes;

    @FXML
    Button buttonNo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonYes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerMain.closeWelcomeStage();
                ControllerWelcome.closeLoadGameplaysStage();
                ControllerWelcome.closeQuestionExitStage();
            }
        });

        buttonNo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerWelcome.closeQuestionExitStage();
            }
        });
    }
}
