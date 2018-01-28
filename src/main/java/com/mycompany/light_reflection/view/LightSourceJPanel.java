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
    
    private final JTextField xJTextField = new JTextField(columnsForJTextField);
    private final JTextField yJTextField = new JTextField(columnsForJTextField);
    private final JTextField zJTextField = new JTextField(columnsForJTextField);
    
    public LightSourceJPanel() {
        xJTextField.setHorizontalAlignment(JTextField.CENTER);
        yJTextField.setHorizontalAlignment(JTextField.CENTER);
        zJTextField.setHorizontalAlignment(JTextField.CENTER);
        
        this.setBorder(new TitledBorder("Light Source"));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx++;
        gbc.gridy++;
        this.add(xJLabel, gbc);
        gbc.gridx++;
        this.add(xJTextField, gbc);
        gbc.gridx--;
        gbc.gridy++;
        this.add(yJLabel, gbc);
        gbc.gridx++;
        this.add(yJTextField, gbc);
        gbc.gridx--;
        gbc.gridy++;
        this.add(zJLabel, gbc);
        gbc.gridx++;
        this.add(zJTextField, gbc);
    }
    // Getters
    
    public JTextField getxJTextField() {
        return xJTextField;
    }
    
    public JTextField getyJTextField() {
        return yJTextField;
    }
    
    public JTextField getzJTextField() {
        return zJTextField;
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
