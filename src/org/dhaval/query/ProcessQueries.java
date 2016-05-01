package org.dhaval.query;

import org.dhaval.Exceptions.NoCourseNameException;
import org.dhaval.Exceptions.ProfException;
import org.dhaval.Exceptions.StudentIdException;
import org.dhaval.Model.ClassEnum;
import org.dhaval.Model.ProfStudentDB;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class ProcessQueries {

    ProfStudentDB prof;

    public ProcessQueries(ProfStudentDB prof) {
        this.prof = prof;
    }

    public int getStudentCountForCourse(String courseName){
        try{

            if(courseName == null){
                throw new NoCourseNameException();
            }
            ClassEnum cnm = ClassEnum.valueOf(courseName.toUpperCase());
            return cnm.getCount();
        }
        catch(NoCourseNameException ex){
            System.out.println(ex.toString());
        }

        return 0;
    }

    public void getClassesOfStudents(int studentId){
        try{
            if(studentId <= 0){
                throw new StudentIdException();
            }
            Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
            for(Map.Entry items : studentCourseMap.entrySet()){
                //String courses = "";
                System.out.println(items.getKey()+": "+items.getValue());
            }
        }
        catch(StudentIdException ex){
            System.out.println(ex.toString());
        }
    }

    public void getProfessorClassList(String profName){
        try{
            if(profName == null){
                throw new ProfException();
            }
            Map<String,ArrayList<ClassEnum>> classProfMap = prof.getClassProfMap();
            for(Map.Entry items: classProfMap.entrySet()){
                System.out.println(items.getKey()+"   "+items.getValue());
            }
        }
        catch(ProfException ex){
            System.out.println(ex.toString());
        }

    }

    public void updateProfessorClassList(String profName, String courseName){
        Map<String,ArrayList<ClassEnum>> classProfMap = prof.getClassProfMap();
        if(profName != null && classProfMap.containsKey(profName)){
           classProfMap.get(profName).add(ClassEnum.valueOf(courseName.toUpperCase()));
        }
        else{
            classProfMap.put(profName, new ArrayList<ClassEnum>());
            classProfMap.get(profName).add(ClassEnum.valueOf(courseName.toUpperCase()));
        }
    }

    public void updateStudentProfessorList(int studentId, String courseName){
        Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
        if(studentId >= 0 && studentCourseMap.containsKey(studentId)){
            studentCourseMap.get(studentId).add(ClassEnum.valueOf(courseName.toUpperCase()))   ;
        }
        else{
            studentCourseMap.put(studentId, new ArrayList<ClassEnum>());
            studentCourseMap.get(studentId).add(ClassEnum.valueOf(courseName.toUpperCase()));
        }
    }

    public void updateCourseCount(String courseName){
        ClassEnum cnm = ClassEnum.valueOf(courseName.toUpperCase());
        cnm.setCount(cnm.getCount()+1);
    }

}
