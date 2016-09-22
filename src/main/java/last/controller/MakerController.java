package last.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class MakerController {
    @FXML
    private ImageView Main;
    @FXML
    private Button Menu;
    @FXML
    private Label JoinMember;
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
    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodout.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Main");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goMenu1(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/menu/menu.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Menu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu ");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public void goJoinMember(Event event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/order/joinmember.fxml")
        );
        try {
            Parent root = loader.load();
            Stage stage = (Stage) JoinMember.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("JoinMember");

            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
