package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class I_pJTextFieldDocumentListener extends AbstractJTextFieldDocumentListener {
    
    public I_pJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        super(viewportModel, jTextField);
    }
    
    @Override
    protected void doUpdate() {
        try {
            double d = Double.parseDouble(jTextField.getText());
            viewportModel.setI_p(d);
            jTextField.setToolTipText("<html>I<sub>p</sub>="+(int)viewportModel.getI_p()+"</html>");
        } catch (NumberFormatException nfe) {
            jTextField.setBackground(Color.orange);
        }
    }
}
