package com.algorithmx.button;

import com.algorithmx.interfaces.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSortButton extends JButton implements AlgorithmButton {
    private final VisualizePanel visualizePanel;

    public BubbleSortButton(VisualizePanel visualizePanel) {
        this.visualizePanel = visualizePanel;
        this.setText("Bubble Sort");
        this.addActionListener(e -> performAlgorithm());
    }

    @Override
    public void performAlgorithm() {
        setEnabled(false);
        int[] array = visualizePanel.getArray();
        Timer timer = new Timer(500, null);
        timer.addActionListener(new ActionListener() {
            int i = 0;
            int j = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < array.length - 1) {
                    visualizePanel.setIndexToHighlight(j);
                    visualizePanel.repaint();
                    if (j < array.length - i - 1) {
                        if (array[j] > array[j + 1]) {
                            swap(array, j, j + 1);
                            visualizePanel.setArray(array);
                            visualizePanel.repaint();
                        }
                        j++;
                    } else {
                        i++;
                        j = 0;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                    setEnabled(true);
                    JOptionPane.showMessageDialog(
                            visualizePanel,
                            "Algorithm completed",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        timer.start();
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
