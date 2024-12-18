package vn.techzen.academy_12.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.dto.student.StudentRequest;
import vn.techzen.academy_12.dto.student.StudentResponse;
import vn.techzen.academy_12.entity.Student;
import vn.techzen.academy_12.mapper.IStudentMapper;
import vn.techzen.academy_12.service.IStudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    IStudentService studentService;
    IStudentMapper studentMapper;
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudents(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "0") Double fromScore,@RequestParam(defaultValue = "10") Double toScore) {
        return ResponseEntity.ok(studentService.findAll(name,fromScore,toScore)
                .stream()
                        .map(studentMapper::studentToStudentResponse)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getByIdStudents(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(
                ApiResponse.<Student>builder().data(student).build());
    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest studentRequest) {
        // buoc 1: StudentRequest -> Student
//        Student student1 = Student.builder().name(studentRequest.getName())
//                .score(studentRequest.getScore())
//                .clazz(Clazz.builder().id(studentRequest.getClazz().getId()).build())
//                .build();
        Student student = studentMapper.studentRequestToStudent(studentRequest);

        studentService.save(student);
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);

//        StudentResponse studentResponse = StudentResponse.builder().name(student1.getName())
//                .score(student1.getScore())
//                .clazz(ClazzResponse.builder().id(student1.getClazz().getId()).build())
//                .build();
        return  ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }
}