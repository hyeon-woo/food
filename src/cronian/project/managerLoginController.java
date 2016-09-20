package cronian.project;

import cronian.project.DB.pjDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by java on 2016-09-20.
 */
public class managerLoginController  {
    @FXML TextField managerid;
    @FXML PasswordField managerpwd;


    public void Waring(String head,String text) {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("오류");
        al.setHeaderText(head);
        al.setContentText(text);
        al.showAndWait();
    }

    public void mapagego(ActionEvent event) {
        boolean rs = pjDAO.Login(managerid.getText(),managerpwd.getText(),2);
        if(rs)
        {
            Waring("확인","확인");
        }
        else{
            Waring("오류","오류");
        }
    }
}
