package last.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * @date 2016-09-21.
 * @author hj
 */
public class paymentController {
    @FXML
    Button payBtn;
    @FXML Button paychangeBtn;
    @FXML
    ImageView Main;


    public void goPay(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/complete.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage)payBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("주문완료 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void paychange(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/order.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) paychangeBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("주문 페이지");
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
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




}







