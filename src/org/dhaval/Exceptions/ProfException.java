package org.dhaval.Exceptions;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class ProfException extends Exception {

    @Override
    public String toString(){
        return ("Professor name cannot be null");
    }
}
