package edu.ntnu.idatt2001;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI gui = new GUI();
        gui.start(primaryStage);
    }

}