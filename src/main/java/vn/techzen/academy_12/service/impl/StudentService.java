package vn.techzen.academy_12.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.techzen.academy_12.entity.Student;
import vn.techzen.academy_12.repository.IStudentRepository;
import vn.techzen.academy_12.service.IStudentService;

import java.util.List;
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    @Override
    public Page<Student> findAll(String name, Pageable pageable) {
        return studentRepository.findByAttr(name, 0.0, 9.7, pageable);
    }

    @Override
    public Student findById(Integer id) {
        if (id == null) { // validate
            return null;
        }
        // sendmail
        return studentRepository.findById(id).get();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
