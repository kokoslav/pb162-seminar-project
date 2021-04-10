/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;

/**
 *
 * @author Lukas Kokodic
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {

    private Vertex2D center;
    private int numberOfEdges;
    private double radius;
    private Color color = BLACK;

    /**
     * Constructor
     * <p>
     * this method is used for creating a GeneralRegularPolygon
     *
     * @param center center of the polygon
     * @param numberOfEdges number of edges of the polygon
     * @param radius radius of the polygon
     */
    public GeneralRegularPolygon(Vertex2D center, int numberOfEdges, double radius) {
        this.center = center;
        this.numberOfEdges = numberOfEdges;
        this.radius = radius;
    }

    @Override
    public int getNumEdges() {
        return this.numberOfEdges;
    }

    @Override
    public double getEdgeLength() {
        return 2 * this.radius * Math.sin(Math.PI / this.numberOfEdges);
    }

    /**
     * Returns a polygon vertex
     * <p>
     * @param index index of the vertex we want
     * @return one of the polygon's vertices, indicated by index
     */
    @Override
    public Vertex2D getVertex(int index) {
        double x = this.center.getX() - this.radius * Math.cos(index * 2 * Math.PI / this.numberOfEdges);
        double y = this.center.getY() - this.radius * Math.sin(index * 2 * Math.PI / this.numberOfEdges);
        return new Vertex2D(x, y);
    }

    @Override
    public double getWidth() {
        return 2 * this.radius;
    }

    @Override
    public double getHeight() {
        return 2 * this.radius;
    }

    @Override
    public Vertex2D getCenter() {
        return this.center;
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.numberOfEdges + "-gon: center=" + this.center.toString()
                + ", radius=" + this.radius + ", color=" + this.color.toString();
    }

}
