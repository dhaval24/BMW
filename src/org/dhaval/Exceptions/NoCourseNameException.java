package org.dhaval.Exceptions;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class NoCourseNameException extends Exception {

    @Override
    public String toString(){
        return "Course name cannot be null";
    }

}
