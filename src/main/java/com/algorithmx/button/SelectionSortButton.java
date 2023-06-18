package com.algorithmx.button;

import com.algorithmx.interfaces.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import javax.swing.*;

public class SelectionSortButton extends JButton implements AlgorithmButton {
    private final VisualizePanel visualizePanel;

    public SelectionSortButton(VisualizePanel visualizePanel) {
        this.visualizePanel = visualizePanel;
        this.setText("Selection Sort");
        this.addActionListener(e -> performAlgorithm());
    }

    @Override
    public void performAlgorithm() {
        setEnabled(false);
        int[] array = visualizePanel.getArray();
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws InterruptedException {
                for (int i = 0; i < array.length - 1; i++) {
                    visualizePanel.setGreenIndexHighlight(i);
                    visualizePanel.repaint();
                    int minIndex = findMinIndex(array, i);
                    swap(array, i, minIndex);
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

    private int findMinIndex(int[] array, int startIndex) throws InterruptedException {
        int minIndex = startIndex;
        for (int j = startIndex + 1; j < array.length; j++) {
            visualizePanel.setRedIndexHighlight(j);
            visualizePanel.repaint();
            Thread.sleep(500);
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

