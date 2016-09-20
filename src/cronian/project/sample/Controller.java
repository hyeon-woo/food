package cronian.project.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class Controller {
    @FXML
    private AnchorPane login;

    public void mapagego(ActionEvent event) throws IOException {

        Stage stage = (Stage)login.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../kbh/managerindexpage.fxml"));
        Parent root = loader.load();

        stage.setTitle("managerpage");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
