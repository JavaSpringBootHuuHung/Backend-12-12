package vn.techzen.academy_12.repository.impl;

import org.springframework.stereotype.Repository;
import vn.techzen.academy_12.model.Student;
import vn.techzen.academy_12.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private List<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student(1,"Hoang",9.6),
                    new Student(2,"abc",9.6)
            )
    );
    public List<Student> findAlls(){
        return students;
    }
    public Student findById(int id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
    public Student save(Student student){
        student.setId((int)(Math.random() *10000));
        students.add(student);
        return student;
    }


}
