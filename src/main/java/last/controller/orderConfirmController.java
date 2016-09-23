package last.controller;

import cronian.project.model.pjJoinUpdate;
import cronian.project.model.pjOrdermodel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * @date 2016-09-22.
 * @author hj
 */
public class orderConfirmController {
    @FXML
    Button mainBtn;
    @FXML
    Button Main;
    @FXML
    TextArea calc;
    private pjJoinUpdate pj;
    private pjOrdermodel pjor;

    public void senddata (pjJoinUpdate pj, pjOrdermodel pjor){
        this.pj = pj;
        this.pjor = pjor;
        String result;
        if(pjor.getMenuno().equals("1")){result ="Personal plan";}
        else{result= "Family plan";}
        StringBuilder sb = new StringBuilder();
        calc.setText((sb.append("■  주문자 정보\n").append("     이     름: ").append(pj.getName()).append("\n")
                .append("     주     소: ").append(pj.getAddr().replace("//", " ")).append("\n")
                .append("     이 메 일:").append(pj.getEmail()).append("\n")
                .append("     전화번호:").append(pj.getName()).append("\n").append("\n").append("\n")
                .append("■  배송일자 : 추후결정").append("\n")
                .append("■  주문내역:").append(result)
        ).toString());
    }



    public void goMain(ActionEvent event) throws Exception {

        FXMLLoader confirm = new FXMLLoader(getClass().getResource("/fxml/main/foodin.fxml"));
        try {
            Parent root = confirm.load();
            Stage stage = (Stage) mainBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("메인 페이지");
            MainloginController mlc = confirm.getController();
            mlc.senddata(pj);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }






}
