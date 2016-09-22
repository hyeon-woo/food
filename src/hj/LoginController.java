package hj;

import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import last.controller.MainloginController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-21.
 */
public class LoginController implements Initializable{

    @FXML
    ImageView Main;
    @FXML
    TextField email;
    @FXML
    PasswordField passwd;
    @FXML
    Button login;
    @FXML
    Button join;


    private pjJoinUpdate pj;

    public void gologin(ActionEvent event) {

        pjJoinUpdate result = null;
        String sb = "";
        String sb2 = "";
        sb=email.getText();
        sb2=passwd.getText();
        result = pjDAO.Login(sb,sb2,1);

        if (result!=null) {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("../view/foodin.fxml"
                    ));
            try {
                Parent root = loader.load();
                Stage stage = (Stage) login.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Main");

                MainloginController mlc = loader.getController();
                mlc.senddata(result);

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
                "../view/foodout.fxml"
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

    public void goJoin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "../view/singup/joinmember.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)join.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("join");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}