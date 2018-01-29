package com.mycompany.light_reflection.model;

import java.awt.Color;
import java.util.Observable;

/**
 *
 * @author Paweł Mac
 */
public class ViewportModel extends Observable {
    
    private final int viewportWidth;
    private final int viewportHeight;
    private double focalDistance = 200;// distance between observer and viewport
    private final Point3D light = new Point3D(-200, +500, +200);
    private final Sphere sphere = new Sphere(0, 0, 400, 200, Color.magenta, Color.cyan);
    
    double I_a = 125;
    double I_p = 250;
    double n = 100;
    double k_a = 0.99;
    double k_d = 0.85;
    double k_s = 0.25;
    double c = 0.20;
    
    public ViewportModel(int viewportWidth, int viewportHeight) {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
    }
    
    // Getters
    
    public int getViewportWidth() {
        return viewportWidth;
    }
    
    public int getViewportHeight() {
        return viewportHeight;
    }
    
    public Point3D getLight() {
        return light;
    }
    
    public Sphere getSphere() {    
        return sphere;
    }
    
    // Getters and Setters
    
    public double getFocalDistance() {
        return focalDistance;
    }
    
    public void setFocalDistance(double focalDistance) {    
        this.focalDistance = focalDistance;
    }
    
    public double getI_a() {
        return I_a;
    }
    
    public void setI_a(double I_a) {
        this.I_a = I_a;
        this.update();
    }
    
    public double getI_p() {
        return I_p;
    }
    
    public void setI_p(double I_p) {
        this.I_p = I_p;
        this.update();
    }
    
    public double getN() {
        return n;
    }
    
    public void setN(double n) {
        this.n = n;
        this.update();
    }
    
    public double getK_a() {
        return k_a;
    }
    
    public void setK_a(double k_a) {
        this.k_a = k_a;
        this.update();
    }
    
    public double getK_d() {
        return k_d;
    }
    
    public void setK_d(double k_d) {
        this.k_d = k_d;
        this.update();
    }
    
    public double getK_s() {
        return k_s;
    }
    
    public void setK_s(double k_s) {
        this.k_s = k_s;
        this.update();
    }
    
    public double getC() {
        return c;
    }
    
    public void setC(double c) {
        this.c = c;
        this.update();
    }
    
    // Delegated Getters and Setters
    
    public double getLightX() {
        return light.getX();
    }
    
    public void setLightX(double x) {
        light.setX(x);
        this.update();
    }
    
    public double getLightY() {
        return light.getY();
    }
    
    public void setLightY(double y) {
        light.setY(y);
        this.update();
    }
    
    public double getLightZ() {
        return light.getZ();
    }
    
    public void setLightZ(double z) {
        light.setZ(z);
        this.update();
    }
    
    // Methods
    
    private void update() {
        this.setChanged();
        this.notifyObservers();
    }
}
