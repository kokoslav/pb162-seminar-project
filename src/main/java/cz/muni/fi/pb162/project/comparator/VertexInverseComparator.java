/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import java.util.Comparator;

/**
 *
 * @author Lukas Kokodic
 */
public class VertexInverseComparator implements Comparator<Vertex2D>{
    @Override
    public int compare(Vertex2D v, Vertex2D v2) {
        return -v.compareTo(v2);
    }
}
