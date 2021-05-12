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
public class TransparentColorException extends Exception {
    
        /**
     * Constructor
     * <p>
     * this method is used for creating an TransparentColorException
     *
     * @param s message of the TransparentColorException
     */
    public TransparentColorException(String s) {
        super(s);
    }
    
        /**
     * Constructor
     * <p>
     * this method is used for creating an TransparentColorException
     *
     * @param s message of the TransparentColorException
     * @param cause cause of the TransparentColorException
     */
    public TransparentColorException(String s, Throwable cause) {
        super(s, cause);
    }
}
