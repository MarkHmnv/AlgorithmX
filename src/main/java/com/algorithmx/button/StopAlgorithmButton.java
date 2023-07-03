package com.algorithmx.button;

import javax.swing.*;
import java.awt.*;

public class StopAlgorithmButton extends JButton {

    public StopAlgorithmButton() {
        setBackground(Color.RED);
        setText("Stop Algorithm");
        addActionListener(e -> stopAlgorithm());
    }

    private void stopAlgorithm() {
        AlgorithmButton.stopFlag = true;
    }
}