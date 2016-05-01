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

    /*
    @author Dhaval Doshi
    @version 1.0
    @since 05-01-2016
    @return none
     */
    public void getStudentCountForCourse(){
        /*
        This method fetches the list of students enrolled in each courses
         */
        try{
            for(ClassEnum enm: ClassEnum.values()){
                System.out.println(enm.getName()+"    "+enm.getCount());
            }
        }
        catch(Exception ex){}

    }
    /*
        @author Dhaval Doshi
        @version 1.0
        @since 05-01-2016
        @return none
     */
    public void getClassesOfStudents(){
        /*
        This method gets the list of classes each student is enrolled in the database
         */
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

    /*
    @author Dhaval Doshi
    @version 1.0
    @since 05-01-2016
    @params profName: Name of professor whose course list is updated
    @params courseName: Name of the course to be associated with professor
    @return none
     */
    public void updateProfessorClassList(String profName, String courseName){
        /*
        This method adds the particular course to the professor's course list
         */
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
    /*
        @author Dhaval Doshi
        @version 1.0
        @since 05-01-2016
        @params studentId: Integer type field denoting the unique student ID
        @params courseName: Name of the course which student has taken
        @return none
    */
    public void updateStudentCourseList(int studentId, String courseName){
        /*
        This method adds the course to student's course list
         */
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
    /*
    @author Dhaval Doshi
    @version 1.0
    @since 05-01-2016
    @params profName: Name of professor to be associated with course name
    @params courseName: Name of the course
    @return none
     */
    public void updateCourseProfessors(String courseName, String profName){
        /*
        This method adds the name of the professor to Professor set of courseName enum.
         */
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
    /*
        @author Dhaval Doshi
        @version 1.0
        @since 05-01-2016
        @return none
    */
    public void getProfOfCourses(){
        /*
        This method gets the tuples of courses and associated professors with it
         */
        for(ClassEnum enm: ClassEnum.values()){
            for(String profName: enm.getProfessors()){
                System.out.println(enm.getName()+"   "+profName);
            }
        }
    }
    /*
    @author Dhaval Doshi
    @version 1.0
    @since 05-01-2016
    @params courseName: Name of the course whose count is to be updated
    @return none
     */
    public void updateCourseCount(String courseName){
        /*
        This methods increases the number of students registered for a particular course
         */
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
    /*
        @author Dhaval Doshi
        @version 1.0
        @since 05-01-2016
        @return none
         */
    public void getStudentsWithMoreClasses(){
        /*
        This method returns the id of the students who are enrolled in more than 1 classes
         */
        Map<Integer, ArrayList<ClassEnum>> studentCourseMap = prof.getStudentCourseMap();
        for(Map.Entry items: studentCourseMap.entrySet()){
            if(((ArrayList)items.getValue()).size() > 1){
                System.out.println(items.getKey());
            }
        }
    }
    /*
        @author Dhaval Doshi
        @version 1.0
        @since 05-01-2016
        @return none
         */
    public void getProfessorWithMoreClasses(){
        /*
        This method returns the name of the professor who teaches more than 1 course
         */
        Map<String,Set<ClassEnum>> classProfMap = prof.getClassProfMap();
        for(Map.Entry items: classProfMap.entrySet()){
            if(((HashSet)items.getValue()).size() > 1){
                System.out.println(items.getKey());
            }
        }
    }
}
