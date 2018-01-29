package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class LightSourceXJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public LightSourceXJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double parsedDouble = Double.parseDouble(jTextField.getText());
            viewportModel.setLightX(parsedDouble);
            jTextField.setToolTipText("x="+(int)viewportModel.getLightX());
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
