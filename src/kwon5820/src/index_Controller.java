package kwon5820.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by java on 2016-09-19.
 */
public class index_Controller {
    @FXML private BorderPane index;
    public void goMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage)index.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("view/Board.fxml"));
        Parent root = loader.load();
        // Board.fxml 읽어들임
        // Board.fxml 읽는 도중 controller 설정을 읽음
        // controller 읽음 - initialize 메서드 실행
        // ObservableList 읽음 - BoardModel 읽음
        // TableColumn 설정, ObservableList 객체 생성
        // TableView에 ObservableList 객체 지정


        stage.setTitle("게시판");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }
}