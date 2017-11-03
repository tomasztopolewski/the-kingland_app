package com.tomasztopolewski;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerWelcome implements Initializable {

    public final static String versionOfControllerWelcome = "1.00.000";
    public final static double heightWelcomeView = 500.0, widthWelcomeView = 700.0;

    @FXML // welcome.fxml
    static Pane pane;

    @FXML // welcome.fxml
    Label labelTitle;

    @FXML // welcome.fxml
    Label labelVersion;

    @FXML // welcome.fxml
    Button buttonLoadGameplays;


    // stage odpowiedzialny za widok loadGameplays
    public static Stage loadGameplaysStage = new Stage();
    // interpetacja pliku fxml'owa dla widoku loadGameplays.fxml
    public Parent loadGameplaysRoot;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**************************************************************************************
         *****  WIDOK OKNA LOADGAMEPLAYS.FXML / com.tomasztopolewski.ControllerLoadGameplays
         * Generowanie obiektów odpowiedzialnych za poprawne wyświetlanie okna
         * obsługa rozpoczętych rozgrywek - widok 'loadGameplaysStage'.
         * Aby pokazać okno należy wywołać funkcje:
         * 'showLoadGameplaysStage()'.
         * Aby schować okno nalezy wywołać funkcje:
         * 'closeLoadGameplaysStage()'.
         */
        try {
            loadGameplaysRoot = FXMLLoader.load(getClass().getResource("loadGameplays.fxml"));
            loadGameplaysStage.setTitle(Main.nameOfGame);
            loadGameplaysStage.setScene(new Scene(loadGameplaysRoot, ControllerWelcome.widthWelcomeView, ControllerWelcome.heightWelcomeView));
            loadGameplaysStage.setResizable(false);
            loadGameplaysStage.sizeToScene();
            loadGameplaysStage.setAlwaysOnTop(true);
        } catch (IOException e) {
            ControllerMain.runMessageError("ERROR: Nie można załadować widoku okna 'loadGameplays'.");
            e.printStackTrace();
        }


        /**************************************************************************************
         *****  OBSŁUGA WIDOKU MAIN.FXML
         * Obsługa początkowego okna.
         */
        labelVersion.setText(Main.nameOfGame + " ver." + Main.versionOfGame + " " + Main.typeVersionOfGame + " / " + Main.author);
        labelTitle.setText(Main.nameOfGame);

        buttonLoadGameplays.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerMain.closeWelcomeStage();
                showLoadGameplaysStage();
            }
        });
    }

    /******************************************************************************************
     *****  OBSŁUGA WIDOKÓW
     * Funkcje poniżej służą do obsługi widoków w grze.
     * Każdy widok posiada funkcje pokazującą i schowającą widok.
     * Funkcje zaczynające się od 'show' pokazuję widok, a funkcje
     * zaczynające się na "close' schowają widok.
     */
    public static void showLoadGameplaysStage() {
        if (!(loadGameplaysStage.isShowing())) loadGameplaysStage.show();
    }
    public static void closeLoadGameplaysStage() {
        if (loadGameplaysStage.isShowing()) loadGameplaysStage.close();
    }



}
