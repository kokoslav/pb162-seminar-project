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
public class ColoredPolygon {
    private Polygon polygon;
    private Color color;
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a ColoredPolygon
     *
     * @param polygon a Polygon that will recieve a color
     * @param color Color that the Polygon will be colored with
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }
    
    public Polygon getPolygon() {
        return this.polygon;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Compares two ColoredPolygons
     * <p>
     * @return if these two ColoredPolygons are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColoredPolygon)) {
            return false;
        }
        
        ColoredPolygon coloredPolygon = (ColoredPolygon) o;
        return ((this.color == coloredPolygon.getColor()) &&
                 this.polygon.equals(coloredPolygon.polygon));
    }
    
    /**
     * Returns the hash code
     * <p>
     * @return hash code
     */
    @Override
    public int hashCode() {
        return 17 + this.color.hashCode() + this.polygon.hashCode();
    }
    
    
}
