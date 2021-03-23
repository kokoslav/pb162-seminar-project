package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Class for running main method.
 *
 * @author Lukas Kokodic
 */
public class Demo {

    /**
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Vertex2D(-100, 0),
                new Vertex2D(0, 100),
                new Vertex2D(100, -100));
        System.out.println(triangle.toString());
    }
}