package com.mycompany.light_reflection.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Paweł Mac
 */
public final class LightSourceJPanel extends JPanel {
    
    private final int columnsForJTextField = 7;
    
    private final JLabel xJLabel = new JLabel("x = ");
    private final JLabel yJLabel = new JLabel("y = ");
    private final JLabel zJLabel = new JLabel("z = ");
    
    private final JTextField lightSourceXJTextField = new JTextField(columnsForJTextField);
    private final JTextField lightSourceYJTextField = new JTextField(columnsForJTextField);
    private final JTextField lightSourceZJTextField = new JTextField(columnsForJTextField);
    
    public LightSourceJPanel() {
        lightSourceXJTextField.setHorizontalAlignment(JTextField.CENTER);
        lightSourceYJTextField.setHorizontalAlignment(JTextField.CENTER);
        lightSourceZJTextField.setHorizontalAlignment(JTextField.CENTER);
        
        this.setBorder(new TitledBorder("Light Source"));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx++;
        gbc.gridy++;
        this.add(xJLabel, gbc);
        gbc.gridx++;
        this.add(lightSourceXJTextField, gbc);
        gbc.gridx--;
        gbc.gridy++;
        this.add(yJLabel, gbc);
        gbc.gridx++;
        this.add(lightSourceYJTextField, gbc);
        gbc.gridx--;
        gbc.gridy++;
        this.add(zJLabel, gbc);
        gbc.gridx++;
        this.add(lightSourceZJTextField, gbc);
    }
    // Getters
    
    public JTextField getLightSourceXJTextField() {
        return lightSourceXJTextField;
    }
    
    public JTextField getLightSourceYJTextField() {
        return lightSourceYJTextField;
    }
    
    public JTextField getLightSourceZJTextField() {
        return lightSourceZJTextField;
    }
    
    // Test LightSourceJPanel
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Test -- "+LightSourceJPanel.class.getSimpleName());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(120, 90));
        
        JPanel mainJPanel = new JPanel();
        jFrame.add(mainJPanel);
        LightSourceJPanel lightSourceJPanel = new LightSourceJPanel();
        mainJPanel.add(lightSourceJPanel);
        
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
