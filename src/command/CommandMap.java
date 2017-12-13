package command;

import java.util.HashMap;

public class CommandMap {
    private HashMap<String, ICommand> commandsMap;
    private static final CommandMap instance = new CommandMap();
    public static CommandMap getInstance() {
        return instance;
    }
    private CommandMap(){
        commandsMap = new HashMap<>();
        commandsMap.put("SIGNUP", new SignUpCommand());
        commandsMap.put("UPDATE", new UpdateCommand());
    }

    public ICommand getCommandsMap(String key) {
        return commandsMap.get(key);
    }
}
