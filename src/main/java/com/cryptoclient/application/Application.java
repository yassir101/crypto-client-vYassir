package com.cryptoclient.application;

import com.cryptoclient.application.views.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private ViewManager viewManager;

    public Application(String title, int width, int height, boolean resizable) {
        super();

        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(resizable);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setViewManager(new ViewManager(this));

        this.setFocusTraversalPolicy(new FocusTraversalPolicy() {
            @Override
            public Component getComponentAfter(Container aContainer, Component aComponent) {
                return null;
            }

            @Override
            public Component getComponentBefore(Container aContainer, Component aComponent) {
                return null;
            }

            @Override
            public Component getFirstComponent(Container aContainer) {
                return null;
            }

            @Override
            public Component getLastComponent(Container aContainer) {
                return null;
            }

            @Override
            public Component getDefaultComponent(Container aContainer) {
                return null;
            }
        });
    }

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public ViewManager getViewManager() {
        return this.viewManager;
    }

}
