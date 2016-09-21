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
 * Created by java on 2016-09-21.
 */
public class completeController {

    @FXML Button logoutBtn;
    @FXML Button gomainBtn;


    public void goMain(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/food/view/foodout.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage)gomainBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("메인 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void goLogout(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader();
        try {
            Parent root = login.load();
            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            stage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }




}
