package com.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NetworkMonitor {
    private JTextArea outputArea;

    public NetworkMonitor(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    public void startMonitoring() {
        try {
            String command = "netstat -e";  // This is the command to get network statistics
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputArea.append(line + "\n");
            }
        } catch (Exception e) {
            outputArea.append("Error: " + e.getMessage() + "\n");
        }
    }
}
