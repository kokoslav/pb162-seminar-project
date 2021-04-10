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
public enum Color {
    WHITE, RED, GREEN, BLUE, YELLOW, ORANGE, PINK, PURPLE, BROWN, BLACK;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
