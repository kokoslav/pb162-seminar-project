package cz.muni.fi.pb162.project;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Lukas Kokodic
 */
public class Demo {

    /**
     * Creates 2 vertices: [2,3] and [1,1] Shifts the first vertex by the second
     * one Prints both of theirs string representations
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Vertex2D vertexA = new Vertex2D();
        vertexA.setX(2);
        vertexA.setY(3);

        Vertex2D vertexB = new Vertex2D();
        vertexB.setX(1);
        vertexB.setY(1);

        vertexA.move(vertexB);

        System.out.println(vertexA.getInfo());
        System.out.println(vertexB.getInfo());

    }
}
