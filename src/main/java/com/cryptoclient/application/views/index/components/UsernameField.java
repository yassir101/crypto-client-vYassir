package com.cryptoclient.application.views.index.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UsernameField extends JTextField {

    private final Color placeHolderColor = new Color(180, 180, 180);
    private final Color borderColorFocused = new Color(85, 255, 255);
    private final Color borderColorDefault = new Color(100, 100, 100);

    public UsernameField(String placeHolder, int columns, int textSize) {
        super(columns);
        this.setFont(new Font("Arial", Font.PLAIN, textSize));
        this.setBackground(new Color(240, 240, 240)); // Light background
        this.setForeground(placeHolderColor);
        this.setText(placeHolder);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColorDefault, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Focus effects
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeHolder)) {
                    setText("");
                    setForeground(Color.DARK_GRAY);
                }
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(borderColorFocused, 2),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeHolder);
                    setForeground(placeHolderColor);
                }
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(borderColorDefault, 2),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }
        });
    }
}
