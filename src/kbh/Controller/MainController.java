package kbh.Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-20.
 */
public class MainController {
    @FXML private Label orderad;
    @FXML private Label memberad;
    @FXML private Label categoryad;
    @FXML private Label managerinfo;
    @FXML private Label productad;


    public void goorderad(Event event){

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "../../kbh/fxml/orderad.fxml"
            ));
            try {
                Parent root = loader.load();
                Stage stage = (Stage)orderad.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("managerpage");

                stage.show();
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    public void gomemberad(Event event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../kbh/fxml/mainpage.fxml"));
        try{
            Parent root = loader.load();
            Stage stage = (Stage)memberad.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void gomanagerinfo(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../kbh/fxml/managerinfo.fxml"));

        try{
            Parent root = loader.load();
            Stage stage = (Stage)managerinfo.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void gocategoryad(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../kbh/fxml/categoryad.fxml"));

        try{
            Parent root = loader.load();
            Stage stage = (Stage)categoryad.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goproductad(Event event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../kbh/fxml/productad.fxml"));

        try{
            Parent root = loader.load();
            Stage stage = (Stage)productad.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //홈폐이지로 가기인데 홈폐이지로 가는방법 모르겄음
   public void gohome(Event event) {

    }

    //이걸왜만들었지싶네요
   public void mapagego(ActionEvent event) {

    }
}



