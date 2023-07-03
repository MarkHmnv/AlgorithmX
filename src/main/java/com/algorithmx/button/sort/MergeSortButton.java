package com.algorithmx.button.sort;

import com.algorithmx.button.AlgorithmButton;
import com.algorithmx.panel.VisualizePanel;

import java.awt.*;
import java.util.Random;

public class MergeSortButton extends AlgorithmButton {
    private final Random random;
    public MergeSortButton(VisualizePanel visualizePanel) {
        super(visualizePanel, "Merge Sort");
        random = new Random();
    }

    @Override
    protected void performAlgorithmWithDelay(int[] array) throws InterruptedException {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int start, int end) throws InterruptedException {
        if(end - start < 2 || stopFlag)
            return;

        Color color = generateRandomColor();
        visualizePanel.applyColorForRange(start, end, color);
        Thread.sleep(1000);

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) throws InterruptedException {
        if(array[mid - 1] <= array[mid] || stopFlag)
            return;

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while(i < mid && j< end && !stopFlag){
            int index = array[i] <= array[j] ? i++ : j++;
            visualizePanel.applyColorForIndex(index, Color.RED);
            temp[tempIndex++] = array[index];
            Thread.sleep(1000);
            visualizePanel.applyColorForIndex(index, Color.GREEN);
        }

        visualizePanel.applyColorForIndex(i, Color.RED);
        Thread.sleep(1000);

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);

        visualizePanel.applyColorForIndex(i, Color.GREEN);
        Thread.sleep(1000);
    }

    private Color generateRandomColor(){
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
}
