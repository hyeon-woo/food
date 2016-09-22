package last.controller;

import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by hyeon-woo on 2016-09-23.
 */
public class ManuMainController implements Initializable {

@FXML private Pane center;





    public void firstPage(ActionEvent event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/FirstPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );
    }

    public void secondPage(Event event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/SecondPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );
    }

    public void thirdPage(Event event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/ThirdPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );

    }
    public void fouthpage(Event event) throws Exception {
        Pane sub = FXMLLoader.load(getClass().getResource("/fxml/menu/menukind/ThirdPage.fxml"));
        center.getChildren().clear();
        center.getChildren().add( sub );

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void goMaker(ActionEvent actionEvent) {
    }

    public void gologin(ActionEvent actionEvent) {
    }

    public void goMain(Event event) {

    }

    public void goOrder(Event event) {

    }
}
