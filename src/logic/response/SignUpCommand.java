package logic.response;

import com.google.gson.Gson;
import logic.entity.Card;
import logic.entity.User;
import model.CurrentUserModel;

public class SignUpCommand implements ICommand {
    @Override
    public String execute(String context) {
        Gson gson = new Gson();
        CurrentUserModel model = CurrentUserModel.getInstance();
        User user = gson.fromJson(context.split("%20")[0], User.class);
        String[] cards = context.split("%20");
        CurrentUserModel.getInstance().setCurrentUser(user);
        for (int i = 1; i < cards.length; ++i) {
            model.getCards().add(gson.fromJson(cards[i], Card.class));
        }
        return "OK";
    }
}
