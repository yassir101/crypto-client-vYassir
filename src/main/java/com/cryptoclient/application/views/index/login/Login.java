package com.cryptoclient.application.views.index.login;

import com.cryptoclient.application.views.View;
import com.cryptoclient.application.views.index.components.KeyboardHandler;
import com.cryptoclient.application.views.index.components.PasswordField;
import com.cryptoclient.application.views.index.components.SubmitButton;
import com.cryptoclient.application.views.index.components.UsernameField;
import com.cryptoclient.application.views.index.components.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class Login extends View {

    private int textSize;
    private int inputColumns;

    private JLabel title;
    private JLabel app;
    private UsernameField usernameField;
    private PasswordField passwordField;
    private JLabel createAccountLabel;
    private JButton loginButton;

    public Login() {
        this.textSize = 23;
        this.inputColumns = 11;

        // Initialisation des composants
        this.title = new JLabel("Bienvenue !");
        this.app = new JLabel("Cryptocurrencies Dashboard");
        this.usernameField = new UsernameField("Pseudo", this.inputColumns, this.textSize);
        this.passwordField = new PasswordField("Mot de passe", this.inputColumns, this.textSize);
        this.createAccountLabel = new JLabel("Créer un compte en cliquant ici");
        this.loginButton = new SubmitButton("Se connecter", this.textSize);

        // Appliquer des bordures arrondies
        this.usernameField.setBorder(new RoundedBorder(20, new Color(200, 200, 200)));
        this.passwordField.setBorder(new RoundedBorder(20, new Color(200, 200, 200)));
        this.loginButton.setBorder(new RoundedBorder(20, new Color(0, 122, 255)));

        // Configure Keyboard Navigation
        configureKeyboardNavigation();
    }

    private void configureKeyboardNavigation() {
        // Configure KeyboardHandler for Enter key navigation and button activation
        KeyboardHandler.configureNavigation(usernameField, passwordField, loginButton);
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public JLabel getCreateAccountLabel() {
        return this.createAccountLabel;
    }

    public UsernameField getUsernameField() {
        return this.usernameField;
    }

    public PasswordField getPasswordField() {
        return this.passwordField;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, new Color(45, 50, 65), 0, height, new Color(30, 35, 50));
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        } else {
            super.paintComponent(g);
        }
    }

    @Override
    public void loadComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuration du titre principal
        this.title.setFont(new Font("Arial", Font.BOLD, 40));
        this.title.setForeground(new Color(255, 255, 255));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.title, gbc);

        // Configuration du sous-titre de l'application
        this.app.setFont(new Font("Arial", Font.ITALIC, 18));
        this.app.setForeground(new Color(200, 200, 200));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(this.app, gbc);

        // Configuration du champ Username
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.usernameField, gbc);

        // Configuration du champ Password
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.passwordField, gbc);

        // Configuration du label "Créer un compte"
        this.createAccountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        this.createAccountLabel.setForeground(new Color(0, 172, 237));
        this.createAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.createAccountLabel, gbc);

        // Configuration du bouton de connexion
        gbc.gridy = 5;
        this.add(this.loginButton, gbc);
    }
}
