package com.algorithmx.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisualizePanel extends JPanel {
    private static final int SIZE = 10;
    private static final int BOX_WIDTH = 50;
    private static final int BOX_HEIGHT = 50;
    private final Map<Integer, Color> indexColorMap;

    private int[] array;
    private final Font font;
    private Color paintColor;

    public VisualizePanel() {
        setBackground(Color.DARK_GRAY);
        font = new Font("Calibri", Font.ITALIC, 14);
        array = new int[SIZE];
        indexColorMap = new HashMap<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);

        drawExplanations(g2d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);

        int x = 10;
        int y = 10;
        int textOffsetX = BOX_WIDTH / 2 - 5;
        int textOffsetY = BOX_HEIGHT / 2 + 5;

        for (int i = 0; i < SIZE; i++) {
            paintColor = indexColorMap.getOrDefault(i, Color.WHITE);
            g2d.setColor(paintColor);
            g2d.drawRect(x, y, BOX_WIDTH, BOX_HEIGHT);
            g2d.drawString(String.valueOf(array[i]), x + textOffsetX, y + textOffsetY);
            x += BOX_WIDTH;
        }
    }


    public void applyColorForIndex(int index, Color color) {
        indexColorMap.put(index, color);
        repaint();
    }

    public void removeColorForIndex(int j) {
        indexColorMap.remove(j);
        repaint();
    }

    public void applyColorForRange(int start, int end, Color color) {
        for (int i = start; i < end; i++) {
            indexColorMap.put(i, color);
        }
        repaint();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] numbers) {
        this.array = numbers;
    }

    public Map<Integer, Color> getIndexColorMap() {
        return indexColorMap;
    }

    public void resetHighlighting() {
        indexColorMap.clear();
        repaint();
    }

    private void drawExplanations(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.drawRect(10, getHeight() - 100, 30, 30);

        g2d.setColor(Color.RED);
        g2d.drawRect(10, getHeight() - 50, 30, 30);

        g2d.setColor(Color.WHITE);
        g2d.drawString("- Sorted Array", 50, getHeight() - 80);
        g2d.drawString("- Current Element", 50, getHeight() - 30);
    }
}
