package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class K_aJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public K_aJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double d = Double.parseDouble(jTextField.getText());
            viewportModel.setK_a(d);
            jTextField.setToolTipText("<html>k<sub>a</sub>="+viewportModel.getK_a()+"</html>");
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
