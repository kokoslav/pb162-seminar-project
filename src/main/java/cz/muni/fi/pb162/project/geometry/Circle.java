/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Lukas Kokodic
 */
public class Circle {
    private final Vertex2D center;
    private final double radius;
    
    /**
     * Constructor
     * <p>
     * a parametric-free constructor,
     * this method is used for creating a circle,
     * creates a circle with center in (0,0) and radius 1
     */
    public Circle(){
         this(new Vertex2D(0.0, 0.0), 1.0);
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a circle
     * @param center center of a circle, represented by a vertex
     * @param radius radius of a circle
     */
    public Circle(Vertex2D center, double radius){
        this.center = center;
        this.radius = radius;
    }
    
    public Vertex2D getCenter(){
        return this.center;
    }
    
    public double getRadius(){
        return this.radius;
    }
    
    /**
     * Returns the string representation of a circle
     * <p>
     * @return string representation of a circle
     */
    @Override
    public String toString() {
        return "Circle: center=" + center.toString() + ", radius=" + this.radius;
    }
}
