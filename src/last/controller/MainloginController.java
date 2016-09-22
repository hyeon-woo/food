package last.controller;

import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by java on 2016-09-19.
 */
public class MainloginController implements Initializable {
    @FXML    private Button Menu;
    @FXML    private ImageView Main;
    @FXML    private Button Howwork;
    @FXML    private Button Seemenu;
    @FXML    private Button Apply;
    @FXML private Button join;
    @FXML private Button loginBtn;



    private pjJoinUpdate pj;


    public void goOrder(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../view/order/order.fxml")
        );
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Apply.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Order");

            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goJoin(Event event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("../view/order/joinmember.fxml")  );
        try {
            Parent root = loader.load();
            Stage stage = (Stage) join.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("JoinMember");

            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void gologin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource( "../view/order/getstart.fxml" ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) loginBtn.getScene().getWindow();
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
            Stage stage = (Stage) Menu.getScene().getWindow();
            stage.setScene(new Scene(root1));
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
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

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
            Stage stage = (Stage) Howwork.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void boxgoMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/last/view/menu/menu1a.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Seemenu.getScene().getWindow();
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
                "/last/view/menu/menu1a.fxml"
        ));


    }

    public void senddata(pjJoinUpdate result) {
        pj = result;
        join.setText(pj.getName());
    }

}
