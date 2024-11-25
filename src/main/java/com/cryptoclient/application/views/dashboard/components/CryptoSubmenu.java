package com.cryptoclient.application.views.dashboard.components;

import javax.swing.*;
import java.awt.*;

public class CryptoSubmenu extends JPanel {

    private DefaultListModel<String> cryptocurrenciesName;
    private JList<String> cryptocurrenciesItems;
    private JScrollPane listScroller;

    public CryptoSubmenu(DefaultListModel<String> cryptocurrenciesName) {
        this.setCryptocurrenciesName(cryptocurrenciesName);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(40, 43, 45));

        // Initialiser la liste
        this.setCryptocurrenciesItems(new JList<>());
        this.loadItems();
    }

    public JScrollPane getListScroller() {
        return listScroller;
    }

    public void setListScroller(JScrollPane listScroller) {
        this.listScroller = listScroller;
    }

    public JList<String> getCryptocurrenciesItems() {
        return cryptocurrenciesItems;
    }

    public void setCryptocurrenciesItems(JList<String> cryptocurrenciesItems) {
        this.cryptocurrenciesItems = cryptocurrenciesItems;
    }

    public void loadItems() {
        this.getCryptocurrenciesItems().setModel(this.getCryptocurrenciesName());
        this.getCryptocurrenciesItems().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.getCryptocurrenciesItems().setFont(new Font("Arial", Font.PLAIN, 17));
        this.getCryptocurrenciesItems().setBackground(new Color(50, 53, 55));
        this.getCryptocurrenciesItems().setForeground(Color.WHITE);

        // Définir un JScrollPane pour la liste
        this.setListScroller(new JScrollPane(this.getCryptocurrenciesItems()));
        this.setLayout(new BorderLayout());
        this.add(this.getListScroller(), BorderLayout.CENTER);
    }

    public DefaultListModel<String> getCryptocurrenciesName() {
        return cryptocurrenciesName;
    }

    public void setCryptocurrenciesName(DefaultListModel<String> cryptocurrenciesName) {
        this.cryptocurrenciesName = cryptocurrenciesName;
    }
}
