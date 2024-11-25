package com.cryptoclient.networking.packets.dashboard;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.dashboard.Dashboard;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.networking.packets.Event;
import org.json.JSONArray;
import org.json.JSONObject;

public class SelectCryptoResponse extends Event {
    @Override
    public void handle(Application application, JSONObject packet) {
        String cryptoName = packet.getString("cryptoName");
        JSONArray cryptoData = packet.getJSONArray("cryptoData");

        // Load char in the dashboard view
        ((Dashboard) application.getViewManager().getViews().get(Configuration.VIEW_DASHBOARD)).getContent().loadChartPanel(cryptoName, cryptoData);
    }
}
