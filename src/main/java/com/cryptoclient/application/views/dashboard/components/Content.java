package com.cryptoclient.application.views.dashboard.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.Date;

public class Content extends JPanel {

    private JLabel contentTitle;
    private ChartPanel chartPanel;

    public Content() {
        this.setLayout(new BorderLayout());

        // Content title
        this.setContentTitle(new JLabel("Sélectionnez une crypto pour afficher son cours"));
        this.getContentTitle().setFont(new Font("Arial", Font.PLAIN, 20));
        this.getContentTitle().setHorizontalAlignment(JLabel.CENTER);
        this.add(this.getContentTitle(), BorderLayout.CENTER);
    }

    private JFreeChart createChart(String cryptocurrencyName, JSONArray data) {

        // TODO: periods; hours, days or second?

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries("Cours de la crypto monnaie : " + cryptocurrencyName);

        for (int i = 0; i < data.length(); i++) {
            // Get the JSONObject
            JSONObject obj = data.getJSONObject(i);

            // Create the RegularTimePeriod corresponding
            String time = obj.getString("time_close");
            Instant instant = Instant.parse(time);
            Date date = Date.from(instant);
            RegularTimePeriod period = new Hour(date);

            // Get the price
            double price = obj.getDouble("rate_close");

            // Add data to the TS
            series.add(period, price);
        }

        //TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Cours de la crypto", // title
                "Temps", // x label
                "Prix", // y label
                dataset, // data
                true, // Legend
                true, // Tooltips
                false // URL
        );
        return chart;
    }

    public void loadChartPanel(String cryptocurrencyName, JSONArray data) {

        if (this.getChartPanel() != null) {
            this.getChartPanel().setVisible(false);
            this.remove(this.getChartPanel());
        }

        this.setChartPanel(new ChartPanel(this.createChart(cryptocurrencyName, data)));
        this.add(this.getChartPanel(), BorderLayout.SOUTH);

        // Reload content component
        this.revalidate();
        this.repaint();
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    public void setChartPanel(ChartPanel chartPanel) {
        this.chartPanel = chartPanel;
    }

    public JLabel getContentTitle() {
        return this.contentTitle;
    }

    public void setContentTitle(JLabel contentTitle) {
        this.contentTitle = contentTitle;
    }
}
