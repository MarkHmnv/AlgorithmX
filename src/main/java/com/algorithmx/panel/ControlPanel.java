package com.algorithmx.panel;

import com.algorithmx.button.BubbleSortButton;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public ControlPanel(VisualizePanel visualizePanel) {
        add(new BubbleSortButton(visualizePanel), BorderLayout.CENTER);
    }
}
