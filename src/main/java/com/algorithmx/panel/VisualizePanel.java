package com.algorithmx.panel;

import javax.swing.*;
import java.awt.*;

public class VisualizePanel extends JPanel {
    private final static int SIZE = 10;
    private int[] array;
    private int greenIndexHighlight;
    private int redIndexHighlight = -1;
    private Graphics2D g2d;
    private final Font font;
    private Color paintColor;

    public VisualizePanel() {
        setBackground(Color.DARK_GRAY);
        font = new Font("Calibri", Font.ITALIC, 14);
        array = new int[SIZE];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);

        int boxWidth = 50;
        int boxHeight = 50;
        int x = 10;
        int y = 10;
        for (int i = 0; i < SIZE; i++) {
            if(i == greenIndexHighlight) paintColor = Color.GREEN;
            else if(i == redIndexHighlight) paintColor = Color.RED;
            else paintColor = Color.WHITE;
            g2d.setColor(paintColor);
            g2d.drawRect(x, y, boxWidth, boxHeight);
            g2d.drawString(String.valueOf(array[i]), x + (boxWidth / 2) - 5, y + (boxHeight / 2) + 5);
            x += boxWidth;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] numbers) {
        this.array = numbers;
    }

    public void setGreenIndexHighlight(int greenIndexHighlight) {
        this.greenIndexHighlight = greenIndexHighlight;
    }
    public void setRedIndexHighlight(int redIndexHighlight) {
        this.redIndexHighlight = redIndexHighlight;
    }
}
