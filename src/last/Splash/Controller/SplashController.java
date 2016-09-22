package last.Splash.Controller;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-22.
 */
public class SplashController implements Initializable {

    @FXML
    Pane SplashScreen;
    @FXML
    StackPane endMain;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {
            final Pane pane = FXMLLoader.load(getClass().getResource("/last/Splash/View/Splash.fxml"));

            SplashScreen.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);

            fadeIn.play();



            // 이렇게 긴 이벤트 소스를
            fadeIn.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    fadeOut.play();
                }
            });
//
            fadeOut.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    showMainStage();
                    ((Stage)SplashScreen.getScene().getWindow()).close();

                }
            });
//            fadeOut.setOnFinished((e) -> {
//
//
//                try {
//                    final StackPane endMain = FXMLLoader.load(getClass().getResource("food/view/food.fxml"));
//                    endMain.getChildren().setAll(pane);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            });

                ;
    //        Platform.runLater(() -> {
     //           ((Stage)endMain.getScene().getWindow()).close();

     //           showMainStage();


     //                 });




            // 람다식으로 바꾸면 더 간편하고 짧게 사용할수 있음!
            /*fadeIn.setOnFinished((e)->{
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);

                fadeOut.play();
            });*/


            //fadeOut.play();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showMainStage() {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/last/view/main/foodin.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.setTitle("Main");
        stage.show();
    }
}
