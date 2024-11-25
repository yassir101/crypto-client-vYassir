package com.cryptoclient.application.views.dashboard.components;

import javax.swing.*;
import java.awt.*;

public class ProfileSubmenu extends JPanel {

    private JButton profileButton;
    private JButton editProfileButton;
    private JButton logoutButton;

    public ProfileSubmenu() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(40, 43, 45));

        // Boutons stylisés
        this.setProfileButton(createStyledButton("Mon profil"));
        this.setEditProfileButton(createStyledButton("Édition"));
        this.setLogoutButton(createStyledButton("Déconnexion"));

        // Ajouter les boutons
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        this.add(this.getProfileButton());
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        this.add(this.getEditProfileButton());
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        this.add(this.getLogoutButton());
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public JButton getProfileButton() {
        return profileButton;
    }

    public void setProfileButton(JButton profileButton) {
        this.profileButton = profileButton;
    }

    public JButton getEditProfileButton() {
        return editProfileButton;
    }

    public void setEditProfileButton(JButton editProfileButton) {
        this.editProfileButton = editProfileButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }
}
