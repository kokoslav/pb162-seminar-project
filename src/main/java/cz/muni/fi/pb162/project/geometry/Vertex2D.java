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

    private double x = 0;
    private double y = 0;

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
     * Shifts the vertex by another vertex coordinates
     * <p>
     * Sets x1 as (x1 + x2) Sets y1 as (y1 + y2)
     * <p>
     * @param vertex vertex by whose parameters will the Vertex2D shift
     *
     */
    public void move(Vertex2D vertex) {
        this.x += vertex.x;
        this.y += vertex.y;
    }

    /**
     * Returns the sum of both parameters of a vertex
     * <p>
     * @return sum of both parameters
     */
    double sumCoordinates() {
        return x + y;
    }

    /**
     * Returns the string representation of a vertex
     * <p>
     * @return string representation of a vertex
     */
    public String getInfo() {
        return "[" + this.x + ", " + this.y + "]";
    }

}
