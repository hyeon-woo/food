package last.controller;

import javafx.application.Platform;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by hyeon-woo on 2016-09-23.
 */
public class ManuMainController implements Initializable {


    @FXML    private Button Seemenu;
    @FXML private Button join;
    @FXML private Button logoutBtn;
@FXML private Pane center;

@FXML private Button Apply2;


    @FXML
    private Button Menu;
    @FXML
    private ImageView Main;
    @FXML
    private Button Howwork;

    @FXML
    private Button Login;

    public void firstPage(ActionEvent event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/FirstPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );
    }

    public void secondPage(ActionEvent event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/SecondPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );
    }

    public void thirdPage(ActionEvent event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/ThirdPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );

    }
    public void fouthpage(ActionEvent event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/FourthPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
                goOrder();

            }else event.consume();;


        }

    public void goOrder() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/order/order.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Apply2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

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


  /*  public void goMenu2(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/menu/menu2.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)picture2.getScene().getWindow();
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
            Stage stage = (Stage)picture2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu2");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/

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


    public void goOrder1(ActionEvent actionEvent) {

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

        confirm.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = confirm.showAndWait();

        if (result.get() == okbtn) {
            goOrder();

        } else actionEvent.consume();

    }
}
