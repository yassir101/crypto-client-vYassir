package com.cryptoclient.client;

import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.EventsListener;
import com.cryptoclient.networking.Connection;
import com.cryptoclient.networking.packets.PacketsHandler;
import com.cryptoclient.application.Application;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Client implements IClient {

    // GUI component
    private Application application;

    // Packets handler component
    private PacketsHandler packetsHandler;

    // Connection component
    private Connection connection;

    // Events listener component
    private EventsListener eventsListener;

    public Client() {

        // Launch the application and tries to connect to the server

        SwingUtilities.invokeLater(() -> {
            // Launch the graphical user interface (GUI) component
            this.setApplication(new Application(Configuration.WINDOW_TITLE, Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT, Configuration.WINDOW_RESIZABLE));
            this.getApplication().getViewManager().displayView(Configuration.VIEW_LOGIN);
            this.getApplication().setVisible(true);

            // Connection component
            this.connectToServer();

            // Packets handler component
            this.setPacketsHandler(new PacketsHandler(this.getApplication()));

            // Events listener component
            this.setEventsListener(new EventsListener(this.getApplication(), this.getConnection()));
            this.listenUIEvents();
        });
    }

    private void setEventsListener(EventsListener eventsListener) {
        this.eventsListener = eventsListener;
    }

    private EventsListener getEventsListener() {
        return this.eventsListener;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection getConnection() {
        return this.connection;
    }

    public PacketsHandler getPacketsHandler() {
        return this.packetsHandler;
    }

    public void setPacketsHandler(PacketsHandler packetsHandler) {
        this.packetsHandler = packetsHandler;
    }

    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * Tries to connect to the server
     * Starts to listen the server
     */
    private void connectToServer() {
        try {
            this.setConnection(new Connection(new Socket(Configuration.NETWORKING_HOST, Configuration.NETWORKING_PORT)));
            new Thread(this).start();
            System.out.println("Connected to the server");
        } catch (IOException e) {
            System.out.println("Can not connect to the server");
            System.exit(1);
            // TODO: create a special window to show errors to the client
        }
    }

    /**
     * Parses the string message into a JSONObject
     * @param message : incoming message, which is not null
     * @return
     */
    private JSONObject getParsedMessage(String message) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(message);
        } catch (JSONException e) {
            //this.log("JSON Exception: can not parse the message");
        }
        return jsonObject;
    }

    /**
     * Handles messages which are incoming data (from server)
     */
    private void listenMessages() {
        String message;
        try {
            System.out.println("Ready to listen the server...");
            while ((message = this.getConnection().getReader().readLine()) != null) {
                this.onPacket(this.getParsedMessage(message));
            }
        } catch (IOException e) {
            // TODO: find a way to display errors
        }
    }

    @Override
    public void onPacket(JSONObject packet) {
        if (packet != null) {
            System.out.println("Server sends: " + packet);
            this.getPacketsHandler().handle(packet);
        } else {
            System.out.println("The incoming packet is null.");
        }
    }

    @Override
    public void listenUIEvents() {
        this.getEventsListener().listenAll();
    }

    @Override
    public void run() {
        // Continuous listening of incoming data
        this.listenMessages();
        // If the connection can't listen anymore, then it has to be closed
        this.getConnection().closeConnection();
    }
}
