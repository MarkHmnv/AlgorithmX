package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.util.ArrayList;
import java.util.List;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class SelectionSortButton extends AlgorithmButton {
    public SelectionSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Selection Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
            visualizePanel.getGreenIndexesHighlight().add(i);
        }
    }

    private int findMinIndex(int[] array, int startIndex) throws InterruptedException {
        int minIndex = startIndex;
        for (int j = startIndex + 1; j < array.length; j++) {
            visualizePanel.setRedIndexesHighlight(new ArrayList<>(List.of(j)));
            visualizePanel.repaint();
            Thread.sleep(500);
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }
}


