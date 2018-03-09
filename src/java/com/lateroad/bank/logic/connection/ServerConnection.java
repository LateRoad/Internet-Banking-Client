package com.lateroad.bank.logic.connection;

import com.lateroad.bank.logic.security.HashMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerConnection {

    private ObjectInputStream clientReader;
    private ObjectOutputStream clientWriter;
    private boolean isStarted;

    private static final ServerConnection instance = new ServerConnection();

    private ServerConnection() {
        isStarted = false;
    }

    public static ServerConnection getInstance() {
        return instance;
    }

    public void start() throws IOException {
        Socket serverSocket = new Socket("localhost", 4244);
            clientWriter = new ObjectOutputStream(serverSocket.getOutputStream());
            clientReader = new ObjectInputStream(serverSocket.getInputStream());
            isStarted = true;
    }

    public void stop() throws IOException {
        sendMessage("EXIT");
        clientWriter.close();
        clientReader.close();
        isStarted = false;
    }

    public void sendMessage(String message) throws IOException {
        message = new String(HashMessage.getInstance().encode(message), "UTF-8");
        clientWriter.writeObject(message);
        clientWriter.flush();
    }

    public String getMessage() {
        try {
            String message = (String) clientReader.readObject();
            message = HashMessage.getInstance().decode(message.getBytes(StandardCharsets.UTF_8));
            return message;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startListen() {
        Thread listener = new Listener();
        listener.start();
    }

    public boolean isStarted() {
        return isStarted;
    }
}