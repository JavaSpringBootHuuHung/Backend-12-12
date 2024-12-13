package vn.techzen.academy_12.service;

import vn.techzen.academy_12.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAlls();
    public Student findById(int id);
    public Student save(Student student);
}
