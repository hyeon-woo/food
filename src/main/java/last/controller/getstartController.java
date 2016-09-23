package last.controller;

import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * @author hj
 * @date 2016-09-21.
 */
public class getstartController implements Initializable {

    @FXML
    Button join;
    @FXML
    Button loginBtn;
    @FXML
    PasswordField passwd;
    @FXML
    TextField email;
    @FXML
    ImageView main;

    private FXMLLoader loader1;


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
                MainloginController mlc = loader.getController();
                mlc.senddata(result);
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

    public void gomain(Event event) {
        Alert confirm = new Alert(
                Alert.AlertType.CONFIRMATION
        );
        confirm.setTitle("확인");
        confirm.setHeaderText(null);
        confirm.setContentText("취소합니까?");

        ButtonType okbtn = new ButtonType(
                "네", ButtonBar.ButtonData.OK_DONE
        );
        ButtonType nobtn = new ButtonType(
                "아니오", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirm.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get() == okbtn) {
            goMain();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main/foodout.fxml"));
        }else event.consume();;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loader1 = new FXMLLoader(getClass().getResource(""));
    }


   public void goMain() {
       FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "/fxml/main/foodout.fxml"
       ));
       try {
           Parent root = loader.load();
           Stage stage = (Stage) main.getScene().getWindow();
           stage.setScene(new Scene(root));
           stage.setTitle("maker");

           stage.show();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }
}






