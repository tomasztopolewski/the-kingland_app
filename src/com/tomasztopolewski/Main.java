package com.tomasztopolewski;

import com.tomasztopolewski.preparation.Installation;
import com.tomasztopolewski.views.windows.ControllerCriticalError;
import com.tomasztopolewski.views.windows.ControllerMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public final static String nameOfGame = "The KingLand";
    public final static String versionOfGame = "1.01.120";
    public final static String typeVersionOfGame = "DEV";
    public final static String author = "Tomasz Topolewski";


    @Override
    public void start(Stage mainStage) throws Exception {
        // algorytm sprawdzający poprawność instalacji gry zaimplementowany w klasę 'Installation' w metodę tej klasy 'isIsOkay()'
        if (new Installation().isIsOkay()) {
            Parent mainRoot = FXMLLoader.load(getClass().getResource("views/windows/main.fxml"));
            mainStage.setTitle(nameOfGame);
            //primaryStage.setResizable(false); // powoduje presuwanie się części layout'u
            mainStage.setScene(new Scene(mainRoot, ControllerMain.widthMainView, ControllerMain.heightMainView));
            //mainStage.getIcons().add(new Image("img/icon_v0-1.png"));
            //mainStage.show();
        } else {
            Parent mainRoot = FXMLLoader.load(getClass().getResource("views/windows/criticalError.fxml"));
            mainStage.setTitle(nameOfGame);
            //primaryStage.setResizable(false); // powoduje presuwanie się części layout'u
            mainStage.setScene(new Scene(mainRoot, ControllerCriticalError.widthCriticalErrorView, ControllerCriticalError.heightCriticalErrorView));
            mainStage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void exitPlatform() {
        Platform.exit();
    }
}
