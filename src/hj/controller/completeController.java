package hj.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by java on 2016-09-21.
 */
public class completeController {

    @FXML
    Button logoutBtn;
    @FXML
    Button confirmBtn;



    public void goConfirm(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/orderConfirm.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) confirmBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("주문확인 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goLogout(ActionEvent event) throws Exception {

        Alert cfrm = new Alert(Alert.AlertType.CONFIRMATION);
        cfrm.setContentText("로그아웃을 하시겠습니까?");

        ButtonType okbtn = new ButtonType("확인", ButtonBar.ButtonData.OK_DONE);
        ButtonType nobtn = new ButtonType("취소", ButtonBar.ButtonData.CANCEL_CLOSE);

        cfrm.getButtonTypes().setAll(okbtn, nobtn);
        Optional<ButtonType> result = cfrm.showAndWait();

        if (result.get() == okbtn) {

            FXMLLoader login = new FXMLLoader(getClass().getResource("/food/view/foodout.fxml"));
            try {
                Parent root = login.load();
                Stage stage = (Stage) logoutBtn.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                stage.setTitle("메인 페이지");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            event.consume();
        }
    }
}







