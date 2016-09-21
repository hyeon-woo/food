package hj.loginout.controller;


import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by java on 2016-09-20.
 */
public class joinmemberController {
    @FXML TextField emailfw;
    @FXML TextField emailbk;
    @FXML TextField username;
    @FXML TextField userphone;
    @FXML PasswordField passwd;
    @FXML PasswordField conpasswd;
    @FXML TextField useraddrnum;
    @FXML TextField useraddrtext;
    @FXML Label checked;

    public void checkemail(ActionEvent event) {
        boolean result =false;
        StringBuilder sb = new StringBuilder();
        sb.append(emailbk.getText()).append("@").append(emailbk.getText());
        result = pjDAO.checkemail(sb.toString(),1);
        if(result){
            Waring("정상작동","사용가능 Email입니다");
        } else {
            Waring("오류","존재하는 Email입니다");
        }

    }

    public void joinmember(ActionEvent event) {
        pjJoinUpdate pj;
        StringBuilder sb = new StringBuilder();
        sb.append(emailbk.getText()).append("@").append(emailbk.getText());
        StringBuilder sb1 = new StringBuilder();
        sb1.append(useraddrnum.getText()).append("//").append(useraddrtext.getText());
        pj = new pjJoinUpdate(sb.toString(),username.getText(),userphone.getText(),passwd.getText(),sb1.toString());
        if(pjDAO.addMember(pj,1)){
            Waring("완료","가입완료");
        }else{
            Waring("오류","오류");
        }
    }

    public void Waring(String head,String text) {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("오류");
        al.setHeaderText(head);
        al.setContentText(text);
        al.showAndWait();
    }

    public void passwdchck(Event event) {
        if(conpasswd.getText().equals(passwd.getText())){
            checked.setText("비밀번호가 일치합니다");
            checked.setVisible(true);
            checked.setStyle("-fx-text-fill: blue");
        } else{
            checked.setText("비밀번호가 일치하지 않습니다");
            checked.setVisible(true);
            checked.setStyle("-fx-text-fill: red");
        }
    }
}