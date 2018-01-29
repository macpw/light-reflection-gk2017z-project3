package com.mycompany.light_reflection.model;

import java.awt.Color;

/**
 *
 * @author Paweł Mac
 */
public class Sphere {
    
    Point3D center;
    double r;
    Color externalColor;
    Color internalColor;
    boolean inFrontOfViewport;

    public Sphere(double x, double y, double z, double r, Color externalColor, Color internalColor) {
        this.center = new Point3D(x, y, z);
        this.r = r;
        this.externalColor = externalColor;
        this.internalColor = internalColor;
    }
    
    // Getters and Setters
    
    public Point3D getCenter() {
        return center;
    }
    
    public void setCenter(Point3D center) {
        this.center = center;
    }
    
    public double getR() {
        return r;
    }
    
    public void setR(double r) {
        this.r = r;
    }
    
    public Color getExternalColor() {
        return externalColor;
    }
    
    public void setExternalColor(Color externalColor) {
        this.externalColor = externalColor;
    }
    
    public Color getInternalColor() {
        return internalColor;
    }
    
    public void setInternalColor(Color internalColor) {
        this.internalColor = internalColor;
    }
    
    public boolean isInFrontOfViewport() {
        return inFrontOfViewport;
    }
    
    public void setInFrontOfViewport(boolean inFrontOfViewport) {
        this.inFrontOfViewport = inFrontOfViewport;
    }
    
    public void setInFrontOfViewport(double focalDistance) {
        this.inFrontOfViewport = center.z+r >= focalDistance;
    }
    
    boolean isInFrontOfViewport(double focalDistance) {
        return center.z+r >= focalDistance;
    }
    
    // 
    public Point3D[] getIntersectionWithLine(double x, double y) {
        /*******************************
         * line's parametric equation: *
         * x = x0 + t*vx               *
         * y = y0 + t*vy               *
         * z = z0 + t*vz               *
         *******************************/
        // in this situation v[0,0,1], so vx=0,vy=0,vz=1, so x=x0, y=y0
        /**************************************************************
         * circle's equation:                                         *
         * (x-x₀)² + (y-y₀)² = r²                                     *
         * inside circle:                                             *
         * (x-x₀)² + (y-y₀)² - r² ≤ 0                                 *
         *                      0 ≤ r² - (x-x₀)² - (y-y₀)²            *
         * sphere equation:                                           *
         * (x-x₀)² + (y-y₀)² + (z-z₀)² = r²                           *
         *                     (z-z₀)² = r² - (x-x₀)² - (y-y₀)²       *
         * (z-z₀)² = t                                                *
         * z² - 2⋅z⋅z₀ + z₀² = t                                      *
         * z² - 2⋅z₀⋅z + z₀² - t = 0                                  *
         * a=1, b=-2z₀, c=z₀²-t                                       *
         * Δ=b²-4ac = (-2z₀)² - 4⋅1⋅(z₀² - t) = 4z₀² - 4z₀² + 4t = 4t *
         * Δ=4t, √Δ=2√t                                               *
         * z=(-b±√Δ)/2a = (-(-2z₀) ± 2√t) / 2*1 = z₀ ± √t             *
         * z=z₀±√t                                                    *
         **************************************************************/
        
        double t = r*r - Math.pow(x - center.x, 2) - Math.pow(y - center.y, 2);
        if (t >= 0) {
            double z1 = center.z-Math.sqrt(t);
            double z2 = center.z+Math.sqrt(t);
            return new Point3D[]{new Point3D(x, y, z1), new Point3D(x, y, z2)};
        }
        return null;
    }
}
