package vn.techzen.academy_12;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.model.Student;
import vn.techzen.academy_12.service.IStudentService;
import vn.techzen.academy_12.service.impl.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController  {
     IStudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAlls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudents(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw  new AppException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}
