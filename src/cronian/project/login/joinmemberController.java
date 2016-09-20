package cronian.project.login;


import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by java on 2016-09-20.
 */
public class joinmemberController {
    @FXML TextField emailfw;
    @FXML TextField emailbk;
    @FXML TextField username;
    @FXML TextField userphone;
    @FXML TextField useraddrnum;
    @FXML TextField useraddrtext;

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
        pj = new pjJoinUpdate(sb.toString(),username.getText(),userphone.getText(),"11",sb1.toString());
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

}
