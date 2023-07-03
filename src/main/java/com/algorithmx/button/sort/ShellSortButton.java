package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.awt.*;

import static com.algorithmx.utils.AlgorithmUtils.swap;

public class ShellSortButton extends AlgorithmButton {
    public ShellSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Shell Sort");
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        int newElementInArray;
        int j;
        for(int gap = array.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < array.length; i++){
                if(stopFlag) return;
                newElementInArray = array[i];
                j = i;
                if(!visualizePanel.getIndexColorMap().containsKey(i)){
                    visualizePanel.applyColorForIndex(i, Color.GREEN);
                    Thread.sleep(1000);
                }
                while(j >= gap && array[j - gap] > newElementInArray && !stopFlag){
                    visualizePanel.applyColorForIndex(j+1, Color.RED);
                    Thread.sleep(500);
                    swap(array, j, j - gap);
                    visualizePanel.applyColorForIndex(j+1, Color.GREEN);
                    j -= gap;
                }
            }
        }
    }
}
