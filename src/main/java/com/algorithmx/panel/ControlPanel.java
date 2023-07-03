package com.algorithmx.panel;

import com.algorithmx.button.StopAlgorithmButton;
import com.algorithmx.button.sort.*;
import com.algorithmx.button.GenerateArrayButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ControlPanel extends JPanel {
    private final List<JButton> buttons;

    public ControlPanel(VisualizePanel visualizePanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        buttons = createAlgorithmButtons(visualizePanel);
        buttons.forEach(button -> add(button, gbc));

        add(new StopAlgorithmButton(), gbc);
    }

    public void setEnabledForAllButtons(boolean enabled) {
        buttons.forEach(button -> button.setEnabled(enabled));
    }

    private List<JButton> createAlgorithmButtons(VisualizePanel visualizePanel) {
        return List.of(
                new GenerateArrayButton(visualizePanel),
                new BubbleSortButton(visualizePanel),
                new SelectionSortButton(visualizePanel),
                new InsertionSortButton(visualizePanel),
                new ShellSortButton(visualizePanel),
                new MergeSortButton(visualizePanel)
        );
    }
}
