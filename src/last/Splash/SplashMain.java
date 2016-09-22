package last.Splash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by java on 2016-09-22.
 */
public class SplashMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pstage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/SplashFirst.fxml"));
        Stage stage = new Stage(StageStyle.UNDECORATED);


        Parent root = loader.load();


        stage.setTitle("Splash");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event ->stage.close());

    }


}
