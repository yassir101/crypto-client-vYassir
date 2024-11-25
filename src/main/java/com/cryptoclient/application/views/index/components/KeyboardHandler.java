package com.cryptoclient.application.views.index.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyboardHandler {

    /**
     * Configure la navigation au clavier entre les composants.
     *
     * @param components Liste des composants dans l'ordre de navigation
     */
    public static void configureNavigation(JComponent... components) {
        for (int i = 0; i < components.length; i++) {
            JComponent current = components[i];
            JComponent next = components[(i + 1) % components.length];

            // Action pour la touche Enter
            if (current instanceof JButton) {
                // Appuyer sur Enter "clique" sur le bouton
                current.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "clickButton");
                current.getActionMap().put("clickButton", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((JButton) current).doClick();
                    }
                });
            } else {
                // Appuyer sur Enter passe au composant suivant
                current.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focusNext");
                current.getActionMap().put("focusNext", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        next.requestFocusInWindow();
                    }
                });
            }
        }
    }
}
