package vn.techzen.academy_12.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_12.model.Student;
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
    public List<Student> findAlls(){
        return studentRepository.findAlls();
    }
    @Override
    public Student findById(int id){
        return studentRepository.findById(id);
    }
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }
}
