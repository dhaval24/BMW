package org.dhaval.Exceptions;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class StudentIdException extends Exception {

    @Override
    public String toString(){
        return "Student ID cannot be 0 or less than zero";
    }

}
