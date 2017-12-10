package logic.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection {

    private ObjectInputStream clientReader;
    private ObjectOutputStream clientWriter;
    private Thread listener;

    private static final ServerConnection instance = new ServerConnection();
    private ServerConnection(){}
    public static ServerConnection getInstance() {
        return instance;
    }

    public void start() throws IOException {
        Socket serverSocket = new Socket("localhost",4244);
        clientWriter = new ObjectOutputStream(serverSocket.getOutputStream());
        clientReader = new ObjectInputStream(serverSocket.getInputStream());
    }

    public void stop() throws IOException {
        sendMessage("EXIT");
        clientWriter.close();
        clientReader.close();
    }

    public void sendMessage(String message) throws IOException {
        clientWriter.writeObject(message);
        clientWriter.flush();
    }

    public String getMessage(){
        try {
            return (String)clientReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startListen(){
        listener = new Thread();

    }

}