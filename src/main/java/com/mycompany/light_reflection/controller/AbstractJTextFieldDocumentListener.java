package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Paweł Mac
 */
public abstract class AbstractJTextFieldDocumentListener implements DocumentListener {
    
    protected static final int DELAY = 500;
    protected final ActionListenerForTimer actionListenerForTimer = new ActionListenerForTimer();
    protected final javax.swing.Timer timer = new Timer(DELAY, actionListenerForTimer);
    
    protected final ViewportModel viewportModel;
    protected final JTextField jTextField;
    
    public AbstractJTextFieldDocumentListener(ViewportModel viewportModel, JTextField jTextField) {
        this.viewportModel = viewportModel;
        this.jTextField = jTextField;
    }
    
    abstract protected void doUpdate();
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        jTextField.setBackground(Color.lightGray);
        timer.restart();
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        jTextField.setBackground(Color.lightGray);
        timer.restart();
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected class ActionListenerForTimer implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            jTextField.setBackground(Color.white);
            doUpdate();
        }
    }
}
