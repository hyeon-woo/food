package last.controller;

import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * @date 2016-09-21.
 * @author hj
 */
public class getstartController {

    @FXML Button join;
    @FXML Button loginBtn;
    @FXML    PasswordField passwd;
    @FXML    TextField email;




    public void goJoin(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/joinmember.fxml"));
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





    public void gologin(ActionEvent event) throws Exception {

        pjJoinUpdate result;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(email.getText());
        sb2.append(passwd.getText());

        // db 연결 필요
        result = pjDAO.Login(sb.toString(), sb2.toString(), 1);
        if (result!=null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main/foodin.fxml"
            ));
            try {
                Parent root = loader.load();
                Stage stage = (Stage) join.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("주문 페이지");

                stage.show();
            } catch (IOException ex) {

                ex.printStackTrace();
            }
            Waring("Wellcome", "로그인 되었습니다!");
        } else {
            Waring("오류", "존재하지 않는 아이디 입니다!");
        }
    }

    public void Waring(String head, String text) {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("오류");
        al.setHeaderText(head);
        al.setContentText(text);
        al.showAndWait();
    }

    }


