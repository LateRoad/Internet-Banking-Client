package logic.response;

import com.google.gson.Gson;
import logic.entity.Card;
import model.CurrentUserModel;

public class UpdateCommand implements ICommand {
    @Override
    public String execute(String context) {
        CurrentUserModel model = CurrentUserModel.getInstance();
        Gson gson = new Gson();

        String[] cards = context.split("%20");

        model.getCards().clear();
        for (int i = 0; i < cards.length; ++i) {
            model.getCards().add(gson.fromJson(cards[i], Card.class));
        }

        return null;
    }
}
