package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTaskController extends Controller {

    private DisplayController displayController;

    @FXML
    private Button add;
    @FXML
    private Button cancel;
    @FXML
    private TextField name;
    @FXML
    private TextField description;

    @FXML
    private void addTask() {
        displayController.addNewTask(name.getText(), description.getText());
        clear();
    }

    @FXML
    private void cancelTask() {
        clear();
        displayController.hideNewTaskInfo();
    }

    public void setDisplayController(DisplayController displayController) {
        this.displayController = displayController;
    }

    private void clear() {
        name.setText("");
        description.setText("");
    }
}
