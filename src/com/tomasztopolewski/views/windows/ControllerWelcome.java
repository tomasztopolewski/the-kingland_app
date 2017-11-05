package com.tomasztopolewski.views.windows;

import com.tomasztopolewski.Main;
import com.tomasztopolewski.views.windows.questions.ControllerNewGameplay;
import com.tomasztopolewski.views.windows.questions.ControllerQuestionExit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
    MenuItem menuItemNewGameplay;
    @FXML // welcome.fxml
    MenuItem menuItemLoadGameplays;
    @FXML // welcome.fxml
    MenuItem menuItemExit;

    @FXML // welcome.fxml
    static Pane pane;

    @FXML // welcome.fxml
    Label labelTitle;
    @FXML // welcome.fxml
    Label labelVersion;

    @FXML // welcome.fxml
    Button buttonLoadGameplays;
    @FXML // welcome.fxml
    Button buttonNewGameplay;
    @FXML // welcome.fxml
    Button buttonExit;


    // stage odpowiedzialny za widok loadGameplays oraz interpetacja pliku fxml'owa dla widoku loadGameplays.fxml
    public static Stage loadGameplaysStage = new Stage();
    public Parent loadGameplaysRoot;

    // stage odpowiedzialny za widok questionExit oraz interpetacja pliku fxml'owa dla widoku questionExit.fxml
    public static Stage questionExitStage = new Stage();
    public Parent questionExitRoot;

    // stage odpowiedzialny za widok questionExit oraz interpetacja pliku fxml'owa dla widoku questionExit.fxml
    public static Stage newGameplayStage = new Stage();
    public Parent newGameplayRoot;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**** WIDOK OKNA LOADGAMEPLAYS.FXML / com.tomasztopolewski.views.windows.ControllerLoadGameplays
         * Generowanie obiektów odpowiedzialnych za poprawne wyświetlanie okna
         * obsługi rozpoczętych rozgrywek.
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

        /**** WIDOK OKNA QUESTIONEXIT.FXML / com.tomasztopolewski.views.windows.questions.ControllerQuestionExit
         * Generowanie obiektów odpowiedzialnych za poprawne wyświetlanie okno
         * potwierdzającego wyjście z gry.
         */

        try {
            questionExitRoot = FXMLLoader.load(getClass().getResource("questions/questionExit.fxml"));
            questionExitStage.setTitle(Main.nameOfGame);
            questionExitStage.setScene(new Scene(questionExitRoot, ControllerQuestionExit.widthQuestionExitView, ControllerQuestionExit.heightQuestionExitView));
            questionExitStage.setResizable(false);
            questionExitStage.sizeToScene();
            questionExitStage.setAlwaysOnTop(true);
        } catch (IOException e) {
            ControllerMain.runMessageError("ERROR: Nie można załadować widoku okna 'questionExit'.");
            e.printStackTrace();
        }

        /**** WIDOK OKNA NEWGAMEPLAY.FXML / com.tomasztopolewski.views.windows.questions.ControllerNewGameplay
         * Generowanie obiektów odpowiedzialnych za poprawne wyświetlanie okna
         * z generującego nowego gracza i przypisującego go do królestwa.
         */
        try {
            newGameplayRoot = FXMLLoader.load(getClass().getResource("questions/newGameplay.fxml"));
            newGameplayStage.setTitle(Main.nameOfGame);
            newGameplayStage.setScene(new Scene(newGameplayRoot, ControllerNewGameplay.widthNewGameplayView, ControllerNewGameplay.heightNewGameplayView));
            newGameplayStage.setResizable(false);
            newGameplayStage.sizeToScene();
            newGameplayStage.setAlwaysOnTop(true);
        } catch (IOException e) {
            ControllerMain.runMessageError("ERROR: Nie można załadować widoku okna 'newGameplay'.");
            e.printStackTrace();
        }



        /**** OBSŁUGA WIDOKU KONTROLERA
         * Obsługa początkowego okna.
         */
        // generowanie label z tekstem
        labelVersion.setText(Main.nameOfGame + " ver." + Main.versionOfGame + " " + Main.typeVersionOfGame + " / " + Main.author);
        labelTitle.setText(Main.nameOfGame);

        // pokazuję okno z wyborem rozgrywek
        buttonLoadGameplays.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ControllerMain.closeWelcomeStage();
                showLoadGameplaysStage();
            }
        });
        // otwiera okno z konfiguracją nowej rozgrywki
        buttonNewGameplay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showNewGameplay();
            }
        });

        /* Przycisk 'buttonExit' działania poprawnie, jeśli używane są przyciski w grze.
           Każde odstępstwo (np. zamknięcie okna przez przycisk narzucony przez system)
           powoduje błędne działanie programu. Okna mogę nie być poprawne wyświetlane.
           Zabronione jest też używania (np. klikanie, zamykanie) okna kontrolującego
           widok pokazywany tym przyciskiem (questionExit). Mowa np. o użyciu przycisku
           pokazującego rozgrywki (buttonLoadGameplays - widok 'loadGameplays').
         */
        // pokazuje okno z pytanie o wyjście z gry
        buttonExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // stworzenie efektu "wygaszenia" okna
                // nie działa prawidłowo
                /*buttonLoadGameplays.setDisable(true);
                buttonNewGameplay.setDisable(true);
                buttonExit.setDisable(true);*/
                showQuestionExitStage();
            }
        });

        // pokazuję okno z wyborem rozgrywek
        menuItemNewGameplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewGameplay();
            }
        });
        // otwiera okno z konfiguracją nowej rozgrywki
        menuItemLoadGameplays.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerMain.closeWelcomeStage();
                showLoadGameplaysStage();
            }
        });
        // pokazuje okno z pytanie o wyjście z gry
        menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionExitStage();
            }
        });
    }



    /**** OBSŁUGA WIDOKÓW
     * Funkcje poniżej służą do obsługi widoków w grze.
     * Każdy widok posiada funkcje pokazującą i schowającą widok.
     * Funkcje zaczynające się od 'show' pokazuję widok, a funkcje
     * zaczynające się na "close' schowają widok.
     */
    public static void showLoadGameplaysStage() {
        if (!(loadGameplaysStage.isShowing())) {
            loadGameplaysStage.setResizable(false);
            loadGameplaysStage.sizeToScene();
            loadGameplaysStage.show();
        }
    }
    public static void closeLoadGameplaysStage() {
        if (loadGameplaysStage.isShowing()) loadGameplaysStage.close();
    }

    public static void showQuestionExitStage() {
        if (!(questionExitStage.isShowing())) {
            // okno 'welcome' zostaje nie wyświetlane jako zawsze na górze
            ControllerMain.welcomeStage.setAlwaysOnTop(false);
            questionExitStage.showAndWait();
        }
    }
    public static void closeQuestionExitStage() {
        if (questionExitStage.isShowing()) {
            // okno 'welcome' zostaje wyświetlane jako zawsze na górze
            ControllerMain.welcomeStage.setAlwaysOnTop(true);
            questionExitStage.close();
        }
    }

    public static void showNewGameplay() {
        if (!(newGameplayStage.isShowing())) {
            // okno 'welcome' zostaje nie wyświetlane jako zawsze na górze
            ControllerMain.welcomeStage.setAlwaysOnTop(false);
            newGameplayStage.showAndWait();
        }
    }
    public static void closeNewGameplay() {
        if (newGameplayStage.isShowing()) {
            // okno 'welcome' zostaje wyświetlane jako zawsze na górze
            ControllerMain.welcomeStage.setAlwaysOnTop(true);
            newGameplayStage.close();
        }
    }



}
