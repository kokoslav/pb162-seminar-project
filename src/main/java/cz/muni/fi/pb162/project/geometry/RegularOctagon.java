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
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Constructor
     * <p>
     * this method is used for creating an octagon
     *
     * @param center center of the octagon
     * @param radius radius of the octagon
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }

}
