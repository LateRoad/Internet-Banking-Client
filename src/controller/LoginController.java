package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.connection.ServerConnection;
import logic.response.CommandManager;
import logic.security.HashMessage;
import logic.switcher.SceneSwitcher;

import java.util.Date;

public class LoginController {

    @FXML public AnchorPane rootPane;
    @FXML public TextField login;
    @FXML public TextField password;
    @FXML public Button buttonSignIn;
    @FXML public Text error;

    @FXML
    public void signIn(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        String message;

        CommandManager manager = new CommandManager();
        try {
            connection.start();
            HashMessage.setKey(new Date().toString());
            connection.sendMessage("SIGN_IN%21" + login.getText() + " " + password.getText());

            message = connection.getMessage();
            if ("ERROR".equals(message)) {
                error.setText("Неверный логин или пароль.");
                error.setVisible(true);
            } else {
                manager.execute(message);
                connection.startListen();
                SceneSwitcher.toScene(rootPane, "/view/main.fxml");
            }
        } catch (Exception e) {
            e.printStackTrace();
            error.setText("Неверный логин или пароль.");
            error.setVisible(true);
        }
    }
}
