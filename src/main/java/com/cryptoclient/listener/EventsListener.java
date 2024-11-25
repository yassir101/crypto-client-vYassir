package com.cryptoclient.listener;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.dashboard.Dashboard;
import com.cryptoclient.application.views.index.login.Login;
import com.cryptoclient.application.views.index.register.Register;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.dashboard.DashboardListener;
import com.cryptoclient.listener.login.LoginListener;
import com.cryptoclient.listener.register.RegisterListener;
import com.cryptoclient.networking.Connection;

public class EventsListener {

    private final Application application;
    private final Connection connection;

    // Define listeners
    private ViewListener<Login> loginListener;
    private ViewListener<Register> registerListener;
    private ViewListener<Dashboard> dashboardViewListener;

    public EventsListener(Application application, Connection connection) {
        this.application = application;
        this.connection = connection;
    }

    public void listenAll() {
        // listen login
        this.setLoginListener(new LoginListener(this.getApplication(), this.getConnection(), (Login) this.getApplication().getViewManager().getViews().get(Configuration.VIEW_LOGIN)));
        this.getLoginListener().listen();

        // listen register
        this.setRegisterListener(new RegisterListener(this.getApplication(), this.getConnection(), (Register) this.getApplication().getViewManager().getViews().get(Configuration.VIEW_REGISTER)));
        this.getRegisterListener().listen();

        // listen dashboard
        this.setDashboardViewListener(new DashboardListener(this.getApplication(), this.getConnection(), (Dashboard) this.getApplication().getViewManager().getViews().get(Configuration.VIEW_DASHBOARD)));
        this.getDashboardViewListener().listen();
    }

    private ViewListener<Dashboard> getDashboardViewListener() {
        return dashboardViewListener;
    }

    private void setDashboardViewListener(ViewListener<Dashboard> dashboardViewListener) {
        this.dashboardViewListener = dashboardViewListener;
    }

    private ViewListener<Register> getRegisterListener() {
        return this.registerListener;
    }

    private void setRegisterListener(ViewListener<Register> registerListener) {
        this.registerListener = registerListener;
    }

    private ViewListener<Login> getLoginListener() {
        return this.loginListener;
    }

    private void setLoginListener(ViewListener<Login> loginListener) {
        this.loginListener = loginListener;
    }

    private Connection getConnection() {
        return this.connection;
    }

    private Application getApplication() {
        return this.application;
    }
}
