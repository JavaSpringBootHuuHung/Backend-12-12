package vn.techzen.academy_12.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_12.entity.Student;
import vn.techzen.academy_12.repository.IStudentRepository;
import vn.techzen.academy_12.service.IStudentService;

import java.util.List;
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
//    @Autowired
//    private IStudentRepository studentRepository;


    IStudentRepository studentRepository;



//    private IStudentRepository studentRepository;
//    @Autowired
//    public void setStudentRepository(IStudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
    @Override
    public List<Student> findAlls(String name, Double fromScore, Double toScore) {
//        return studentRepository.findByNameContainingAndScoreBetween(name, fromScore, toScore);
        return studentRepository.findByAttr(name, fromScore, toScore);
    }
    @Override
    public Student findById(int id){
        return studentRepository.findById(id).get();
    }
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }
}
