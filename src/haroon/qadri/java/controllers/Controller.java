package controllers;

import javafx.stage.Stage;

public abstract class Controller {

    protected MainController mainController;
    protected Stage stage;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
