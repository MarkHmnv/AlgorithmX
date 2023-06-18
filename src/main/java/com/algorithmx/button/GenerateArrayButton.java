package com.algorithmx.button;

import com.algorithmx.interfaces.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import javax.swing.*;
import java.util.Random;

public class GenerateArrayButton extends JButton implements AlgorithmButton {
    private final Random random;
    private final VisualizePanel visualizePanel;
    private static final int BOUNDS = 99;

    public GenerateArrayButton(VisualizePanel visualizePanel) {
        this.visualizePanel = visualizePanel;
        this.random = new Random();
        this.setText("Generate Array");
        this.addActionListener(e -> performAlgorithm());
        performAlgorithm();
    }

    @Override
    public void performAlgorithm() {
        visualizePanel.setArray(fillArray(visualizePanel.getArray()));
        visualizePanel.repaint();
    }

    private int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-BOUNDS, BOUNDS);
        }
        return array;
    }
}
