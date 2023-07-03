package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.awt.*;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class InsertionSortButton extends AlgorithmButton {
    public InsertionSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Insertion Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        int newElementInArray;
        int j;
        visualizePanel.applyColorForIndex(0, Color.GREEN);

        for (int i = 1; i < array.length; i++) {
            if (stopFlag) return;

            newElementInArray = array[i];
            j = i - 1;

            visualizePanel.applyColorForIndex(i, Color.GREEN);
            Thread.sleep(1000);

            if(array[j] > newElementInArray) {
                while (j >= 0 && array[j] > newElementInArray && !stopFlag) {
                    visualizePanel.applyColorForIndex(j+1, Color.RED);
                    Thread.sleep(500);
                    swap(array, j, j + 1);
                    visualizePanel.applyColorForIndex(j+1, Color.GREEN);
                    j--;
                }
                visualizePanel.applyColorForIndex(j+1, Color.RED);
                Thread.sleep(500);
            }
            visualizePanel.applyColorForIndex(j+1, Color.GREEN);
        }
    }
}
