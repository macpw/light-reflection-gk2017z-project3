package com.mycompany.light_reflection.view;

import com.mycompany.light_reflection.view.util.FloatingPointDocumentFilter;
import com.mycompany.light_reflection.view.util.IntegerDocumentFilter;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;

/**
 *
 * @author Paweł Mac
 */
public final class PhongReflectionModelJPanel extends JPanel {
    
    private final JLabel formulaJLabel = new JLabel(
        "<html>"+
            "I = I<sub>a</sub>k<sub>a</sub> + "+
                "f<sub>att</sub>I<sub>p</sub>k<sub>d</sub>(N◦L) + "+
                "f<sub>att</sub>I<sub>p</sub>k<sub>s</sub>cos<sup>n</sup>α"+
        "</html>"
    );
    private final JLabel descriptionJLabel = new JLabel(
        "<html>"+
            "<p>I<sub>a</sub> - ambient lighting intensity</p>"+
            "<p>I<sub>p</sub> - intensity for a point light source</p>"+
            "<p>k<sub>a</sub> - ambient &nbsp;reflection constant [0,1]</p>"+
            "<p>k<sub>d</sub> - diffuse &nbsp;reflection constant [0,1]</p>"+
            "<p>k<sub>s</sub> - specular reflection constant [0,1]</p>"+
            "<p>"+
                "&nbsp;n - shininess constant for this material, <br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;which is larger for surfaces that <br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;are smoother and more mirror-like"+
            "</p>"+
            "<p>f<sub>att</sub> - damping factor of the source with distance</p>"+
            "<p>f<sub>att</sub> = 1/(c+d)</p>"+
            "<p>c - constant for f<sub>att</sub></p>"+
            "</html>"
    );
    
    private final JPanel descriptionJPanel = new JPanel(new GridBagLayout());
    
    private final JButton descriptionJButton = new JButton("show description");
    
    private final JLabel I_aJLabel = new JLabel("<html>I<sub>a</sub>=</html>");
    private final JLabel I_pJLabel = new JLabel("<html>I<sub>p</sub>=</html>");
    private final JTextField I_aJTextField = new JTextField(1);
    private final JTextField I_pJTextField = new JTextField(1);
    
    private final JLabel k_aJLabel = new JLabel("<html>k<sub>a</sub>=</html>");
    private final JLabel k_dJLabel = new JLabel("<html>k<sub>d</sub>=</html>");
    private final JLabel k_sJLabel = new JLabel("<html>k<sub>s</sub>=</html>");
    private final JTextField k_aJTextField = new JTextField(1);
    private final JTextField k_dJTextField = new JTextField(1);
    private final JTextField k_sJTextField = new JTextField(1);
    
    private final JLabel nJLabel = new JLabel("n=");
    private final JTextField nJTextField = new JTextField(1);
    private final JLabel cJLabel = new JLabel("c=");
    private final JTextField cJTextField = new JTextField(1);
    
