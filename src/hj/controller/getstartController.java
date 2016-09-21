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
 */
public class getstartController {

 @FXML Button join;



    public void goJoin(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/joinmember.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) join.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("회원가입 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
