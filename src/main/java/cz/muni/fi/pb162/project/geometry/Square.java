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
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * Constructor
     * <p>
     * this method is used for creating a square using center and diameter
     *
     * @param center center of the square
     * @param diameter diameter of the square
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2);
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

    @Override
    public String toString() {
        String output = "Square: vertices=";
        for (int i = 0; i < 3; i++) {
            output = output + this.getVertex(i).toString() + " ";
        }
        return output + this.getVertex(3).toString();
    }
}
