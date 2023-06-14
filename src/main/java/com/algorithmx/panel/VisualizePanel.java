package com.algorithmx.panel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualizePanel extends JPanel {
    private final static int SIZE = 10;
    private int[] array;
    private int indexToHighlight;

    public VisualizePanel() {
        setBackground(Color.DARK_GRAY);
        Random random = new Random();
        array = new int[SIZE];
        for(int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(-SIZE, SIZE);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int boxWidth = 50;
        int boxHeight = 50;
        int x = 10;
        int y = 10;

        Font font = new Font("Calibri", Font.ITALIC, 14);
        g.setFont(font);

        for (int i = 0; i < SIZE; i++) {
            Color color = (i == indexToHighlight) ? Color.GREEN : Color.WHITE;
            g.setColor(color);
            g.drawRect(x, y, boxWidth, boxHeight);
            g.drawString(String.valueOf(array[i]), x + (boxWidth / 2) - 5, y + (boxHeight / 2) + 5);
            x += boxWidth;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] numbers) {
        this.array = numbers;
    }

    public void setIndexToHighlight(int indexToHighlight) {
        this.indexToHighlight = indexToHighlight;
    }
}
