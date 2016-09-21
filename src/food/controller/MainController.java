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
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController implements Initializable{
    @FXML
    private Button Menu;
    @FXML
    private ImageView Main;
    @FXML
    private Button Howwork;
    @FXML
    private Button Seemenu;
    @FXML
    private Button Login;
    public void gologin(ActionEvent event) {


        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/login/getstart.fxml"
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
    private FXMLLoader loader1;

    public void goMenu1(ActionEvent event) {

        try {
            Parent root1 = loader1.load();
            Stage stage = (Stage)Menu.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.setTitle("foodmenu1");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/food.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMaker(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/maker/maker.fxml"
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

    public void boxgoMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/menu/menu1a.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Seemenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu1");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loader1 = new FXMLLoader(getClass().getResource(
                "../view/menu/menu1a.fxml"
        ));
    }


}