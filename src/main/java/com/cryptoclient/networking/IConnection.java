package com.cryptoclient.networking;

import org.json.JSONObject;

public interface IConnection {
    void sendPacket(JSONObject packet);
}
