package com.algorithmx.panel;

import com.algorithmx.button.BubbleSortButton;
import com.algorithmx.button.GenerateArrayButton;
import com.algorithmx.button.SelectionSortButton;

import javax.swing.*;

public class ControlPanel extends JPanel {

    public ControlPanel(VisualizePanel visualizePanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new GenerateArrayButton(visualizePanel));
        add(new BubbleSortButton(visualizePanel));
        add(new SelectionSortButton(visualizePanel));
    }
}
