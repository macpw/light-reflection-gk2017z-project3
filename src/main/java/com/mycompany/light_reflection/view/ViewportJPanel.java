package com.mycompany.light_reflection.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Paweł Mac
 */
public final class ViewportJPanel extends JPanel implements Observer {
    
    public ViewportJPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
