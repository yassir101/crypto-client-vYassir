package com.cryptoclient.application.views.loading;

import com.cryptoclient.application.views.View;

import javax.swing.*;
import java.awt.*;

public class Loading extends View {

    private JLabel loadingLabel;

    public Loading() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 300));
        this.setLoadingLabel(new JLabel("Chargement...", JLabel.CENTER));
        this.getLoadingLabel().setFont(new Font("Arial", Font.PLAIN, 45));
        this.getLoadingLabel().setForeground(new Color(133, 122, 129));
    }

    public JLabel getLoadingLabel() {
        return loadingLabel;
    }

    public void setLoadingLabel(JLabel loadingLabel) {
        this.loadingLabel = loadingLabel;
    }

    @Override
    public void loadComponents() {
        this.setBackground(new Color(39, 33, 37));
        this.add(this.getLoadingLabel());
    }
}
