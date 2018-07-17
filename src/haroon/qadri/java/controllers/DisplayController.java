package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import main.Config;

import java.io.IOException;

public class DisplayController extends Controller {

    private int tasks = 0;

    @FXML
    private Button newTask;

    @FXML
    private VBox tasksBox;

    @FXML
    private void addNewTask() {
       Pair<Node, Object> task = null;
        try {
            task = mainController.loadNode(Config.MINI_TASK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = task.getKey();
        tasksBox.getChildren().add(node);
        MiniTaskController mtc = (MiniTaskController) task.getValue();
        mtc.setMainController(mainController);
        mtc.setMiniTaskNode(node);
        tasks++;
        mtc.setDisplayController(this);
    }

    @FXML
    public void deleteTask(Node node) {
        tasksBox.getChildren().remove(node);
    }


}
