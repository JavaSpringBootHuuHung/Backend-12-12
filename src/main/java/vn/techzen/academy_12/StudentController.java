package vn.techzen.academy_12;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.model.Student;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private List<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student(1,"Hoang",9.6),
                    new Student(2,"abc",9.6)
            )
    );
    // @RequestMapping(value = "/students",method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

   // @RequestMapping("/students/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random() * 100000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}
