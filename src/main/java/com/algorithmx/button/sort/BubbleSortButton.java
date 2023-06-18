package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class BubbleSortButton extends AlgorithmButton {
    public BubbleSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Bubble Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                visualizePanel.setGreenIndexHighlight(j);
                visualizePanel.repaint();
                Thread.sleep(500);
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
