package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class SelectionSortButton extends AlgorithmButton {
    public SelectionSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Selection Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            visualizePanel.setGreenIndexHighlight(i);
            visualizePanel.repaint();
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }
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
}


