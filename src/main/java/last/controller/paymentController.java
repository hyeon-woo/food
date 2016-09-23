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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * @date 2016-09-21.
 * @author hj
 */
public class paymentController{
    @FXML
    Button payBtn;
    @FXML Button paychangeBtn;
    @FXML
    ImageView Main;
    @FXML TextField id1;
    @FXML TextField id2;
    @FXML TextField num;
    @FXML TextField ad1;
    @FXML TextField ad2;
    @FXML TextField name;
    @FXML TextField cd1;
    @FXML TextField cd2;
    @FXML TextField cd3;

    private pjJoinUpdate pj;
    private pjOrdermodel pjor;


    public void check1(ActionEvent event) {

        id1.setEditable(true);
        id2.setEditable(true);
        num.setEditable(true);
        ad1.setEditable(true);
        ad2.setEditable(true);
        name.setEditable(true);

        id1.clear();
        id2.clear();
        num.clear();
        ad1.clear();
        ad2.clear();
        name.clear();
    }
    public void goPay(ActionEvent event) throws Exception {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        pj.setEmail(sb1.append(id1.getText().toString()).append("@").append(id2.getText().toString()).toString());
        pj.setAddr(sb2.append(ad1.getText().toString()).append("//").append(ad2.getText().toString()).toString());
        pj.setNum(num.getText().toString());
        pj.setName(name.getText().toString());
        StringBuilder sb3 = new StringBuilder();
        pjor.setBillinfo(
                (sb3.append(cd1.getText().toString()).append("///").
                        append(cd2.getText().toString()).append("///").
                        append(cd3.getText().toString())).toString());


        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/complete.fxml"));

        try {
            Parent root = login.load();
            Stage stage = (Stage)payBtn.getScene().getWindow();
            completeController CC = login.getController();
            CC.senddata(pj,pjor);
            stage.setScene(new Scene(root));
            stage.setTitle("주문완료 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void paychange(ActionEvent event) throws Exception {

        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/order/order.fxml"));
        try {
            Parent root = login.load();
            Stage stage = (Stage) paychangeBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("주문 페이지");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


    public void gomain(Event event) {
        Alert confirm = new Alert(
                Alert.AlertType.CONFIRMATION
        );
        confirm.setTitle("확인");
        confirm.setHeaderText(null);
        confirm.setContentText("결제를 취소하시겠습니까?");

        ButtonType okbtn = new ButtonType(
                "네", ButtonBar.ButtonData.OK_DONE
        );
        ButtonType nobtn = new ButtonType(

                "아니오", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirm.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get() == okbtn) {
            goMain();

        }else event.consume();;


    }

    public void goMain() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodin.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Main.getScene().getWindow();
            stage.setScene(new Scene(root));
            MainloginController mlc = loader.getController();
            mlc.senddata(pj);
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void senddata (pjJoinUpdate pj, pjOrdermodel pjor){
        this.pj = pj;
        this.pjor = pjor;
        System.out.println(pj.getEmail());
        String[] email = pj.getEmail().toString().split("@");
        String[] ad = pj.getAddr().toString().split("//");
        id1.setText(email[0]);
        id2.setText(email[1]);
        num.setText(pj.getNum().toString());
        ad1.setText(ad[0]);
        ad2.setText(ad[1]);
        name.setText(pj.getName().toString());

    }



}







