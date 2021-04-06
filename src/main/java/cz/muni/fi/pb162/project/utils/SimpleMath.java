/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 *
 * @author Lukas Kokodic
 */
public class SimpleMath {

    /**
     * Returns the lowest X coordinate of a Triangle
     * <p>
     * @param triangle a triangle, whose lowest X coordinate we want to be
     * returned
     * @return lowest X coordinate of a Triangle
     */
    public static double minX(Triangle triangle) {
        double min = triangle.getVertex(0).getX();
        for (int i = 1; i < 3; i++) {
            if (min > triangle.getVertex(i).getX()) {
                min = triangle.getVertex(i).getX();
            }
        }
        return min;
    }

    /**
     * Returns the lowest Y coordinate of a Triangle
     * <p>
     * @param triangle a triangle, whose lowest Y coordinate we want to be
     * returned
     * @return lowest Y coordinate of a Triangle
     */
    public static double minY(Triangle triangle) {
        double min = triangle.getVertex(0).getY();
        for (int i = 1; i < 3; i++) {
            if (min > triangle.getVertex(i).getY()) {
                min = triangle.getVertex(i).getY();
            }
        }
        return min;
    }

    /**
     * Returns the highest X coordinate of a Triangle
     * <p>
     * @param triangle a triangle, whose highest X coordinate we want to be
     * returned
     * @return highest X coordinate of a Triangle
     */
    public static double maxX(Triangle triangle) {
        double max = triangle.getVertex(0).getX();
        for (int i = 1; i < 3; i++) {
            if (max < triangle.getVertex(i).getX()) {
                max = triangle.getVertex(i).getX();
            }
        }
        return max;
    }

    /**
     * Returns the highest Y coordinate of a Triangle
     * <p>
     * @param triangle a triangle, whose highest Y coordinate we want to be
     * returned
     * @return highest Y coordinate of a Triangle
     */
    public static double maxY(Triangle triangle) {
        double max = triangle.getVertex(0).getY();
        for (int i = 1; i < 3; i++) {
            if (max < triangle.getVertex(i).getY()) {
                max = triangle.getVertex(i).getY();
            }
        }
        return max;
    }
}
