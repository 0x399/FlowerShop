package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void switchtowarehouse(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("warehouse.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}