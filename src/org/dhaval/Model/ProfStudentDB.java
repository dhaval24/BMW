package org.dhaval.Model;

import org.dhaval.Exceptions.SingletonObjectException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class ProfStudentDB {

    public Map<String, Set<ClassEnum>> getClassProfMap() {
        return classProfMap;
    }

    public void setClassProfMap(Map<String, Set<ClassEnum>> classProfMap) {
        this.classProfMap = classProfMap;
    }

    public Map<Integer, ArrayList<ClassEnum>> getStudentCourseMap() {
        return studentCourseMap;
    }

    public void setStudentCourseMap(Map<Integer, ArrayList<ClassEnum>> studentCourseMap) {
        this.studentCourseMap = studentCourseMap;
    }

    private Map<String,Set<ClassEnum>> classProfMap = new HashMap<>();
    private Map<Integer, ArrayList<ClassEnum>> studentCourseMap = new HashMap<>();

    private static int countObjects = 0;
    private ProfStudentDB() {
    }
    public static ProfStudentDB getSingletonObject() throws SingletonObjectException{

        if(countObjects == 0){
            countObjects++;
            return new ProfStudentDB();
        }
        else{
            throw new SingletonObjectException();
        }
    }
}
