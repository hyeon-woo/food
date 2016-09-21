package food.controller.OrderController;

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
 */
public class orderController {
    @FXML Button choiceBtn;
    @FXML Button cancelBtn;


    public void choice(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/payment.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage)choiceBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("결제 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void cancel(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/food/view/foodout.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("메인 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }





}
