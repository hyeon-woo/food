package hj.loginout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by java on 2016-09-21.
 */
public class order1main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/order1.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
