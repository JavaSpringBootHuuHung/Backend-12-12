package vn.techzen.academy_12.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.techzen.academy_12.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(String name, Double fromScore, Double toScore);

    Student findById(Integer id);

    Student save(Student student);
}
