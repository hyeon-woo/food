package last.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by java on 2016-09-20.
 */
public class MakerController {

    @FXML
    private Label JoinMember;
    @FXML
    private Button Login;
    @FXML    private Button Menu;
    @FXML    private ImageView Main;
    @FXML    private Button Howwork;


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
                "/fxml/menu/menunoimage.fxml"
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

    public void gomain(ActionEvent event) {
        goMain(event);
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
                gologin(event);

            }else event.consume();;


        }



    public void gomaker(ActionEvent event) {
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

}