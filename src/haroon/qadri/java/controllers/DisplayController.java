package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import main.Config;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayController extends Controller {

    private int tasks = 0;

    @FXML
    private Button newTask;

    @FXML
    private VBox tasksBox;

    @FXML
    private VBox newTaskInput;

    @FXML
    private void newTask() {
        newTaskInput.setVisible(true);
    }

    public void hideNewTaskInfo() {
        newTaskInput.setVisible(false);
    }

    public void addNewTask(String name, String description) {
        hideNewTaskInfo();
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
        mtc.setTaskName(name);
        mtc.setDescription(description);
        tasks++;
        mtc.setDisplayController(this);
    }

    @FXML
    public void deleteTask(Node node) {
        tasksBox.getChildren().remove(node);
    }

    public void setup() {
        Pair<Node, Object> nodes = null;
        try {
            nodes = mainController.loadNode(Config.ADD_TASK);
            newTaskInput.getChildren().add(nodes.getKey());
            AddTaskController atc = (AddTaskController) nodes.getValue();
            atc.setDisplayController(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
