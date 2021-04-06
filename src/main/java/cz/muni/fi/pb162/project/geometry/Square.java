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
public class Square implements Circular {

    private Vertex2D center;
    private double diameter;

    /**
     * Constructor
     * <p>
     * this method is used for creating a square using center and diameter
     *
     * @param center center of the square
     * @param diameter diameter of the square
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }

    /**
     * Constructor
     * <p>
     * this method is used for creating a square using another Circular shape
     *
     * @param shape a Circular shape
     */
    public Square(Circular shape) {
        this(shape.getCenter(), shape.getRadius() * 2);
    }

    /**
     * Returns a square vertex
     * <p>
     * @param index index of the vertex we want
     * @return one of the square's vertices, indicated by index
     */
    public Vertex2D getVertex(int index) {
        if (index == 0) {
            return new Vertex2D(center.getX() - this.getRadius(), center.getY());
        }
        if (index == 1) {
            return new Vertex2D(center.getX(), center.getY() - this.getRadius());
        }
        if (index == 2) {
            return new Vertex2D(center.getX() + this.getRadius(), center.getY());
        }
        if (index == 3) {
            return new Vertex2D(center.getX(), center.getY() + this.getRadius());
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "Square: vertices=";
        for (int i = 0; i < 3; i++) {
            output = output + this.getVertex(i).toString() + " ";
        }
        return output + this.getVertex(3).toString();
    }

    @Override
    public Vertex2D getCenter() {
        return this.center;
    }

    @Override
    public double getRadius() {
        return this.diameter / 2;
    }
}
