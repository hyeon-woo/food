package last.controller;

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
public class Menu1aController extends MainController {
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
    @FXML
    private ImageView Main;
    @FXML
    private Button Howwork;

    @FXML
    private Button Login;
    public void gologin(ActionEvent event) {


        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/order/getstart.fxml"
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
    public void goMaker(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/maker/maker.fxml"
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
                "/fxml/menu/menu1a.fxml"
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
                "/fxml/menu/menu2.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) picture2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu2");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMenu2a(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/menu2a/menu2.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) picture2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu2");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodout.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmain");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
