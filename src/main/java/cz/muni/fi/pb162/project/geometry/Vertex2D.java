/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Lukas Kokodic
 *
 * Represents a 2D vertex Has 2 parameters: x and y
 */
public class Vertex2D {

    private double x;
    private double y;

    /**
     * Constructor
     * <p>
     * this method is used for creating a vertex
     *
     * @param x the X coordinate of the vertex
     * @param y the Y coordinate of the vertex
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns middle vertex
     * <p>
     * Returns the middle vertex in between the one this method has been called
     * on and the one in the parameter of the method
     *
     * @param vertex second vertex
     * @return Vertex2D that is in the middle of the first and second vertex
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        return new Vertex2D((this.x + vertex.x) / 2, (this.y + vertex.y) / 2);
    }

    /**
     * Returns the string representation of a vertex
     * <p>
     * @return string representation of a vertex
     */
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

}
