package com.algorithmx.button;

import com.algorithmx.interfaces.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import javax.swing.*;

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

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws InterruptedException {
                for(int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - i - 1; j++) {
                        visualizePanel.setGreenIndexHighlight(j);
                        visualizePanel.repaint();
                        Thread.sleep(500);
                        if (array[j] > array[j + 1]) {
                            swap(array, j, j + 1);
                        }
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                setEnabled(true);
                JOptionPane.showMessageDialog(
                        visualizePanel,
                        "Algorithm completed",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        };

        worker.execute();
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
