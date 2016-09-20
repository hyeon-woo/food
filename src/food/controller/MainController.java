package food.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController {
    @FXML
    private Button Menu;



    public void goMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu/menu1.fxml"
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