package org.dhaval.query;

import org.dhaval.Exceptions.NoCourseNameException;
import org.dhaval.Exceptions.ProfException;
import org.dhaval.Exceptions.StudentIdException;
import org.dhaval.Model.ClassEnum;
import org.dhaval.Model.ProfStudentDB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class ProcessQueries {

    ProfStudentDB prof;

    public ProcessQueries(ProfStudentDB prof) {
        this.prof = prof;
    }

    public void getStudentCountForCourse(){
        try{
            for(ClassEnum enm: ClassEnum.values()){
                System.out.println(enm.getName()+"    "+enm.getCount());
            }
        }
        catch(Exception ex){}

    }

    public void getClassesOfStudents(){
        try{
//            if(studentId <= 0){
//                throw new StudentIdException();
//            }
            Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
            for(Map.Entry items : studentCourseMap.entrySet()){
                //String courses = "";
                System.out.println(items.getKey()+": "+items.getValue());
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }


    public void updateProfessorClassList(String profName, String courseName){
        Map<String,Set<ClassEnum>> classProfMap = prof.getClassProfMap();
        if(profName != null){
            if(classProfMap.containsKey(profName)){
                classProfMap.get(profName).add(ClassEnum.valueOf(courseName.toUpperCase()));
            }
            else {
                classProfMap.put(profName, new HashSet<ClassEnum>());
                classProfMap.get(profName).add(ClassEnum.valueOf(courseName.toUpperCase()));
            }
        }
        else{
            try{
                throw new ProfException();
            }
            catch(ProfException ex){
                System.out.println(ex.toString());
            }
        }
    }

    public void updateStudentCourseList(int studentId, String courseName){
        Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
        if(studentId >= 0){
            if(studentCourseMap.containsKey(studentId)){
                studentCourseMap.get(studentId).add(ClassEnum.valueOf(courseName.toUpperCase()));
            }
            else{
                studentCourseMap.put(studentId, new ArrayList<>());
                studentCourseMap.get(studentId).add(ClassEnum.valueOf(courseName.toUpperCase()));
            }
        }
        else{
            try{
                throw new StudentIdException();
            }
            catch(StudentIdException ex){
                System.out.println(ex.toString());
            }
        }
    }
    public void updateCourseProfessors(String courseName, String profName){
        try{
            if(profName == null){
                throw new ProfException();
            }
            if(courseName == null){
                throw new NoCourseNameException();
            }
            ClassEnum cnm = ClassEnum.valueOf(courseName.toUpperCase());
            if(cnm.getProfessors() == null){
                cnm.setProfessors(new HashSet<>());
                cnm.getProfessors().add(profName);
            }
            else{
                cnm.getProfessors().add(profName);
            }
        }
        catch(NoCourseNameException | ProfException ex){
            ex.toString();
        }

    }

    public void getProfOfCourses(){
        for(ClassEnum enm: ClassEnum.values()){
            for(String profName: enm.getProfessors()){
                System.out.println(enm.getName()+"   "+profName);
            }
        }
    }

    public void updateCourseCount(String courseName){
        try{
            if(courseName == null){
                throw new NoCourseNameException();
            }
            ClassEnum cnm = ClassEnum.valueOf(courseName.toUpperCase());
            cnm.setCount(cnm.getCount()+1);
        }
        catch(NoCourseNameException ex){
            System.out.println(ex.toString());
        }

    }

    public void getStudentsWithMoreClasses(){
        Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
        for(Map.Entry items: studentCourseMap.entrySet()){
            if(((ArrayList)items.getValue()).size() > 1){
                System.out.println(items.getKey());
            }
        }
    }

    public void getProfessorWithMoreClasses(){
        Map<String,Set<ClassEnum>> classProfMap = prof.getClassProfMap();
        for(Map.Entry items: classProfMap.entrySet()){
            if(((HashSet)items.getValue()).size() > 1){
                System.out.println(items.getKey());
            }
        }
    }
}
