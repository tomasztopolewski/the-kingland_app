package com.tomasztopolewski.views.windows;

import com.tomasztopolewski.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {

    public final static String versionOfControllerWelcome = "1.00.000";
    public final static double heightMainView = 500.0, widthMainView = 700.0;

    // stage odpowiedzialny za widok welcome
    public static Stage welcomeStage = new Stage();
    // interpetacja pliku fxml'owa dla widoku loadGameplays.fxml
    public Parent welcomeRoot;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**************************************************************************************
         *****  WIDOK OKNA LOADGAMEPLAYS.FXML / com.tomasztopolewski.views.windows.ControllerLoadGameplays
         * Generowanie obiektów odpowiedzialnych za poprawne wyświetlanie okna
         * obsługa rozpoczętych rozgrywek - widok 'loadGameplaysStage'.
         * Aby pokazać okno należy wywołać funkcje:
         * 'showLoadGameplaysStage()'.
         * Aby schować okno nalezy wywołać funkcje:
         * 'closeLoadGameplaysStage()'.
         */
        try {
            welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
            welcomeStage.setTitle(Main.nameOfGame);
            welcomeStage.setScene(new Scene(welcomeRoot, ControllerWelcome.widthWelcomeView, ControllerWelcome.heightWelcomeView));
            welcomeStage.setResizable(false);
            welcomeStage.sizeToScene();
            welcomeStage.setAlwaysOnTop(true);
            welcomeStage.show();
        } catch (IOException e) {
            ControllerMain.runMessageError("ERROR: Nie można załadować widoku okna 'welcome'.");
            e.printStackTrace();
        }

    }


    /******************************************************************************************
     *****  OBSŁUGA WIDOKÓW
     * Funkcje poniżej służą do obsługi widoków w grze.
     * Każdy widok posiada funkcje pokazującą i schowającą widok.
     * Funkcje zaczynające się od 'show' pokazuję widok, a funkcje
     * zaczynające się na "close' schowają widok.
     */
    public static void showWelcomeStage() {
        if (!(welcomeStage.isShowing())) {
            welcomeStage.setResizable(false);
            welcomeStage.sizeToScene();
            welcomeStage.show();
        }
    }
    public static void closeWelcomeStage() {
        if (welcomeStage.isShowing()) welcomeStage.close();
    }


    /******************************************************************************************
     *****  MESSAGES
     * Za pomocą poniższych funkcji można wygenerować odpowiednie wiadomości
     * dla użytkownika. Są to: informacyjna, ostrzegwcza, zawierająca błąd.
     */
    public static void runMessageInfo(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Main.nameOfGame);
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static void runMessageWarn(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Main.nameOfGame);
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static void runMessageError(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Main.nameOfGame);
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.showAndWait();
    }
}