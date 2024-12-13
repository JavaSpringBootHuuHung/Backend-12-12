package vn.techzen.academy_12.repository;

import vn.techzen.academy_12.model.Student;

import java.util.List;

public interface IStudentRepository {
     List<Student> findAlls();
     Student findById(int id);
     Student save(Student student);
}
