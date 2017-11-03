package com.tomasztopolewski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public final static String nameOfGame = "The KingLand";
    public final static String versionOfGame = "1.00.000";
    public final static String typeVersionOfGame = "DEV";
    public final static String author = "Tomasz Topolewski";


    @Override
    public void start(Stage mainStage) throws Exception {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("main.fxml"));
        mainStage.setTitle(nameOfGame);
        //primaryStage.setResizable(false); // powoduje presuwanie się części layout'u
        mainStage.setScene(new Scene(mainRoot, ControllerMain.widthMainView, ControllerMain.heightMainView));
        //mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}