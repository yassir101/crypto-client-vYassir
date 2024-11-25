package com.cryptoclient.client;

import org.json.JSONObject;

import java.io.Closeable;

public interface IClient extends Runnable {
    // Triggered when the client receives data from the server ( > packet listener)
    void onPacket(JSONObject packet);

    // Listen all events triggered on the GUI
    void listenUIEvents();
}
