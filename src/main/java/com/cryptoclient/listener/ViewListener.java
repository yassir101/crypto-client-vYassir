package com.cryptoclient.listener;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.View;
import com.cryptoclient.networking.Connection;

public abstract class ViewListener <T extends View> {

    private final Application app;
    private final Connection connection;
    private final T view;

    public ViewListener(Application app, Connection connection, T view) {
        this.app = app;
        this.connection = connection;
        this.view = view;
    }

    public abstract void listen();

    protected T getView() {
        return this.view;
    }

    protected Connection getConnection() {
        return this.connection;
    }

    protected Application getApp() {
        return this.app;
    }
}
