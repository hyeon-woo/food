package food.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class Menu1aController {
    @FXML
    private VBox picture1;
    @FXML
    private VBox picture2;
    @FXML
    private VBox picture3;
    @FXML
    private VBox picture4;
    @FXML
    private Button Menu;


    public void goMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu/menu1a.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Menu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu1");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMenu2(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu/menu2.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) picture1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu2");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMenu2a(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu2a/menu2.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) picture1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu2");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}