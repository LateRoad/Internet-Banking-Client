package logic.connection;

import logic.response.CommandManager;

public class Listener extends Thread {
    @Override
    public void run() {
        CommandManager manager = new CommandManager();
        String message;
        do {
            message = ServerConnection.getInstance().getMessage();
            manager.execute(message);
        } while (!"EXIT".equals(message));
    }
}
