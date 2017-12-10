
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.connection.ServerConnection;

import java.io.IOException;

public class Client extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        window.setOnCloseRequest(event -> {
            closeProgram();
        });
        window.setResizable(false);
        window.setTitle("PowerBank");
        window.setScene(new Scene(root));
        window.show();
    }

    private void closeProgram() {
        try {
            ServerConnection.getInstance().stop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            window.close();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
