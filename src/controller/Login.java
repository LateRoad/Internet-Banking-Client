package controller;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.connection.Listener;
import logic.connection.ServerConnection;
import logic.entity.Card;
import logic.entity.User;
import logic.switcher.SceneSwitcher;
import model.CurrentUserModel;

public class Login {

    @FXML
    public AnchorPane rootPane;
    @FXML
    public TextField login;
    @FXML
    public TextField password;
    @FXML
    public Button buttonSignIn;
    @FXML
    public Text error;

    @FXML
    public void signIn(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        String message;
        CurrentUserModel model = CurrentUserModel.getInstance();
        try {
            connection.start();
            connection.sendMessage("SIGN_IN%21" + login.getText() + " " + password.getText());
            Gson gson = new Gson();
            message = connection.getMessage();
            if ("ERROR".equals(message)) {
                error.setText("Неверный логин или пароль.");
                error.setVisible(true);

            } else {
                User user = gson.fromJson(message.split("%20")[0], User.class);
                String[] cards = message.split("%20");
                CurrentUserModel.getInstance().setCurrentUser(user);
                for (int i = 1; i < cards.length; ++i) {
                    model.getCards().add(gson.fromJson(cards[i], Card.class));
                }
                Listener listener = new Listener();
                listener.start();
                SceneSwitcher.toScene(rootPane, "/view/main.fxml");
            }
        } catch (Exception e) {
            error.setText("Неверный логин или пароль.");
            error.setVisible(true);
        }
    }
}
