/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.exception;

/**
 *
 * @author Lukas Kokodic
 */
public class MissingVerticesException extends RuntimeException {
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an MissingVerticesException
     *
     * @param s message of the MissingVerticesException
     */
    public MissingVerticesException(String s) {
        super(s);
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an MissingVerticesException
     *
     * @param s message of the MissingVerticesException
     * @param cause cause of the MissingVerticesException
     */
    public MissingVerticesException(String s, Throwable cause) {
        super(s, cause);
    }
}