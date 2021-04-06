/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 *
 * @author Lukas Kokodic
 */
public class Gauger {

    /**
     * Prints width and height of a Measurable shape
     * <p>
     * @param shape a Measurable shape, whose width and height will be printed
     */
    public static void printMeasurement(Measurable shape) {
        System.out.println("Width: " + shape.getWidth());
        System.out.println("Height: " + shape.getHeight());
    }

    /**
     * Prints string representation, width and height of a Triangle
     * <p>
     * @param triangle a Triangle, whose string representation, width and height
     * will be printed
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle.toString());
        Gauger.printMeasurement((Measurable) triangle);
    }
}
