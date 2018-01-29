package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class LightSourceZJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public LightSourceZJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double parsedDouble = Double.parseDouble(jTextField.getText());
            viewportModel.setLightZ(parsedDouble);
            jTextField.setToolTipText("z="+(int)viewportModel.getLightZ());
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
