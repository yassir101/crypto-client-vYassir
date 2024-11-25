package com.cryptoclient.application.views.index.register;

import com.cryptoclient.application.views.View;
import com.cryptoclient.application.views.index.components.PasswordField;
import com.cryptoclient.application.views.index.components.SubmitButton;
import com.cryptoclient.application.views.index.components.UsernameField;

import javax.swing.*;
import java.awt.*;

public class Register extends View {
    private int textSize;
    private int inputColumns;

    private JLabel title;
    private UsernameField usernameField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
    private JLabel loginLabel;
    private JButton registerButton;

    public Register() {
        this.textSize = 23;
        this.inputColumns = 16;
        this.title = new JLabel("Inscription");
        this.usernameField = new UsernameField("Pseudo", this.getInputColumns(), this.getTextSize());
        this.passwordField = new PasswordField("Mot de passe", this.getInputColumns(), this.getTextSize());
        this.confirmPasswordField = new PasswordField("Vérification du mot de passe", this.getInputColumns(), this.getTextSize());
        this.loginLabel = new JLabel("Retourner sur la page de connection");
        this.registerButton = new SubmitButton("S'inscrire !", this.getTextSize());
    }

    public JLabel getLoginLabel() {
        return this.loginLabel;
    }

    public void setLoginLabel(JLabel createAccountLabel) {
        this.loginLabel = createAccountLabel;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getInputColumns() {
        return this.inputColumns;
    }

    public JLabel getTitle() {
        return this.title;
    }

    public UsernameField getUsernameField() {
        return this.usernameField;
    }

    public PasswordField getPasswordField() {
        return this.passwordField;
    }

    public PasswordField getConfirmPasswordField() {
        return this.confirmPasswordField;
    }

    public void setConfirmPasswordField(PasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public JButton getRegisterButton() {
        return this.registerButton;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setInputColumns(int inputColumns) {
        this.inputColumns = inputColumns;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setUsernameField(UsernameField usernameField) {
        this.usernameField = usernameField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public void setLoginButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    @Override
    public void loadComponents() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(39, 33, 37));
        GridBagConstraints gbc = new GridBagConstraints();

        this.getTitle().setFont(new Font("Arial", Font.PLAIN, 40));
        this.getTitle().setForeground(new Color(133, 122, 129));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        this.add(this.getTitle(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.getUsernameField(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.getPasswordField(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 10, 0);
        this.add(this.getConfirmPasswordField(), gbc);

        this.getLoginLabel().setFont(new Font("Arial", Font.PLAIN, 17));
        this.getLoginLabel().setForeground(new Color(133, 122, 129));
        this.getLoginLabel().setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.getLoginLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(this.getRegisterButton(), gbc);
    }
}
