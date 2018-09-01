package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MiniTaskController extends Controller implements Initializable {

    private String description;

    private DisplayController displayController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println(id);
    }

    private Node miniTaskNode;

    @FXML
    private Button info;

    @FXML
    private Button delete;

    @FXML
    private Label taskName;

    @FXML
    private void showTaskInfo() {

    }

    @FXML
    private void deleteTask() {
        displayController.deleteTask(miniTaskNode);
    }

    public void setDisplayController(DisplayController displayController) {
        this.displayController = displayController;
    }

    public void setMiniTaskNode(Node node) {
        miniTaskNode = node;
    }

    public void setTaskName(String name) {
        taskName.setText(name);
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void initialize() {}
}
