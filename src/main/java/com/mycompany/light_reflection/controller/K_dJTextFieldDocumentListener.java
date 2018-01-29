package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class K_dJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public K_dJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double parsedDouble = Double.parseDouble(jTextField.getText());
            viewportModel.setK_d(parsedDouble);
            jTextField.setToolTipText("<html>k<sub>d</sub>="+viewportModel.getK_d()+"</html>");
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
