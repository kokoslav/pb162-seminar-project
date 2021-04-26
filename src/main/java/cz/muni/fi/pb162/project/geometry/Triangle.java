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
public class Triangle extends ArrayPolygon implements Measurable {
    private final Triangle[] arrayOfTriangles = new Triangle[3];
    private static final double DEVIATION = 0.001;

    /**
     * Constructor
     * <p>
     * this method is used for creating a triangle
     *
     * @param v0 first vertex of a triangle
     * @param v1 second vertex of a triangle
     * @param v2 third vertex of a triangle
     */
    public Triangle(Vertex2D v0, Vertex2D v1, Vertex2D v2) {
        super(new Vertex2D[] {v0, v1, v2});
    }

    /**
     * Constructor
     * <p>
     * this method is used for creating a triangle and then dividing it
     *
     * @param v0 first vertex of a triangle
     * @param v1 second vertex of a triangle
     * @param v2 third vertex of a triangle
     * @param depth depth of division
     */
    public Triangle(Vertex2D v0, Vertex2D v1, Vertex2D v2, int depth) {
        this(v0, v1, v2);
        this.divide(depth);
    }

    /**
     * Divides a triangle into 3 subTriangles
     * <p>
     * Divides a triangle if it hasn't been divided already Puts the created
     * subTriangles into arrayOfTriangles
     *
     * @return false if triangle has already been divided, true if it hasn't
     */
    public boolean divide() {
        if (this.isDivided()) {
            return false;
        }
        this.arrayOfTriangles[0] = new Triangle(this.getVertex(0),
                this.getVertex(0).createMiddle(this.getVertex(1)),
                this.getVertex(0).createMiddle(this.getVertex(2)));
        this.arrayOfTriangles[1] = new Triangle(this.getVertex(1).createMiddle(this.getVertex(0)),
                this.getVertex(1),
                this.getVertex(1).createMiddle(this.getVertex(2)));
        this.arrayOfTriangles[2] = new Triangle(this.getVertex(2).createMiddle(this.getVertex(0)),
                this.getVertex(2).createMiddle(this.getVertex(1)),
                this.getVertex(2));
        return true;
    }

    void divide(int depth) {
        if (depth <= 0) {
            return;
        }
        this.divide();
        this.arrayOfTriangles[0].divide(depth - 1);
        this.arrayOfTriangles[1].divide(depth - 1);
        this.arrayOfTriangles[2].divide(depth - 1);
    }

    /**
     * Returns if triangle has been divided already or not
     * <p>
     * @return true if the triangle has been divided already, false if it hasn't
     */
    public boolean isDivided() {
        return this.getSubTriangle(0) != null;
    }

    /**
     * Returns a subTriangles created by division
     * <p>
     * @param index of the subTriangles we want to be returned
     * @return one of the 3 subTriangles indicated by index, null if triangle
     * hasn't been divided yet
     */
    public Triangle getSubTriangle(int index) {
        if ((index < 0) | (index > 2)) {
            return null;
        }
        return this.arrayOfTriangles[index];
    }

    /**
     * Returns if triangle is equilateral or not
     * <p>
     * @return true if the triangle is equilateral, false if it isn't
     */
    boolean isEquilateral() {
        double sideA = this.getVertex(0).distance(this.getVertex(1));
        double sideB = this.getVertex(1).distance(this.getVertex(2));
        double sideC = this.getVertex(2).distance(this.getVertex(0));
        return (Math.abs(sideA - sideB) < DEVIATION)
                && (Math.abs(sideB - sideC) < DEVIATION)
                && (Math.abs(sideC - sideA) < DEVIATION);
    }

    /**
     * Returns the string representation of a triangle
     * <p>
     * @return string representation of a triangle
     */
    @Override
    public String toString() {
        return "Triangle: vertices="
                + this.getVertex(0).toString() + " "
                + this.getVertex(1).toString() + " "
                + this.getVertex(2).toString();
    }

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

}
