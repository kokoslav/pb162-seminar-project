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
public class EmptyDrawableException extends Exception {
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an EmptyDrawableException
     *
     * @param s message of the EmptyDrawableException
     */
    public EmptyDrawableException(String s) {
        super(s);
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an EmptyDrawableException
     *
     * @param s message of the EmptyDrawableException
     * @param cause cause of the EmptyDrawableException
     */
    public EmptyDrawableException(String s, Throwable cause) {
        super(s, cause);
    }
    
    /**
     * Constructor
     * <p>
     * this method is used for creating an EmptyDrawableException
     *
     * @param cause cause of the EmptyDrawableException
     */
    public EmptyDrawableException(Throwable cause) {
        super(cause);
    }
}
