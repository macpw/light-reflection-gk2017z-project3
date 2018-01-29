package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class LightSourceYJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public LightSourceYJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double parsedDouble = Double.parseDouble(jTextField.getText());
            viewportModel.setLightY(parsedDouble);
            jTextField.setToolTipText("y="+(int)viewportModel.getLightY());
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
