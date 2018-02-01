package com.mycompany.light_reflection.view;

import com.mycompany.light_reflection.model.Point3D;
import com.mycompany.light_reflection.model.Sphere;
import com.mycompany.light_reflection.model.Util;
import com.mycompany.light_reflection.model.Vector3D;
import com.mycompany.light_reflection.model.ViewportModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Paweł Mac
 */
public final class ViewportJPanel extends JPanel implements Observer {
    
    ViewportModel viewportModel;
    
    public ViewportJPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        //this.setBackground(Color.black);
    }
    
    // Setters
    
    public void setViewportModel(ViewportModel viewportModel) {
        this.viewportModel = viewportModel;
    }
    
    // Methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        if (viewportModel != null) {
            Sphere sphere = viewportModel.getSphere();
            Point3D center = sphere.getCenter();
            Point3D light = viewportModel.getLight();
            double focalDistance = viewportModel.getFocalDistance();
            int viewportWidth = viewportModel.getViewportWidth();
            int viewportHeight = viewportModel.getViewportHeight();
            int xShift = viewportWidth/2;
            int yShift = viewportHeight/2;
            
            double I_a = viewportModel.getI_a();
            double I_p = viewportModel.getI_p();
            double n = viewportModel.getN();
            double k_a = viewportModel.getK_a();
            double k_d = viewportModel.getK_d();
            double k_s = viewportModel.getK_s();
            double c = viewportModel.getC();
            
            //* begin new version
            double ambientIntensityAdjusted = Math.min(Math.max(I_a, 0.0d), 255.0d);
            int red   = (int) (ambientIntensityAdjusted * this.getBackground().getRed()   / 255.0);
            int green = (int) (ambientIntensityAdjusted * this.getBackground().getGreen() / 255.0);
            int blue  = (int) (ambientIntensityAdjusted * this.getBackground().getBlue()  / 255.0);
            Color backgroundColor = new Color(red, green, blue);
            Color color;
            Point3D point3D;
            
            Point3D origin = new Point3D();
            Point3D viewportPoint3D = new Point3D();
            for (int y = yShift; y > -yShift; y--) {
                for (int x = -xShift; x < xShift; x++) {
                    viewportPoint3D.setXYZ(x, y, focalDistance);
                    Point3D[] lineSphereIntersectionPoint3Ds = Util.lineSphereIntersectionPoint3Ds(origin, viewportPoint3D, sphere);
                    if (lineSphereIntersectionPoint3Ds != null) {
                        Point3D p1 = lineSphereIntersectionPoint3Ds[0];
                        Point3D p2 = lineSphereIntersectionPoint3Ds[1];
                        if (p1.isInFrontOfViewport(focalDistance)) {
                            point3D = p1;
                            color = sphere.getExternalColor();
                        } else {
                            point3D = p2;
                            color = sphere.getInternalColor();
                        }
                        point3D.calculatePoint2D(focalDistance, viewportWidth, viewportHeight);
                        Point2D point2D = point3D.getPoint2D();
                        
                        // N -- vector normal to the surface
                        Vector3D N = new Vector3D(point3D.getX() - center.getX(), point3D.getY() - center.getY(), point3D.getZ() - center.getZ());
                        N.normalize();
                        // V -- vector directed to the observer
                        Vector3D V = new Vector3D(-point3D.getX(), -point3D.getY(), -point3D.getZ());
                        V.normalize();
                        // L -- vector directed to the light source
                        Vector3D L = new Vector3D(light.getX() - point3D.getX(), light.getY() - point3D.getY(), light.getZ() - point3D.getZ());;
                        L.normalize();
                        
                        double NLdotProduct = Vector3D.dotProduct(N, L);
                        
                        // R -- reflection from L
                        // R = 2(N◦L)N - L
                        Vector3D R = new Vector3D(2*NLdotProduct*N.getX() - L.getX(), 2*NLdotProduct*N.getY() - L.getY(), 2*NLdotProduct*N.getZ() - L.getZ());
                        R.normalize();
                        
                        // cos(α) = (v◦u) / (|v||u|)
                        double cos_alpha = Vector3D.dotProduct(V, R);
                        
                        double f_att = 1.0 / (c+L.length());
                        
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙kd∙(N◦L) + fₐₜₜ∙Iₚ∙kₛ∙cosⁿα
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙kd∙(N◦L) + fₐₜₜ∙Iₚ∙kₛ∙(V◦R)ⁿ
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙(kd∙(N◦L) + kₛ∙cosⁿα)
                        double I = I_a*k_a + f_att*I_p*(k_d*NLdotProduct + k_s*Math.pow(cos_alpha, n));
                        
                        I = Math.min(Math.max(I, 0), 255);
                        
                        red   = (int) (I*color.getRed()/255.0);
                        green = (int) (I*color.getGreen()/255.0);
                        blue  = (int) (I*color.getBlue()/255.0);
                        
                        color = new Color(red, green, blue);
                        
                        if (!p1.isInFrontOfViewport(focalDistance) && !p2.isInFrontOfViewport(focalDistance)) {
                            color = backgroundColor;
                        }
                        
                        g2D.setPaint(color);
                        g2D.draw(new Line2D.Double(point2D, point2D));
                    } else {
                        g2D.setPaint(backgroundColor);
                        g2D.drawLine(x+xShift, -y+yShift, x+xShift, -y+yShift);
                    }
                }
            }
            // end new version */
            
            /* commented
            // reduce iterations number
            int limit = (int) sphere.getR();
            limit++;
            yShift = limit;
            xShift = limit;
            
            for (int y = yShift; y > -yShift; y--) {
                for (int x = -xShift; x < xShift; x++) {
                    Point3D[] intersectionWithLine = sphere.getIntersectionWithLine(x, y);
                    if (intersectionWithLine != null) {
                        Point3D p1 = intersectionWithLine[0];
                        Point3D p2 = intersectionWithLine[1];
                        Point3D point3D = p1.isInFrontOfViewport(focalDistance) ? p1 : p2;
                        point3D.calculatePoint2D(focalDistance, viewportWidth, viewportHeight);
                        Point2D point2D = point3D.getPoint2D();
                        Color color = point3D.equals(p1) ? sphere.getExternalColor() : sphere.getInternalColor();
                        
                        // N -- vector normal to the surface
                        Vector3D N = new Vector3D(point3D.getX() - center.getX(), point3D.getY() - center.getY(), point3D.getZ() - center.getZ());
                        N.normalize();
                        // V -- vector directed to the observer
                        Vector3D V = new Vector3D(-point3D.getX(), -point3D.getY(), -point3D.getZ());
                        V.normalize();
                        // L -- vector directed to the light source
                        Vector3D L = new Vector3D(light.getX() - point3D.getX(), light.getY() - point3D.getY(), light.getZ() - point3D.getZ());;
                        L.normalize();
                        
                        double NLdotProduct = Vector3D.dotProduct(N, L);
                        
                        // R -- reflection from L
                        // R = 2(N◦L)N - L
                        Vector3D R = new Vector3D(2*NLdotProduct*N.getX() - L.getX(), 2*NLdotProduct*N.getY() - L.getY(), 2*NLdotProduct*N.getZ() - L.getZ());
                        R.normalize();
                        
                        // cos(α) = (v◦u) / (|v||u|)
                        double cos_alpha = Vector3D.dotProduct(V, R);
                        
                        double f_att = 1.0 / (c+L.length());
                        
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙kd∙(N◦L) + fₐₜₜ∙Iₚ∙kₛ∙cosⁿα
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙kd∙(N◦L) + fₐₜₜ∙Iₚ∙kₛ∙(V◦R)ⁿ
                        // I = Iₐ∙kₐ + fₐₜₜ∙Iₚ∙(kd∙(N◦L) + kₛ∙cosⁿα)
                        double I = I_a*k_a + f_att*I_p*(k_d*NLdotProduct + k_s*Math.pow(cos_alpha, n));
                        
                        I = Math.min(Math.max(I, 0), 255);
                        
                        int red   = (int) (I*color.getRed()/255.0);
                        int green = (int) (I*color.getGreen()/255.0);
                        int blue  = (int) (I*color.getBlue()/255.0);
                        
                        color = new Color(red, green, blue);
                        
                        g2D.setPaint(color);
                        g2D.draw(new Line2D.Double(point2D, point2D));
                    }
                }
            }
            // commented */
        } else {
            System.out.println("viewportModel == null");
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
