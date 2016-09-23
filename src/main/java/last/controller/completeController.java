package last.controller;

import cronian.project.model.pjJoinUpdate;
import cronian.project.model.pjOrdermodel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * @date 2016-09-21.
 * @author hj
 */
public class completeController {

    @FXML
    Button logoutBtn;
    @FXML
    Button confirmBtn;
    @FXML
    ImageView Main;
    private pjJoinUpdate pj;
    private pjOrdermodel pjor;





    public void goConfirm(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/orderConfirm.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) confirmBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("주문확인 페이지");
            orderConfirmController occ = login.getController();
            occ.senddata(pj,pjor);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goLogout(ActionEvent event) throws Exception {

        Alert cfrm = new Alert(Alert.AlertType.CONFIRMATION);
        cfrm.setContentText("로그아웃을 하시겠습니까?");

        ButtonType okbtn = new ButtonType("확인", ButtonBar.ButtonData.OK_DONE);
        ButtonType nobtn = new ButtonType("취소", ButtonBar.ButtonData.CANCEL_CLOSE);

        cfrm.getButtonTypes().setAll(okbtn, nobtn);
        Optional<ButtonType> result = cfrm.showAndWait();

        if (result.get() == okbtn) {

            FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/main/foodout.fxml"));
            try {
                Parent root = login.load();
                Stage stage = (Stage) logoutBtn.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                stage.setTitle("메인 페이지");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            event.consume();
        }
    }

    public void gomian(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodin.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodmain");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void senddata(pjJoinUpdate pj, pjOrdermodel pjor){
        this.pj = pj;
        this.pjor = pjor;
    }
}







