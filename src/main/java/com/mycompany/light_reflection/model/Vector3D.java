package com.mycompany.light_reflection.model;

/**
 *
 * @author Paweł Mac
 */
public class Vector3D {
    
    private double x;
    private double y;
    private double z;
    
    public Vector3D(double x, double y, double z) {
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
    
    // Methods
    
    public double length() {
        return Math.sqrt(x*x+y*y+z*z);
    }
    
    public void normalize() {
        double length = length();
        if (length > 0) {
            x = x/length;
            y = y/length;
            z = z/length;
        }
    }
    
    // Static Methods
    
    public static double dotProduct(Vector3D v, Vector3D u) {
        return v.x*u.x + v.y*u.y + v.z*u.z;
    }
}
