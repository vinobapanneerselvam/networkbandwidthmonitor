package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NetworkMonitorGUI {
    private JFrame frame;
    private JTextArea outputArea;

    public NetworkMonitorGUI() {
        frame = new JFrame("Network Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Monitoring");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Monitoring network bandwidth...\n");
                // Trigger NetworkMonitor here and display output in the text area
                NetworkMonitor monitor = new NetworkMonitor(outputArea);
                monitor.startMonitoring();
            }
        });

        frame.getContentPane().add(startButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NetworkMonitorGUI();
            }
        });
    }
}
