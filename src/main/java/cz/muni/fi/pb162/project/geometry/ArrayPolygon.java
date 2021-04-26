/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 *
 * @author Lukas Kokodic
 */
public class ArrayPolygon extends SimplePolygon {
    private Vertex2D[] coordinates;
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an ArrayPolygon
     *
     * @param coordinates array of vertices of a polygon
     */
    public ArrayPolygon(Vertex2D[] coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates array is null");
        }
        if (coordinates.length < 3) {
            throw new IllegalArgumentException("coordinates array has less than 3 vertices");
        }
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] == null) {
                throw new IllegalArgumentException(i + ". coordinate in array is null");
            }
        }
        this.coordinates = new Vertex2D[coordinates.length];
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index is negative");
        }
        return this.coordinates[index % this.coordinates.length];
    }

    @Override
    public int getNumVertices() {
        return this.coordinates.length;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() !=  this.getClass()) {
            return false;
        }

        ArrayPolygon polygon = (ArrayPolygon)o;
        if (polygon.getNumVertices() != this.getNumVertices()) {
            return false;
        }
        
        for (int i = 0; i < this.coordinates.length; i++) {
            if (!this.getVertex(i).equals(polygon.getVertex(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the hash code
     * <p>
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = 17;
        for (int i = 0; i < this.coordinates.length; i++) {
            result = result * 31 + this.coordinates[i].hashCode();
        }
        return result;
    }
}
