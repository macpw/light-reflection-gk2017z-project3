package com.mycompany.light_reflection.model;

import java.awt.geom.Point2D;

/**
 *
 * @author Paweł Mac
 */
public class Point3D {
    
    double x;
    double y;
    double z;
    private final Point2D point2D = new Point2D.Double();
    private boolean inFrontOfViewport;
    
    public Point3D() {
    }
    
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Getters and Setters
    
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getZ() {
        return z;
    }
    
    public void setZ(double z) {
        this.z = z;
    }
    
    public boolean isInFrontOfViewport() {
        return inFrontOfViewport;
    }
    
    public void setInFrontOfViewport(boolean inFrontOfViewport) {
        this.inFrontOfViewport = inFrontOfViewport;
    }
}
