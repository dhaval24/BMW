package org.dhaval.Model;

import org.dhaval.Exceptions.SingletonObjectException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class ProfStudentDB {

    public Map<String, ArrayList<ClassEnum>> getClassProfMap() {
        return classProfMap;
    }

    public void setClassProfMap(Map<String, ArrayList<ClassEnum>> classProfMap) {
        this.classProfMap = classProfMap;
    }

    public Map<Integer, ArrayList<ClassEnum>> getStudentCourseMap() {
        return studentCourseMap;
    }

    public void setStudentCourseMap(Map<Integer, ArrayList<ClassEnum>> studentCourseMap) {
        this.studentCourseMap = studentCourseMap;
    }

    private Map<String,ArrayList<ClassEnum>> classProfMap = new HashMap<>();
    private Map<Integer, ArrayList<ClassEnum>> studentCourseMap = new HashMap<>();

    private static int countObjects = 0;
    private ProfStudentDB() {
    }
    public ProfStudentDB getSingletonObject() throws SingletonObjectException{

        if(countObjects == 0){
            countObjects++;
            return new ProfStudentDB();
        }
        else{
            throw new SingletonObjectException();
        }
    }
}
