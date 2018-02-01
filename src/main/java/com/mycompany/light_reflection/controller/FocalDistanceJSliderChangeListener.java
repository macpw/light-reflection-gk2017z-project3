package com.mycompany.light_reflection.controller;

import com.mycompany.light_reflection.model.ViewportModel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Paweł Mac
 */
public class FocalDistanceJSliderChangeListener implements ChangeListener {
    
    private final ViewportModel viewportModel;
    private final JLabel focalDistanceJLabel;

    public FocalDistanceJSliderChangeListener(ViewportModel viewportModel, JLabel focalDistanceJLabel) {
        this.viewportModel = viewportModel;
        this.focalDistanceJLabel = focalDistanceJLabel;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider sourceJSlider = (JSlider) e.getSource();
        if (!sourceJSlider.getValueIsAdjusting()) {
            int value = sourceJSlider.getValue();
            viewportModel.setFocalDistance((double)value);
            focalDistanceJLabel.setText(Integer.toString(value));
        }
    }
}
