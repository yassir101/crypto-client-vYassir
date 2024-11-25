package com.cryptoclient.networking;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements IConnection {

    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(this.getSocket().getInputStream()));
        this.writer = new PrintWriter(this.getSocket().getOutputStream(), true);
    }

    public Socket getSocket() {
        return this.socket;
    }

    public BufferedReader getReader() {
        return this.reader;
    }

    public PrintWriter getWriter() {
        return this.writer;
    }

    /**
     * Close the reader, writer and the socket
     */
    public void closeConnection() {
        try {
            this.getReader().close();
            this.getWriter().close();
            this.getSocket().close();
            //this.log("Connection closed.");
        } catch (IOException e) {
            //this.log("Can not close the connection.");
        }
    }

    @Override
    public void sendPacket(JSONObject packet) {
        String message = packet.toString();
        this.getWriter().println(message);
        System.out.println("Client sends: " + message);
    }
}
