package com.cryptoclient.listener.login;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.index.login.Login;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.ViewListener;
import com.cryptoclient.networking.Connection;
import com.cryptoclient.networking.packets.headers.OutgoingHeaders;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginListener extends ViewListener<Login> {

    public LoginListener(Application application, Connection connection, Login loginView) {
        super(application, connection, loginView);
    }

    @Override
    public void listen() {
        this.listenCreateAnAccount();
        this.listenLoginSubmit();
    }

    private void listenCreateAnAccount() {
        this.getView().getCreateAccountLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getApp().getViewManager().displayView(Configuration.VIEW_REGISTER);
            }
        });
    }

    private void listenLoginSubmit() {
        this.getView().getLoginButton().addActionListener(e -> {
            JSONObject packet = new JSONObject();
            packet.put("header", OutgoingHeaders.LOGIN_SUBMIT_REQUEST);
            packet.put("username", this.getView().getUsernameField().getText());
            packet.put("password", this.getView().getPasswordField().getText()); // TODO: getText() is deprecated
            this.getConnection().sendPacket(packet);
            this.getApp().getViewManager().displayView(Configuration.VIEW_LOADING);
        });
    }
}
