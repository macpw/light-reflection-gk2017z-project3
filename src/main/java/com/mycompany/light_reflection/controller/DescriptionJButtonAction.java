package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.view.View;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paweł Mac
 */
public class DescriptionJButtonAction extends AbstractAction {
    
    private final JPanel descriptionJPanel;
    private final JButton descriptionJButton;
    private final JFrame topJFrame;
    
    public DescriptionJButtonAction(View view) {
        this.descriptionJButton = view.getPhongReflectionModelJPanel().getDescriptionJButton();
        this.descriptionJPanel = view.getPhongReflectionModelJPanel().getDescriptionJPanel();
        this.topJFrame = (JFrame) SwingUtilities.getWindowAncestor(descriptionJPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (descriptionJPanel.isVisible()) {
            descriptionJPanel.setVisible(false);
            topJFrame.pack();
            descriptionJButton.setText("show description");
        } else {
            descriptionJPanel.setVisible(true);
            descriptionJButton.setText("hide description");
        }
    }
}
