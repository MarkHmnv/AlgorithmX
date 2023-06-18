package com.algorithmx.panel;

import com.algorithmx.button.sort.BubbleSortButton;
import com.algorithmx.button.GenerateArrayButton;
import com.algorithmx.button.sort.SelectionSortButton;

import javax.swing.*;
import java.util.List;

public class ControlPanel extends JPanel {
    private final List<JButton> buttons;

    public ControlPanel(VisualizePanel visualizePanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buttons = List.of(
                new GenerateArrayButton(visualizePanel),
                new BubbleSortButton(visualizePanel),
                new SelectionSortButton(visualizePanel)
        );

        for (JButton button : buttons) {
            add(button);
        }
    }

    public void setEnabledForAllButtons(boolean enabled) {
        for(JButton button : buttons) {
            button.setEnabled(enabled);
        }
    }
}
