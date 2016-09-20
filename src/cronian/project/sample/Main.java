package cronian.project.sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by java on 2016-09-20.
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

   @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader(
               getClass().getResource("../fxml/managerlogin.fxml"));
       Parent root = loader.load();

       stage.setScene(new Scene(root));
       stage.setResizable(false);

       stage.show();

   }
}

