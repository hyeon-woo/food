package hj.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @date 2016-09-21.
 * @author hj
 */
public class paymentController {
    @FXML
    Button payBtn;
    @FXML Button paychangeBtn;

    public void goPay(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/complete.fxml"));
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

        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/order.fxml"));
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





}







