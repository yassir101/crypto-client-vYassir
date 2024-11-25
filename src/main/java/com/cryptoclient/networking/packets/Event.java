package com.cryptoclient.networking.packets;

import com.cryptoclient.application.Application;
import org.json.JSONObject;

public abstract class Event {
    public abstract void handle(Application application, JSONObject packet);
}
