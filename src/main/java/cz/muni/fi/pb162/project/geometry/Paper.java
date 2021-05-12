/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Lukas Kokodic
 */
public class Paper implements Drawable, PolygonFactory {
    private List<ColoredPolygon> polygons = new ArrayList<>();
    private Color color = Color.BLACK;
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an empty Paper
     */
    public Paper(){
        this.polygons = new ArrayList<>();
        this.color = Color.BLACK;
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
        this.color = Color.BLACK;
    }
    
    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        ColoredPolygon coloredPolygon = new ColoredPolygon(polygon, this.color);
        if (this.color == Color.WHITE) {
            throw new TransparentColorException("You are drawing in " + this.color.toString());
        }
        if ((this.polygons.contains(coloredPolygon))) {
            return;
        }
        this.polygons.add(coloredPolygon);
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        this.polygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (this.polygons.isEmpty()) {
            throw new EmptyDrawableException("Paper is empty!");
        }
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

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if (vertices == null) {
            throw new NullPointerException();
        }
        try {
            List <Vertex2D> verticesCopy = new ArrayList<>(vertices);
            CollectionPolygon polygon = new CollectionPolygon(verticesCopy.toArray(new Vertex2D[0]));
            return polygon;
        } catch (IllegalArgumentException e) {
            List <Vertex2D> verticesCopy = new ArrayList<>();         
            for (Vertex2D vertex: vertices) {
                if (vertex != null) {
                    verticesCopy.add(vertex);
                }
            }
            return tryToCreatePolygon(verticesCopy);
        }
        
    }
    
    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        boolean drawn = false;
        Exception exception = new Exception();
        for (List<Vertex2D> collectionPolygon: collectionPolygons) {
            try {
                drawPolygon(tryToCreatePolygon(collectionPolygon));
                drawn = true;
            } catch(TransparentColorException e) {
                this.changeColor(Color.BLACK);
                exception = e;
            } catch(NullPointerException | MissingVerticesException e) {
                exception = e;
            }
        }
        if (!drawn) {
            throw new EmptyDrawableException(exception);
        }
        
    }
    
    Collection<Polygon> getPolygonsWithColor(Color color) {
        return this.getAllDrawnPolygons()
                .stream()
                .filter(polygon -> polygon.getColor().equals(color))
                .map(ColoredPolygon::getPolygon)
                .collect(Collectors.toList());
    }
    
}
