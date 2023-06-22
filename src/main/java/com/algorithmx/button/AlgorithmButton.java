package com.algorithmx.button;

import com.algorithmx.panel.ControlPanel;
import com.algorithmx.panel.VisualizePanel;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;

public abstract class AlgorithmButton extends JButton {
    protected final VisualizePanel visualizePanel;
    private static ControlPanel controlPanel;

    public AlgorithmButton(VisualizePanel visualizePanel, String text) {
        this.visualizePanel = visualizePanel;
        this.setText(text);
        this.addActionListener(e -> onClick());
    }

    public void onClick() {
        initializeControlPanelIfNull();
        controlPanel.setEnabledForAllButtons(false);
        int[] array = visualizePanel.getArray();

        CompletableFuture.runAsync(() -> {
            try {
                performAlgorithmWithDelay(array);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).thenRun(() -> {
            controlPanel.setEnabledForAllButtons(true);
            visualizePanel.resetHighlighting();
            JOptionPane.showMessageDialog(
                    visualizePanel,
                    "Algorithm completed",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }

    protected abstract void performAlgorithmWithDelay(int[] array) throws InterruptedException;

    @Override
    public String toString() {
        return this.getText();
    }

    private void initializeControlPanelIfNull() {
        if(controlPanel == null)
            controlPanel = (ControlPanel) SwingUtilities.getAncestorOfClass(ControlPanel.class, this);
    }
}
