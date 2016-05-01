package org.dhaval.Exceptions;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class SingletonObjectException extends Exception {

    @Override
    public String toString(){
        return "Singleton Class cannot have more than one objects";
    }
}
