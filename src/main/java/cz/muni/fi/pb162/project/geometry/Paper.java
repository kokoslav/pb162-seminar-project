/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;
import static cz.muni.fi.pb162.project.geometry.Color.WHITE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lukas Kokodic
 */
public class Paper implements Drawable {
    private List<ColoredPolygon> polygons;
    private Color color = BLACK;
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an empty Paper
     */
    public Paper(){
        this.polygons = new ArrayList<>();
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating a Paper
     * copies all DrawablePolygons from drawable
     * 
     * @param drawable these DrawablePolygons will be copied
     */
    public Paper(Drawable drawable) {
        this.polygons = new ArrayList<>(drawable.getAllDrawnPolygons());
    }
    
    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        ColoredPolygon coloredPolygon = new ColoredPolygon(polygon, this.color);
        if ((coloredPolygon.getColor() == WHITE) || (this.polygons.contains(coloredPolygon))) {
            return;
        }
        this.polygons.add(coloredPolygon);
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        this.polygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        this.polygons.removeAll(this.polygons);
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableList(this.polygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> vertices = new HashSet<>();
        for (int i = 0; i < this.polygons.size(); i++) {
            for (int j = 0; j < this.polygons.get(i).getPolygon().getNumVertices(); j++) {
                vertices.add(this.polygons.get(i).getPolygon().getVertex(j));
            }
        }
        return vertices.size();
    }
    
}
