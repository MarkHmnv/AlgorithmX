package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.awt.*;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class BubbleSortButton extends AlgorithmButton {
    public BubbleSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Bubble Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        int j;
        for (int i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (stopFlag) return;
                visualizePanel.applyColorForIndex(j, Color.RED);
                Thread.sleep(500);
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
                visualizePanel.removeColorForIndex(j);
            }
            visualizePanel.applyColorForIndex(j, Color.GREEN);
        }
    }
}
