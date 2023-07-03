package com.algorithmx;

import com.algorithmx.panel.ControlPanel;
import com.algorithmx.panel.VisualizePanel;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        FlatMacDarkLaf.setup();
        setTitle("AlgorithmX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        VisualizePanel visualizePanel = new VisualizePanel();
        ControlPanel controlPanel = new ControlPanel(visualizePanel);

        Dimension visualizePanelSize = new Dimension((int) (getWidth() * 0.78), getHeight());
        visualizePanel.setPreferredSize(visualizePanelSize);

        mainPanel.add(visualizePanel, BorderLayout.WEST);
        mainPanel.setComponentZOrder(visualizePanel, 0);
        mainPanel.add(controlPanel, BorderLayout.EAST);
        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
