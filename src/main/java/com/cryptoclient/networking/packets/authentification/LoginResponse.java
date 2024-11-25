package com.cryptoclient.networking.packets.authentification;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.dashboard.Dashboard;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.networking.packets.Event;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;

public class LoginResponse extends Event {
    @Override
    public void handle(Application application, JSONObject packet) {

        if ((boolean) packet.get("loginSuccess")) {
            if (packet.has("cryptoNames")) {
                // Load necessary data to show the dashboard
                // TODO: we can load ALL data in components one time only

                JSONArray cryptoList = (JSONArray) packet.get("cryptoNames");
                DefaultListModel<String> cryptoNames = new DefaultListModel<>();

                for (int i = 0; i < cryptoList.length(); i++) {
                    cryptoNames.addElement(cryptoList.get(i).toString());
                }

                ((Dashboard) application.getViewManager().getViews().get(Configuration.VIEW_DASHBOARD)).getMenu().getCryptoSubmenu().setCryptocurrenciesName(cryptoNames);
                ((Dashboard) application.getViewManager().getViews().get(Configuration.VIEW_DASHBOARD)).getMenu().getCryptoSubmenu().loadItems();
                application.getViewManager().displayView(Configuration.VIEW_DASHBOARD);
            } else {
                System.out.println("Login Failed: no 'cryptoNames' key");
            }
        } else {
            System.out.println("Login Failed");
        }
    }
}