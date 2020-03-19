/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author wojtek
 */
@Named(value="studentsBean")
@RequestScoped
public class StudentsBean {
    
    private List<Student> students;
    
    public StudentsBean() {
        this.students = new ArrayList<>();
        for(int i=0; i<20; i++) {
            this.students.add(Student.randomStudent());
        }
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
    
}
