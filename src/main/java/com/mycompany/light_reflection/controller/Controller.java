package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import com.mycompany.light_reflection.view.FocalDistanceJPanel;
import com.mycompany.light_reflection.view.LightSourceJPanel;
import com.mycompany.light_reflection.view.PhongReflectionModelJPanel;
import com.mycompany.light_reflection.view.View;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Paweł Mac
 */
public class Controller {
    
    private Controller() {
    }
    
    public static void controller(final ViewportModel viewportModel, final View view) {
        Controller.addListener(viewportModel, view);
    }
    
    private static void addListener(ViewportModel viewportModel, View view) {
        PhongReflectionModelJPanel phongReflectionModelJPanel = view.getPhongReflectionModelJPanel();
        LightSourceJPanel lightSourceJPanel = view.getLightSourceJPanel();
        FocalDistanceJPanel focalDistanceJPanel = view.getFocalDistanceJPanel();
        
        JButton descriptionJButton = phongReflectionModelJPanel.getDescriptionJButton();
        JTextField i_aJTextField = phongReflectionModelJPanel.getI_aJTextField();
        JTextField i_pJTextField = phongReflectionModelJPanel.getI_pJTextField();
        JTextField k_aJTextField = phongReflectionModelJPanel.getK_aJTextField();
        JTextField k_dJTextField = phongReflectionModelJPanel.getK_dJTextField();
        JTextField k_sJTextField = phongReflectionModelJPanel.getK_sJTextField();
        JTextField nJTextField = phongReflectionModelJPanel.getnJTextField();
        JTextField cJTextField = phongReflectionModelJPanel.getcJTextField();
        JTextField lightSourceXJTextField = lightSourceJPanel.getLightSourceXJTextField();
        JTextField lightSourceYJTextField = lightSourceJPanel.getLightSourceYJTextField();
        JTextField lightSourceZJTextField = lightSourceJPanel.getLightSourceZJTextField();
        JLabel focalDistanceJLabel = focalDistanceJPanel.getFocalDistanceJLabel();
        JSlider focalDistanceJSlider = focalDistanceJPanel.getFocalDistanceJSlider();
        
        i_aJTextField.setText(Integer.toString((int)viewportModel.getI_a()));
        i_aJTextField.setToolTipText("<html>I<sub>a</sub>="+(int)viewportModel.getI_a()+"</html>");
        i_pJTextField.setText(Integer.toString((int)viewportModel.getI_p()));
        i_pJTextField.setToolTipText("<html>I<sub>p</sub>="+(int)viewportModel.getI_p()+"</html>");
        k_aJTextField.setText(Double.toString(viewportModel.getK_a()));
        k_aJTextField.setToolTipText("<html>k<sub>a</sub>="+viewportModel.getK_a()+"</html>");
        k_dJTextField.setText(Double.toString(viewportModel.getK_d()));
        k_dJTextField.setToolTipText("<html>k<sub>d</sub>="+viewportModel.getK_d()+"</html>");
        k_sJTextField.setText(Double.toString(viewportModel.getK_s()));
        k_sJTextField.setToolTipText("<html>k<sub>s</sub>="+viewportModel.getK_s()+"</html>");
        nJTextField.setText(Integer.toString((int)viewportModel.getN()));
        nJTextField.setToolTipText("n="+viewportModel.getN());
        cJTextField.setText(Double.toString(viewportModel.getC()));
        cJTextField.setToolTipText("c="+viewportModel.getC());
        lightSourceXJTextField.setText(Integer.toString((int)viewportModel.getLightX()));
        lightSourceXJTextField.setToolTipText("x="+(int)viewportModel.getLightX());
        lightSourceYJTextField.setText(Integer.toString((int)viewportModel.getLightY()));
        lightSourceYJTextField.setToolTipText("y="+(int)viewportModel.getLightY());
        lightSourceZJTextField.setText(Integer.toString((int)viewportModel.getLightZ()));
        lightSourceZJTextField.setToolTipText("z="+(int)viewportModel.getLightZ());
        
        focalDistanceJLabel.setText(Integer.toString((int) viewportModel.getFocalDistance()));
        focalDistanceJSlider.setValue((int) viewportModel.getFocalDistance());
        
        DescriptionJButtonAction descriptionJButtonAction = new DescriptionJButtonAction(view);
        descriptionJButton.addActionListener(descriptionJButtonAction);
        
        I_aJTextFieldDocumentListener i_aJTextFieldDocumentListener = new I_aJTextFieldDocumentListener(viewportModel, i_aJTextField);
        i_aJTextField.getDocument().addDocumentListener(i_aJTextFieldDocumentListener);
        
        I_pJTextFieldDocumentListener i_pJTextFieldDocumentListener = new I_pJTextFieldDocumentListener(viewportModel, i_pJTextField);
        i_pJTextField.getDocument().addDocumentListener(i_pJTextFieldDocumentListener);
        
        K_aJTextFieldDocumentListener k_aJTextFieldDocumentListener = new K_aJTextFieldDocumentListener(viewportModel, k_aJTextField);
        k_aJTextField.getDocument().addDocumentListener(k_aJTextFieldDocumentListener);
        
        K_dJTextFieldDocumentListener k_dJTextFieldDocumentListener = new K_dJTextFieldDocumentListener(viewportModel, k_dJTextField);
        k_dJTextField.getDocument().addDocumentListener(k_dJTextFieldDocumentListener);
        
        K_sJTextFieldDocumentListener k_sJTextFieldDocumentListener = new K_sJTextFieldDocumentListener(viewportModel, k_sJTextField);
        k_sJTextField.getDocument().addDocumentListener(k_sJTextFieldDocumentListener);
        
        NJTextFieldDocumentListener nJTextFieldDocumentListener = new NJTextFieldDocumentListener(viewportModel, nJTextField);
        nJTextField.getDocument().addDocumentListener(nJTextFieldDocumentListener);
        
        CJTextFieldDocumentListener cJTextFieldDocumentListener = new CJTextFieldDocumentListener(viewportModel, cJTextField);
        cJTextField.getDocument().addDocumentListener(cJTextFieldDocumentListener);
        
        LightSourceXJTextFieldDocumentListener lightSourceXJTextFieldDocumentListener = new LightSourceXJTextFieldDocumentListener(viewportModel, lightSourceXJTextField);
        lightSourceXJTextField.getDocument().addDocumentListener(lightSourceXJTextFieldDocumentListener);
        
        LightSourceYJTextFieldDocumentListener lightSourceYJTextFieldDocumentListener = new LightSourceYJTextFieldDocumentListener(viewportModel, lightSourceYJTextField);
        lightSourceYJTextField.getDocument().addDocumentListener(lightSourceYJTextFieldDocumentListener);
        
        LightSourceZJTextFieldDocumentListener lightSourceZJTextFieldDocumentListener = new LightSourceZJTextFieldDocumentListener(viewportModel, lightSourceZJTextField);
        lightSourceZJTextField.getDocument().addDocumentListener(lightSourceZJTextFieldDocumentListener);
        
        FocalDistanceJSliderChangeListener focalDistanceJSliderChangeListener = new FocalDistanceJSliderChangeListener(viewportModel, focalDistanceJLabel);
        focalDistanceJSlider.addChangeListener(focalDistanceJSliderChangeListener);
    }
}
