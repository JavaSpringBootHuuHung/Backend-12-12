package vn.techzen.academy_12.service;

import vn.techzen.academy_12.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAlls(String name, Double fromScore, Double toScore);
    public Student findById(int id);

    Student save(Student student);
}
