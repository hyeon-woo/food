package last.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController implements Initializable {
    @FXML    private Button Menu;
    @FXML    private ImageView Main;
    @FXML    private Button Howwork;
    @FXML    private Button Seemenu;
    @FXML private Button join;
    @FXML private Button logoutBtn;

    @FXML
    private Label JoinMember;
    @FXML
    private Button Apply;
    @FXML
    private Label Apply2;
    @FXML
    private Button Login;

    @FXML
    private BorderPane main;

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

    public void goOrder(ActionEvent event) {
            Alert confirm = new Alert(
                    Alert.AlertType.CONFIRMATION
            );
            confirm.setTitle("확인");
            confirm.setHeaderText(null);
            confirm.setContentText("로그인 상태가 아닙니다 로그인 하시겠습니까??");

            ButtonType okbtn = new ButtonType(
                    "네", ButtonBar.ButtonData.OK_DONE
            );
            ButtonType nobtn = new ButtonType(
                    "아니오", ButtonBar.ButtonData.CANCEL_CLOSE);

            confirm.getButtonTypes().setAll(okbtn, nobtn);{

        }

            Optional<ButtonType> result = confirm.showAndWait();
            if (result.get() == okbtn) {
                gologin();

            }else event.consume();;


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




    public void goMenu1(ActionEvent event)throws Exception{
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menunoimage.fxml"));
        main.getChildren().clear();
        main.getChildren().add( sub );
    }


    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodout.fxml"
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
                "/fxml/maker/maker.fxml"
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
                "/fxml/menu/menu.fxml"
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

    }






    public void gologin() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/order/getstart.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Apply2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("login");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}