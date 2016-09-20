package kwon5820.src.food.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class maincontroller{
    @FXML private BorderPane menu1;

        public void showMenu1(ActionEvent event)throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "food/view/menu/menu1.fxml"
            ));
            try{
                Parent root = loader.load();

                Stage stage =(Stage)menu1.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("foodmenu1");

                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }





        }




}
