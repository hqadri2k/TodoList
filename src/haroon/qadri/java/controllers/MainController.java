package controllers;

import main.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {

    @FXML
    private AnchorPane mainPane;

    private FXMLLoader loader;

    private Stage stage;

    // Controllers

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadDisplay();
        } catch(Exception ie){
            ie.printStackTrace();
        }
    }

    /*private void loadHome() throws IOException {
        Pair<Node, Object> node = loadNode(Config.HOME);
        homeController = (HomeController) node.getValue();
        homeController.setMainController(this);
        mainPane.getChildren().add(node.getKey());
    }*/

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void loadDisplay() throws IOException {
        Pair<Node, Object> display = loadNode(Config.DISPLAY);
        mainPane.getChildren().add(display.getKey());
        DisplayController dp = (DisplayController) display.getValue();
        dp.setMainController(this);
        dp.setup();

    }

    public Pair<Node, Object> loadNode(String fxml) throws IOException {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Node root = loader.load();
        Pair<Node, Object> node = new Pair<Node, Object>(root, loader.getController());
        return node;
    }

    /**
     * Loads a scene and sets the stage to display that scene and then proceeds to return the controller of the scene loaded
     * to allow for controlling e.g. (calling methods, setting variables) of that scene.
     * @param fxml
     * @return controller of loaded scene
     * @throws IOException
     */
    public Object loadScene(String fxml) throws IOException {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        String css = this.getClass().getResource("/res/stylesheet.css").toExternalForm();
        root.getStylesheets().add(css);
        mainPane.getChildren().add(root);
        return loader.getController();
    }

    public Stage getStage() {
        return stage;
    }
}
