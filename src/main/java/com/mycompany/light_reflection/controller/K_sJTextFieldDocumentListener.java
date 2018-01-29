package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class K_sJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public K_sJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double parsedDouble = Double.parseDouble(jTextField.getText());
            viewportModel.setK_s(parsedDouble);
            jTextField.setToolTipText("<html>k<sub>s</sub>="+viewportModel.getK_s()+"</html>");
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
