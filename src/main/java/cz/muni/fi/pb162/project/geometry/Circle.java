/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.RED;

/**
 *
 * @author Lukas Kokodic
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {

    /**
     * Constructor
     * <p>
     * a parametric-free constructor, this method is used for creating a circle,
     * creates a circle with center in (0,0) and radius 1
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    /**
     * Constructor
     * <p>
     * this method is used for creating a circle
     *
     * @param center center of a circle, represented by a vertex
     * @param radius radius of a circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        super.setColor(RED);
    }

    @Override
    public double getEdgeLength() {
        return 0;
    }

    /**
     * Returns the string representation of a circle
     * <p>
     * @return string representation of a circle
     */
    @Override
    public String toString() {
        return "Circle: center=" + this.getCenter().toString() + ", radius=" + this.getRadius();
    }
}
