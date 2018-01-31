package com.mycompany.light_reflection.model;

/**
 *
 * @author Paweł Mac
 */
public class Util {
    
    private Util() {
    }
    
    public static Point3D[] lineSphereIntersectionPoint3Ds(Point3D p1, Point3D p2, Sphere s) throws IllegalArgumentException {
        int xcmp = Point3D.X_COMPARATOR.compare(p1, p2);
        int ycmp = Point3D.Y_COMPARATOR.compare(p1, p2);
        int zcmp = Point3D.Z_COMPARATOR.compare(p1, p2);
        if (xcmp == 0 && ycmp == 0 && zcmp == 0) {
            throw new IllegalArgumentException("p1 and p2 are equals, so vector(direction of line) is zero vector");
        }
        
        ////////////////////////////////////////////////////////
        // sphere equation:                                   //
        // ∥X-C∥² = r²                                        //
        // X - points on the sphere                           //
        // C - center point                                   //
        // r - radius                                         //
        // line parametric equation:                          //
        // X = O + t⋅V                                        //
        // X - points on the line                             //
        // O - origin of the line                             //
        // V - direction of line                              //
        //                                                    //
        // (O + t⋅V - C)² = r²                                //
        // (O + t⋅V - C)(O + t⋅V - C) = r²                    //
        // O²+OtV-OC+OtV+t²V²-CtV-OC-CtV+C² = r²              //
        // t²V² + 2OtV-2CtV + O²-2OC+C² = r²                  //
        // t²V² + 2tV(O-C) + (O-C)² = r²                      //
        // V²t² + 2V(O-C)t + (O-C)² - r² = 0                  //
        // a = V²                                             //
        // b = 2V(O-C)                                        //
        // c = (O-C)²-r²                                      //
        //                                                    //
        // Δ = b²-4ac = 2V(O-C)²-4V²[(O-C)²-r²]               //
        // t₁,₂ = (-b±√Δ) / 2a                                //
        // t₁,₂ = (-2V(O-C)±√(2V(O-C)²-4V²[(O-C)²-r²])) / 2V² //
        ////////////////////////////////////////////////////////
        
        ////////////////////////////////////////////////////////////////////////
        // sphere equation:                                                   //
        // (x-x₀)² + (y-y₀)² + (z-z₀)² = r²                                   //
        // sphere equation:                                                   //
        // (x-x₃)² + (y-y₃)² + (z-z₃)² = r²                                   //
        //                                                                    //
        // line parametric equation:                                          //
        // P = P₀ + t⋅V                                                       //
        // x = x₀ + t⋅v₁                                                      //
        // y = y₀ + t⋅v₂                                                      //
        // z = z₀ + t⋅v₃                                                      //
        // line parametric equation:                                          //
        // x = x₁ + t⋅(x₂-x₁)                                                 //
        // y = y₁ + t⋅(y₂-y₁)                                                 //
        // z = z₁ + t⋅(z₂-z₁)                                                 //
        //                                                                    //
        // a = (x₂-x₁)² + (y₂-y₁)² + (z₂-z₁)²                                 //
        // b = 2[(x₂-x₁)(x₁-x₃) + (y₂-y₁)(y₁-y₃) + (z₂-z₁)(z₁-z₃)]            //
        // c = x₃² + y₃² + z₃² + x₁² + y₁² + z₁² - 2(x₃x₁ + y₃y₁ + z₃z₁) - r² //
        ////////////////////////////////////////////////////////////////////////
        
        double x1 = p1.getX();
        double y1 = p1.getY();
        double z1 = p1.getZ();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double z2 = p2.getZ();
        double x3 = s.getCenter().getX();
        double y3 = s.getCenter().getY();
        double z3 = s.getCenter().getZ();
        double r = s.getR();
        
        double a = Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2) + Math.pow((z2-z1), 2);
        double b = 2*((x2-x1)*(x1-x3) + (y2-y1)*(y1-y3) + (z2-z1)*(z1-z3));
        double c = x3*x3 + y3*y3 + z3*z3 + x1*x1 + y1*y1 + z1*z1 - 2*(x3*x1 + y3*y1 + z3*z1) - r*r;
        
        double delta = b*b - 4*a*c;
        
        if (delta >= 0) {
            double deltaSqrt = Math.sqrt(delta);
            double t1 = (-b - deltaSqrt) / (2*a);
            double t2 = (-b + deltaSqrt) / (2*a);
            // pp = puncture point
            Point3D pp1 = new Point3D(x1+(x2-x1)*t1, y1+(y2-y1)*t1, z1+(z2-z1)*t1);
            Point3D pp2 = new Point3D(x1+(x2-x1)*t2, y1+(y2-y1)*t2, z1+(z2-z1)*t2);
            return new Point3D[]{pp1, pp2};
        }
        return null;
    }
}
