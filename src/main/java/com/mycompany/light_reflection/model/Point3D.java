package com.mycompany.light_reflection.model;

import java.awt.geom.Point2D;
import java.util.Comparator;

/**
 *
 * @author Paweł Mac
 */
public class Point3D {
    
    public static final Point3D.XComparator X_COMPARATOR = new Point3D.XComparator();
    public static final Point3D.YComparator Y_COMPARATOR = new Point3D.YComparator();
    public static final Point3D.ZComparator Z_COMPARATOR = new Point3D.ZComparator();
    
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
    
    // Getter
    
    public Point2D getPoint2D() {
        return point2D;
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
    
    public void setXYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public boolean isInFrontOfViewport() {
        return inFrontOfViewport;
    }
    
    public void setInFrontOfViewport(boolean inFrontOfViewport) {
        this.inFrontOfViewport = inFrontOfViewport;
    }
    
    public boolean isInFrontOfViewport(double focalDistance) {
        this.inFrontOfViewport = z >= focalDistance;
        return z >= focalDistance;
    }
    
    public void setInFrontOfViewport(double focalDistance) {
        this.inFrontOfViewport = z >= focalDistance;
    }
    
    // Methods
    
    public void calculatePoint2D(double focalDistance, int viewportWidth, int viewportHeight) {
        double x = (this.x * focalDistance) / this.z;
        double y = (this.y * focalDistance) / this.z;
        x =  x + (viewportWidth  / 2.0d);
        y = -y + (viewportHeight / 2.0d);
        this.point2D.setLocation(x, y);
        if (this.getZ() >= focalDistance) {
            this.setInFrontOfViewport(true);
        } else {
            this.setInFrontOfViewport(false);
        }
    }
    
    @Override
    public String toString() {
        return "Point3D{" + "x=" + x + ", y=" + y + ", z=" + z + ", point2D=" + point2D + '}';
    }
    
    public static class XComparator implements Comparator<Point3D> {
        
        @Override
        public int compare(Point3D p1, Point3D p2) {
            return Double.compare(p1.x, p2.x);
        }
    }
    
    public static class YComparator implements Comparator<Point3D> {
        
        @Override
        public int compare(Point3D p1, Point3D p2) {
            return Double.compare(p1.y, p2.y);
        }
    }
    
    public static class ZComparator implements Comparator<Point3D> {
        
        @Override
        public int compare(Point3D p1, Point3D p2) {
            return Double.compare(p1.z, p2.z);
        }
    }
}
