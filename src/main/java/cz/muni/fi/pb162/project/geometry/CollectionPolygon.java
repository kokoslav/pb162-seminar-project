/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lukas Kokodic
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> coordinates = new ArrayList<>();
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a CollectionPolygon
     *
     * @param coordinates array of vertices of a polygon
     */
    public CollectionPolygon(Vertex2D[] coordinates) {
        super(coordinates);
        this.coordinates = new ArrayList<>(Arrays.asList(coordinates));
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a CollectionPolygon
     *
     * @param coordinates List of vertices of a polygon
     */
    public CollectionPolygon(List<Vertex2D> coordinates){
        this(coordinates.toArray(new Vertex2D[0]));
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        CollectionPolygon collectionPolygon = (CollectionPolygon) o;
        if (collectionPolygon.getNumVertices() != this.getNumVertices()) {
            return false;
        }
        for (int i = 0; i < this.getNumVertices(); i++) {
            if (this.getVertex(i) != collectionPolygon.getVertex(i)) {
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
        for (int i = 0; i < this.coordinates.size(); i++) {
            result = result * 31 + this.coordinates.get(i).hashCode();
        }
        return result;
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index is negative");
        }
        return coordinates.get(index % coordinates.size());
    }

    @Override
    public int getNumVertices() {
        return coordinates.size();
    }
    
    CollectionPolygon withoutLeftmostVertices() {
        if (this.coordinates.get(0) == null) {
            return null;
        }
        
        double leftmostX = this.coordinates.get(0).getX();
        for (int i = 1; i < this.coordinates.size(); i++) {
            if (this.coordinates.get(i).getX() < leftmostX) {
                leftmostX = this.coordinates.get(i).getX();
            }
        }
        
        List<Vertex2D> coords = new ArrayList<>();
        

        for (int i = 0; i < this.coordinates.size(); i++) {
            if (this.coordinates.get(i).getX() != leftmostX) {
                coords.add(this.coordinates.get(i));
            }
        }
        
        CollectionPolygon withoutLeftmost;
        withoutLeftmost = new CollectionPolygon(coords);
        if (withoutLeftmost.coordinates.size() <= 0) {
            return null;
        }
        return withoutLeftmost;
    }
}
