package com.mycompany.light_reflection.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Paweł Mac
 */
public class View {
    
    private final ViewportJPanel viewportJPanel;
    //private final FocalDistanceJPanel focalDistanceJPanel = new FocalDistanceJPanel();
    private final PhongReflectionModelJPanel phongReflectionModelJPanel = new PhongReflectionModelJPanel();
    private final LightSourceJPanel lightSourceJPanel = new LightSourceJPanel();
    
    public View(int viewportWidth, int viewportHeight) {
        this.viewportJPanel = new ViewportJPanel(viewportWidth, viewportHeight);
        this.createAndShowGui();
    }
    
    // Getters
    
    public ViewportJPanel getViewportJPanel() {
        return viewportJPanel;
    }
    
    //public FocalDistanceJPanel getFocalDistanceJPanel() {
    //    return focalDistanceJPanel;
    //}
    
    public PhongReflectionModelJPanel getPhongReflectionModelJPanel() {
        return phongReflectionModelJPanel;
    }
    
    public LightSourceJPanel getLightSourceJPanel() {
        return lightSourceJPanel;
    }
    
    // Methods
    
    private void createAndShowGui() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(160, 120));
        
        JPanel mainJPanel = new JPanel();
        JScrollPane mainJScrollPane = new JScrollPane(mainJPanel);
        jFrame.add(mainJScrollPane);
        this.addComponentsToPane(mainJPanel);
        
        jFrame.pack();
        Dimension verticalScrollBarPreferredSize = mainJScrollPane.getVerticalScrollBar().getPreferredSize();
        Dimension horizontalScrollBarPreferredSize = mainJScrollPane.getHorizontalScrollBar().getPreferredSize();
        Dimension preferredSize = jFrame.getPreferredSize();
        Dimension minimumSize = new Dimension(
                preferredSize.width  + verticalScrollBarPreferredSize.width, 
                preferredSize.height + horizontalScrollBarPreferredSize.height
        );
        jFrame.setMinimumSize(minimumSize);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    
    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel controlJPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        pane.add(viewportJPanel, gbc);
        pane.add(controlJPanel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        
        gbc.gridx = GridBagConstraints.RELATIVE; // back to default
        gbc.gridwidth = 2; // focalDistanceJPanel width
        //controlJPanel.add(focalDistanceJPanel, gbc);
        gbc.gridwidth = 1; // back to default
        gbc.gridy = 1;
        controlJPanel.add(phongReflectionModelJPanel, gbc);
        gbc.anchor = GridBagConstraints.NORTH;
        controlJPanel.add(lightSourceJPanel, gbc);
    }
    
    // Test View
    public static void main(String[] args) {
        new View(600, 400);
    }
}
