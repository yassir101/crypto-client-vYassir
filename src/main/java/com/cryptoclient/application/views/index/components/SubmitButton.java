package com.cryptoclient.application.views.index.components;

import javax.swing.*;
import java.awt.*;

public class SubmitButton extends JButton {

    public SubmitButton(String text, int textSize) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, textSize));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(85, 107, 255)); // Vibrant blue
        this.setBorder(new RoundedBorder(20, new Color(85, 107, 255)));
        this.setFocusPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effects
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(100, 149, 237)); // Lighter blue
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(85, 107, 255)); // Original color
            }
        });
    }
}
