package last.controller;

import cronian.project.model.pjJoinUpdate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * Created by java on 2016-09-19.
 */
public class MainloginController implements Initializable {
    @FXML    private Button Menu;
    @FXML    private ImageView Main;
    @FXML    private Button Howwork;
    @FXML    private Button Seemenu;
    @FXML    private Button Apply;
    @FXML private Button logoutBtn;
    @FXML private Text name;
    private pjJoinUpdate pj;


    public void goOrder(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/order/order.fxml")
        );
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Apply.getScene().getWindow();
            orderController oc = loader.getController();
            oc.senddata(pj);
            stage.setScene(new Scene(root));
            stage.setTitle("Order");

            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void gomain(ActionEvent event) throws Exception{
        Alert confirm = new Alert(
                Alert.AlertType.CONFIRMATION
        );
        confirm.setTitle("확인");
        confirm.setHeaderText(null);
        confirm.setContentText("로그아웃 하시겠습니까?");

        ButtonType okbtn = new ButtonType(
                "네", ButtonBar.ButtonData.OK_DONE
        );
        ButtonType nobtn = new ButtonType(
                "아니오", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirm.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get() == okbtn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main/foodout.fxml"));
            Parent root = loader.load();
            Stage stage= (Stage) Menu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("foodMain");
        }else event.consume();;
    }
    private FXMLLoader loader1;
    public void goMenu1(ActionEvent event) {

            try {

            Parent root1 = loader1.load();
            Stage stage = (Stage)Menu.getScene().getWindow();
            ManuMainloginController mmlc = loader1.getController();
            mmlc.senddata(pj);
            stage.setScene(new Scene(root1));
            stage.setTitle("foodmenu1");


            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void goMain(Event event) {
    }
    public void goMaker(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/maker/makerlogin.fxml"
        ));
        try {
            Parent root = loader1.load();
            Stage stage = (Stage)Howwork.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("maker");

            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void boxgoMenu1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/menu/menunoimagelogin.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Seemenu.getScene().getWindow();
            ManuMainloginController mmlc = loader.getController();
            mmlc.senddata(pj);
            stage.setScene(new Scene(root));
            stage.setTitle("foodmenu");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loader1 = new FXMLLoader(getClass().getResource(
                "/fxml/menu/menunoimagelogin.fxml"
        ));


    }

    public void senddata(pjJoinUpdate result) {
        pj = result;
        name.setText(pj.getName());
    }
    public void goMain() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/fxml/main/foodin.fxml"
        ));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)Main.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Main");

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goJoinMember(Event event) {
    }

    public void gologin(ActionEvent event) {

    }

    public void goOrderCenter(ActionEvent event) {
        goOrder(event);
    }
}
