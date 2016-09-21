package food.controller;

import cronian.project.DB.pjDAO;
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

/**
 * Created by java on 2016-09-21.
 */
public class LoginController {

    @FXML
    ImageView Main;
    @FXML
    TextField email;
    @FXML
    PasswordField passwd;
    @FXML
    Button login;



    public void gologin(ActionEvent event) {

    boolean result = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(email.getText());
        sb2.append(passwd.getText());
        result = pjDAO.Login(sb.toString(),sb2.toString(),1);
        if (result) {

            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("../view/food.fxml"
                    ));
            try {
                Parent root = loader.load();
                Stage stage = (Stage) login.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Main");

                stage.show();
            } catch (IOException ex) {

                ex.printStackTrace();
            }
            Waring("Wellcome" , "로그인 되었습니다!");
        } else {
            Waring("오류","존재하지 않는 아이디 입니다!");
        }
    }



    public void goMain(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/food.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        public void Waring(String head,String text) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("오류");
            al.setHeaderText(head);
            al.setContentText(text);
            al.showAndWait();
        }

}
