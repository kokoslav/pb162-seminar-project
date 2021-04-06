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
public class Triangle implements Measurable {

    private final Vertex2D[] arrayOfVertices = new Vertex2D[3];
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
        this.arrayOfVertices[0] = v0;
        this.arrayOfVertices[1] = v1;
        this.arrayOfVertices[2] = v2;
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
     * Returns one vertex of a triangle
     * <p>
     * returns one of the vertices, indicated by index
     *
     * @param index of the vertex we want to be returned
     * @return one of the vertices or null if index is out of range(0-2)
     */
    public Vertex2D getVertex(int index) {
        if ((index < 0) | (index > 2)) {
            return null;
        }
        return this.arrayOfVertices[index];
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
        this.arrayOfTriangles[0] = new Triangle(this.arrayOfVertices[0],
                arrayOfVertices[0].createMiddle(arrayOfVertices[1]),
                arrayOfVertices[0].createMiddle(arrayOfVertices[2]));
        this.arrayOfTriangles[1] = new Triangle(arrayOfVertices[1].createMiddle(arrayOfVertices[0]),
                this.arrayOfVertices[1],
                arrayOfVertices[1].createMiddle(arrayOfVertices[2]));
        this.arrayOfTriangles[2] = new Triangle(arrayOfVertices[2].createMiddle(arrayOfVertices[0]),
                arrayOfVertices[2].createMiddle(arrayOfVertices[1]),
                this.arrayOfVertices[2]);
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
        double sideA = this.arrayOfVertices[0].distance(this.arrayOfVertices[1]);
        double sideB = this.arrayOfVertices[1].distance(this.arrayOfVertices[2]);
        double sideC = this.arrayOfVertices[2].distance(this.arrayOfVertices[0]);
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
                + this.arrayOfVertices[0].toString() + " "
                + this.arrayOfVertices[1].toString() + " "
                + this.arrayOfVertices[2].toString();
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
