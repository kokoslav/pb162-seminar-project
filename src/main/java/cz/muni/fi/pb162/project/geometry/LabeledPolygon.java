/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Lukas Kokodic
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable {
    private Map<String, Vertex2D> vertices = new HashMap<>();

    private LabeledPolygon(Map<String, Vertex2D> coordinates) throws MissingVerticesException,
                                                                    IllegalArgumentException {
        super(coordinates.values().toArray(new Vertex2D[0]));
        this.vertices = new TreeMap<>(coordinates);
    }
    
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        return this.vertices.values().toArray(new Vertex2D[0])[index % this.getNumVertices()];
    }

    @Override
    public int getNumVertices() {
        return this.vertices.values().toArray(new Vertex2D[0]).length;
    }

    @Override
    public Vertex2D getVertex(String label) {
        if (this.vertices.containsKey(label)) {
            return this.vertices.get(label);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(this.vertices.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        List<String> keys = new ArrayList<>();
        for (String key : this.vertices.keySet()) {
            if (this.vertices.get(key).equals(vertex)) {
                keys.add(key);
            }
        }
        return keys;
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        SortedSet<Vertex2D> tree = new TreeSet<>(this.vertices.values());
        return tree;
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        SortedSet<Vertex2D> tree = new TreeSet<>(comparator);
        tree.addAll(this.vertices.values());
        return tree;
    }
    
    Collection<Vertex2D> duplicateVertices() {
        Set <Vertex2D> unique = new HashSet<>(vertices.values());
        List<Vertex2D> keys = new ArrayList<>(vertices.values());
        for (Vertex2D vertex : unique) {
            keys.remove(vertex);
        }
        return keys;
    }
    
    /**
     *
    * @author Lukas Kokodic
    *
    * This class is used for building a LabeledPolygon
    */
    public static class Builder implements Buildable<LabeledPolygon> {
        private Map<String, Vertex2D> vertices = new HashMap<>();
        
        /**
        *
        * This method is used for adding a vertex into a LabeledPolygon Builder
        * @param label label of a vertex
        * @param vert vertex of a LabeledPolygon
        * @return this- a LabeledPolygon builder
        */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null || vert == null) {
                throw new IllegalArgumentException("label or vertex is null");
            }
            vertices.put(label, vert);
            return this;
        }
        
        @Override
        public LabeledPolygon build() {
            LabeledPolygon polygon = new LabeledPolygon(vertices);
            return polygon;
        }
        
    }
    
}
