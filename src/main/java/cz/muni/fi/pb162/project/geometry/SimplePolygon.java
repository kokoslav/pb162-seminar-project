/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 *
 * @author Lukas Kokodic
 */
public abstract class SimplePolygon extends SimpleMath implements Polygon {
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a SimplePolygon
     *
     * @param coordinates array of vertices of a polygon
     * @throws MissingVerticesException when there are less than 3 vertices
     * @throws IllegalArgumentException when coordinates array is null or any of its vertices are null
     */
    public SimplePolygon(Vertex2D[] coordinates) throws MissingVerticesException, IllegalArgumentException {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates array is null");
        }
        if (coordinates.length < 3) {
            throw new MissingVerticesException("There are " + coordinates.length + " vertices missing");
        }
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] == null) {
                throw new IllegalArgumentException(i + ". coordinate in array is null");
            }
        }
    }
    
    /**
     * Returns the height of a polygon
     * <p>
     * @return difference between maxY and minY
     */
    @Override
    public double getHeight() {
        return maxY(this) - minY(this);
    }
    
    /**
     * Returns the width of a polygon
     * <p>
     * @return difference between maxX and minX
     */
    @Override
    public double getWidth() {
        return maxX(this) - minX(this);
    }
    
    /**
     * Returns the string representation of a SimplePolygon
     * <p>
     * @return string representation of a SimplePolygon
     */
    @Override
    public String toString() {
        String output = "Polygon: vertices =";
        for (int i = 0; i < this.getNumVertices(); i++) {
            output = output + " " + this.getVertex(i);
        }
        return output;
    }
}
