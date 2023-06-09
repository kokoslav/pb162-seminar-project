/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 *
 * @author Lukas Kokodic
 *
 * Represents a 2D vertex Has 2 parameters: x and y
 */
public class Vertex2D implements Comparable<Vertex2D>{

    private final double x;
    private final double y;

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
     * Returns the Euclidean distance between two vertices
     * <p>
     *
     * @param vertex second vertex
     * @return distance between the first and second vertex
     */
    public double distance(Vertex2D vertex) {
        if (vertex == null) {
            return -1.0;
        }
        return Math.sqrt(Math.pow(vertex.getX() - this.x, 2) + Math.pow(vertex.getY() - this.y, 2));
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
    
    /**
     * Compares two vertices
     * <p>
     * @return if these two vertices are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vertex2D)) {
            return false;
        }

        Vertex2D vertex = (Vertex2D) o;

        return (vertex.x == this.x) &&
                (vertex.y == this.y);
    }

    /**
     * Returns the hash code
     * <p>
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    /**
     * Compares two vertices
     * <p>
     * @param o vertex
     * @return comparison of 2 vertices
     */
    @Override
    public int compareTo(Vertex2D o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (o.getClass() != Vertex2D.class) {
            throw new IllegalArgumentException();
        }
        if (Double.compare(this.getX(), o.getX()) == 0) {
            return Double.compare(this.getY(), o.getY());
        }
        return Double.compare(this.getX(), o.getX());
    }

}
