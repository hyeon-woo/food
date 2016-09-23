package last.controller;

import cronian.project.model.pjJoinUpdate;
import cronian.project.model.pjOrdermodel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @date 2016-09-21.
 * @author hj
 */
public class orderController {
    @FXML Button choiceBtn;
    @FXML Button cancelBtn;
    @FXML ImageView Main;
    private pjJoinUpdate pj;
    private pjOrdermodel pjor;



    public void choice(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/payment.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage)choiceBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            paymentController pc = login.getController();
            pc.senddata(pj,pjor);
            stage.setTitle("결제 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void cancel(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/main/foodin.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("메인 페이지");
            MainloginController mlc = login.getController();
            mlc.senddata(pj);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


    public void gomain(Event event) {
        Alert confirm = new Alert(
                Alert.AlertType.CONFIRMATION
        );
        confirm.setTitle("확인");
        confirm.setHeaderText(null);
        confirm.setContentText("결제를 취소하시겠습니까?");

        ButtonType okbtn = new ButtonType(
                "네", ButtonBar.ButtonData.OK_DONE
        );
        ButtonType nobtn = new ButtonType(
                "아니오", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirm.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get() == okbtn) {
            goMain();

        }else event.consume();;

    }


    public void goMain() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodin.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            MainloginController mlc = loader.getController();
            mlc.senddata(pj);
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void menu1(ActionEvent event) {
        pjor = new pjOrdermodel("1","1","notyet","","menudeppend",5000,"","3");
    }

    public void menu2(ActionEvent event) {
        pjor = new pjOrdermodel("1","2","notyet","","menudeppend",8000,"","3");
    }

    public void senddata(pjJoinUpdate result) {
        pj = result;
    }
}