    public PhongReflectionModelJPanel() {
        formulaJLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        descriptionJLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        I_aJTextField.setHorizontalAlignment(JTextField.CENTER);
        I_pJTextField.setHorizontalAlignment(JTextField.CENTER);
        k_aJTextField.setHorizontalAlignment(JTextField.CENTER);
        k_dJTextField.setHorizontalAlignment(JTextField.CENTER);
        k_sJTextField.setHorizontalAlignment(JTextField.CENTER);
        nJTextField.setHorizontalAlignment(JTextField.CENTER);
        cJTextField.setHorizontalAlignment(JTextField.CENTER);
        
        IntegerDocumentFilter integerDocumentFilter = new IntegerDocumentFilter();
        FloatingPointDocumentFilter floatingPointDocumentFilter = new FloatingPointDocumentFilter();
        
        Document I_aJTextFieldDocument = I_aJTextField.getDocument();
        ((AbstractDocument) I_aJTextFieldDocument).setDocumentFilter(integerDocumentFilter);
        Document I_pJTextFieldDocument = I_pJTextField.getDocument();
        ((AbstractDocument) I_pJTextFieldDocument).setDocumentFilter(integerDocumentFilter);
        Document k_aJTextFieldDocument = k_aJTextField.getDocument();
        ((AbstractDocument) k_aJTextFieldDocument).setDocumentFilter(floatingPointDocumentFilter);
        Document k_dJTextFieldDocument = k_dJTextField.getDocument();
        ((AbstractDocument) k_dJTextFieldDocument).setDocumentFilter(floatingPointDocumentFilter);
        Document k_sJTextFieldDocument = k_sJTextField.getDocument();
        ((AbstractDocument) k_sJTextFieldDocument).setDocumentFilter(floatingPointDocumentFilter);
        Document nJTextFieldDocument = nJTextField.getDocument();
        ((AbstractDocument) nJTextFieldDocument).setDocumentFilter(integerDocumentFilter);
        Document cJTextFieldDocument = cJTextField.getDocument();
        ((AbstractDocument) cJTextFieldDocument).setDocumentFilter(floatingPointDocumentFilter);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel luminousIntensityJPanel = new JPanel(new GridBagLayout());
        gbc.weightx = 0.05d;
        gbc.weighty = 0.05d;
        gbc.gridx++;
        gbc.gridy++;
        luminousIntensityJPanel.add(I_aJLabel, gbc);
        gbc.gridy++;
        luminousIntensityJPanel.add(I_pJLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.gridx++;
        gbc.gridy--;
        luminousIntensityJPanel.add(I_aJTextField, gbc);
        gbc.gridy++;
        luminousIntensityJPanel.add(I_pJTextField, gbc);
        
        JPanel kJPanel = new JPanel(new GridBagLayout());
        
        gbc.gridy = GridBagConstraints.RELATIVE;// default
        gbc.gridx = GridBagConstraints.RELATIVE;// default
        gbc.weightx = 0.05d;
        gbc.weighty = 0.05d;
        gbc.fill = GridBagConstraints.NONE;// default
        gbc.gridy++;
        gbc.gridx++;
        kJPanel.add(k_aJLabel, gbc);
        gbc.gridy++;
        kJPanel.add(k_dJLabel, gbc);
        gbc.gridy++;
        kJPanel.add(k_sJLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.gridy = 0;
        gbc.gridx++;
        kJPanel.add(k_aJTextField, gbc);
        gbc.gridy++;
        kJPanel.add(k_dJTextField, gbc);
        gbc.gridy++;
        kJPanel.add(k_sJTextField, gbc);
        
        JPanel ncJPanel = new JPanel(new GridBagLayout());
        gbc.gridy = GridBagConstraints.RELATIVE;// default
        gbc.gridx = GridBagConstraints.RELATIVE;// default
        gbc.weightx = 0.05d;
        gbc.weighty = 0.05d;
        gbc.fill = GridBagConstraints.NONE;// default
        gbc.gridy++;
        gbc.gridx++;
        ncJPanel.add(nJLabel, gbc);
        gbc.gridy++;
        ncJPanel.add(cJLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.gridy = 0;
        gbc.gridx++;
        ncJPanel.add(nJTextField, gbc);
        gbc.gridy++;
        ncJPanel.add(cJTextField, gbc);
        
        descriptionJPanel.setBorder(new TitledBorder("description"));
        descriptionJPanel.add(descriptionJLabel);
        descriptionJPanel.setVisible(false);
        
        this.setBorder(new TitledBorder("Phong Model"));
        this.setLayout(new GridBagLayout());
        
        gbc.gridy = GridBagConstraints.RELATIVE;// default
        gbc.gridx = GridBagConstraints.RELATIVE;// default
        gbc.weightx = 0.0d;// default
        gbc.weighty = 0.0d;// default
        gbc.fill = GridBagConstraints.NONE;// default
        gbc.gridx++;
        gbc.gridy++;
        gbc.gridwidth = 3;
        this.add(formulaJLabel, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;// default
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        this.add(luminousIntensityJPanel, gbc);
        gbc.gridx++;
        this.add(kJPanel, gbc);
        gbc.gridx++;
        this.add(ncJPanel, gbc);
        gbc.weightx = 0.0d;// default
        gbc.weighty = 0.0d;// default
        gbc.fill = GridBagConstraints.NONE;// default
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        this.add(descriptionJButton, gbc);
        gbc.gridy++;
        this.add(descriptionJPanel, gbc);
    }
    
    // Getters
    
    public JLabel getDescriptionJLabel() {    
        return descriptionJLabel;
    }
    
    public JPanel getDescriptionJPanel() {
        return descriptionJPanel;
    }
    
    public JButton getDescriptionJButton() {
        return descriptionJButton;
    }
    
    public JTextField getI_aJTextField() {
        return I_aJTextField;
    }
    
    public JTextField getI_pJTextField() {
        return I_pJTextField;
    }
    
    public JTextField getK_aJTextField() {
        return k_aJTextField;
    }
    
    public JTextField getK_dJTextField() {
        return k_dJTextField;
    }
    
    public JTextField getK_sJTextField() {
        return k_sJTextField;
    }
    
    public JTextField getnJTextField() {
        return nJTextField;
    }
    
    public JTextField getcJTextField() {    
        return cJTextField;
    }
    
    // Test PhongReflectionModelJPanel
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Test -- "+PhongReflectionModelJPanel.class.getSimpleName());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(120, 90));
        
        JPanel mainJPanel = new JPanel();
        jFrame.add(mainJPanel);
        PhongReflectionModelJPanel phongReflectionModelJPanel = new PhongReflectionModelJPanel();
        mainJPanel.add(phongReflectionModelJPanel);
        
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
