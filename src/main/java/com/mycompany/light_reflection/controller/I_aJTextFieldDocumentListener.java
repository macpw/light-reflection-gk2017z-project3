package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class I_aJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public I_aJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double d = Double.parseDouble(jTextField.getText());
            viewportModel.setI_a(d);
            jTextField.setToolTipText("<html>I<sub>a</sub>="+viewportModel.getI_a()+"</html>");
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
