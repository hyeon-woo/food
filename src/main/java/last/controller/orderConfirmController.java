package last.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @date 2016-09-22.
 * @author hj
 */
public class orderConfirmController {
    @FXML
    Button mainBtn;


    public void goMain(ActionEvent event) throws Exception {

        FXMLLoader confirm = new FXMLLoader(getClass().getResource("/fxml/main/foodout.fxml"));
        try {
            Parent root = confirm.load();
            Stage stage = (Stage) mainBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("메인 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




}
