package com.mycompany.light_reflection;

import com.mycompany.light_reflection.controller.Controller;
import com.mycompany.light_reflection.model.ViewportModel;
import com.mycompany.light_reflection.view.View;
import com.mycompany.light_reflection.view.ViewportJPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paweł Mac
 */
public class RunMVC implements Runnable {
    
    public RunMVC() {
    }
    
    @Override
    public void run() {
        ViewportModel viewportModel = new ViewportModel(600, 400);
        View view = new View(viewportModel.getViewportWidth(), viewportModel.getViewportHeight());
        ViewportJPanel viewportJPanel = view.getViewportJPanel();
        viewportJPanel.setViewportModel(viewportModel);
        viewportModel.addObserver(viewportJPanel);
        Controller.controller(viewportModel, view);
    }
    
    // Test RunMVC
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new RunMVC());
    }
}
