package last.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class Menu2Controller extends MainController {
    @FXML
    private Button Menu;
    @FXML
    private ImageView Main;
    @FXML
    private Button Howwork;
    @FXML
    private Button detail;

    @FXML
    private Button Login;
    public void gologin(ActionEvent event) {


        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/order/getstart.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Login.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("login");

            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void godetail(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/menu/menu3.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)detail.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("detail");

            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }




    public void goMaker(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/maker/maker.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Howwork.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void goMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/menu/menu1a.fxml"
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

    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/main/foodout.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmain");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}