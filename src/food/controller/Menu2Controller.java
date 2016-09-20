package food.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class Menu2Controller {
    @FXML
    private Button Menu;


    public void goMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu/menu1a.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Menu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu1");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
