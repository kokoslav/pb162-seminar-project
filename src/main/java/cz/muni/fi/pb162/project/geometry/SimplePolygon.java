/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 *
 * @author Lukas Kokodic
 */
public abstract class SimplePolygon extends SimpleMath implements Polygon {
    
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
