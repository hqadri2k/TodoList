package main;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setWidth(Config.WIDTH);
        primaryStage.setHeight(Config.HEIGHT);
        primaryStage.setResizable(Config.RESIZABLE);
        primaryStage.show();
        loadMainPane(primaryStage);
    }

    public void loadMainPane(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            loader.setLocation(getClass().getResource(Config.MAIN));
            root = loader.load();
            MainController mainController = loader.getController();
            mainController.setStage(stage);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
}
