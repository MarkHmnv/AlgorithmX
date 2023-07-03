package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.awt.*;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class SelectionSortButton extends AlgorithmButton {
    public SelectionSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Selection Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinIndex(array, i);
            if (minIndex == -1) return;
            swap(array, i, minIndex);
            visualizePanel.applyColorForIndex(i, Color.GREEN);
        }
    }

    private int findMinIndex(int[] array, int startIndex) throws InterruptedException {
        int minIndex = startIndex;
        for (int j = startIndex + 1; j < array.length; j++) {
            if (stopFlag) return -1;

            visualizePanel.applyColorForIndex(j, Color.RED);
            Thread.sleep(500);

            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
            visualizePanel.removeColorForIndex(j);
        }
        return minIndex;
    }
}


