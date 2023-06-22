package com.algorithmx.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VisualizePanel extends JPanel {
    private final static int SIZE = 10;
    private final static int BOX_WIDTH = 50;
    private final static int BOX_HEIGHT = 50;
    private int[] array;
    private List<Integer> greenIndexesHighlight;
    private List<Integer> redIndexesHighlight;
    private Graphics2D g2d;
    private final Font font;
    private Color paintColor;

    public VisualizePanel() {
        setBackground(Color.DARK_GRAY);
        font = new Font("Calibri", Font.ITALIC, 14);
        array = new int[SIZE];
        greenIndexesHighlight = new ArrayList<>();
        redIndexesHighlight = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);

        int x = 10;
        int y = 10;
        for (int i = 0; i < SIZE; i++) {
            paintColor = Color.WHITE;
            if(greenIndexesHighlight.contains(i)) paintColor = Color.GREEN;
            if(redIndexesHighlight.contains(i)) paintColor = Color.RED;
            g2d.setColor(paintColor);
            g2d.drawRect(x, y, BOX_WIDTH, BOX_HEIGHT);
            g2d.drawString(String.valueOf(array[i]), x + (BOX_WIDTH / 2) - 5, y + (BOX_HEIGHT / 2) + 5);
            x += BOX_WIDTH;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] numbers) {
        this.array = numbers;
    }

    public void setGreenIndexesHighlight(List<Integer> greenIndexesHighlight) {
        this.greenIndexesHighlight = greenIndexesHighlight;
    }
    public void setRedIndexesHighlight(List<Integer> redIndexesHighlight) {
        this.redIndexesHighlight = redIndexesHighlight;
    }

    public List<Integer> getGreenIndexesHighlight() {
        return greenIndexesHighlight;
    }

    public List<Integer> getRedIndexesHighlight() {
        return redIndexesHighlight;
    }

    public void resetHighlighting() {
        setGreenIndexesHighlight(new ArrayList<>());
        setRedIndexesHighlight(new ArrayList<>());
        repaint();
    }
}
