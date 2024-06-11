import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader openController = new FXMLLoader(getClass().getResource("/fxml/Controller.fxml"));
        Parent gaming = openController.load();
        Scene gameScreen = new Scene(gaming);
        gameScreen.getStylesheets().add("/css/style.css");
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(gameScreen);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}
