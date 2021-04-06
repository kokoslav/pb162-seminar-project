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
public class Snowman {

    public static final int SIZE = 4;
    private final double reductionFactor = 0.8;
    private Circular[] spheres = new Circular[SIZE];

    /**
     * Constructor
     * <p>
     * this method is used for creating a snowman, creates a snowman of size
     * SIZE
     *
     * @param firstSphere object of type Circular, base of the snowman
     * @param reductionFactor factor, by which the size of continuous spheres
     * decreases
     */
    public Snowman(Circular firstSphere, double reductionFactor) {
        Vertex2D center;
        spheres[0] = firstSphere;
        if (reductionFactor <= 0 || reductionFactor > 1) {
            reductionFactor = this.reductionFactor;
        }
        for (int i = 1; i < SIZE; i++) {
            center = new Vertex2D(spheres[i - 1].getCenter().getX(),
                    spheres[i - 1].getCenter().getY() + spheres[i - 1].getRadius()
                    + spheres[i - 1].getRadius() * reductionFactor);
            spheres[i] = new Circle(center, spheres[i - 1].getRadius() * reductionFactor);
        }
    }

    public Circular[] getBalls() {
        return this.spheres;
    }

}
