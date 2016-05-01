package org.dhaval.driver;

import org.dhaval.Exceptions.SingletonObjectException;
import org.dhaval.Model.ProfStudentDB;
import org.dhaval.query.ProcessQueries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dhaval on 4/30/2016.
 */
public class Driver {

    public static void main(String[] args) {

        String line ="";
        String csvSplitter = ",";
        try{
            BufferedReader br = new BufferedReader(new FileReader("Input.csv"));
            ProfStudentDB profSTDB = ProfStudentDB.getSingletonObject();
            ProcessQueries ps = new ProcessQueries(profSTDB);
            while((line = br.readLine()) != null){
                String data[] = line.split(csvSplitter);
                ps.updateCourseCount(data[0].trim());
                ps.updateCourseProfessors(data[0],data[1]);
                ps.updateProfessorClassList(data[1].trim(), data[0].trim());
                ps.updateStudentCourseList(Integer.parseInt(data[2].trim()),data[0].trim());
            }
            //perform queries

            System.out.println("Get class-professor tuples");
            ps.getProfOfCourses();
            System.out.println("List of classes taken by each student");
            ps.getClassesOfStudents();
            System.out.println("number of students registered for each class");
            ps.getStudentCountForCourse();
            System.out.println("Student who take more than 1 course");
            ps.getStudentsWithMoreClasses();
            System.out.println("Professor who takes more than 1 course");
            ps.getProfessorWithMoreClasses();

        }
        catch(IOException | SingletonObjectException ex){
            ex.printStackTrace();
        }

    }
}
