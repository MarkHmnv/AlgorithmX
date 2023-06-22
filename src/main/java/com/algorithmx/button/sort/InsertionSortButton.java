package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.util.ArrayList;
import java.util.List;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class InsertionSortButton extends AlgorithmButton {
    public InsertionSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Insertion Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        int newElementInArray;
        int j;
        visualizePanel.getGreenIndexesHighlight().add(0);
        for (int i = 1; i < array.length; i++) {
            newElementInArray = array[i];
            j = i - 1;
            visualizePanel.getGreenIndexesHighlight().add(i);
            visualizePanel.repaint();
            Thread.sleep(1000);
            if(array[j] > newElementInArray) {
                while (j >= 0 && array[j] > newElementInArray) {
                    visualizePanel.setRedIndexesHighlight(new ArrayList<>(List.of(j+1)));
                    visualizePanel.repaint();
                    Thread.sleep(500);
                    swap(array, j, j + 1);
                    j--;
                }
                visualizePanel.setRedIndexesHighlight(new ArrayList<>(List.of(j+1)));
                visualizePanel.repaint();
                Thread.sleep(500);
            }
            visualizePanel.getRedIndexesHighlight().clear();
        }
    }
}
