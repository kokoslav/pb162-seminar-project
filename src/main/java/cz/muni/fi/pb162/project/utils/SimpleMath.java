/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 *
 * @author Lukas Kokodic
 */
public class SimpleMath {

    /**
     * Returns the lowest X coordinate of a Polygon
     * <p>
     * @param polygon a polygon, whose lowest X coordinate we want to be
     * returned
     * @return lowest X coordinate of a Polygon
     */
    public static double minX(Polygon polygon) {
        double min = polygon.getVertex(0).getX();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            if (min > polygon.getVertex(i).getX()) {
                min = polygon.getVertex(i).getX();
            }
        }
        return min;
    }

    /**
     * Returns the lowest Y coordinate of a Polygon
     * <p>
     * @param polygon a polygon, whose lowest Y coordinate we want to be
     * returned
     * @return lowest Y coordinate of a Polygon
     */
    public static double minY(Polygon polygon) {
        double min = polygon.getVertex(0).getY();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            if (min > polygon.getVertex(i).getY()) {
                min = polygon.getVertex(i).getY();
            }
        }
        return min;
    }

    /**
     * Returns the highest X coordinate of a Polygon
     * <p>
     * @param polygon a polygon, whose highest X coordinate we want to be
     * returned
     * @return highest X coordinate of a Polygon
     */
    public static double maxX(Polygon polygon) {
        double max = polygon.getVertex(0).getX();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            if (max < polygon.getVertex(i).getX()) {
                max = polygon.getVertex(i).getX();
            }
        }
        return max;
    }

    /**
     * Returns the highest Y coordinate of a Polygon
     * <p>
     * @param polygon a polygon, whose highest Y coordinate we want to be
     * returned
     * @return highest Y coordinate of a Polygon
     */
    public static double maxY(Polygon polygon) {
        double max = polygon.getVertex(0).getY();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            if (max < polygon.getVertex(i).getY()) {
                max = polygon.getVertex(i).getY();
            }
        }
        return max;
    }
}
