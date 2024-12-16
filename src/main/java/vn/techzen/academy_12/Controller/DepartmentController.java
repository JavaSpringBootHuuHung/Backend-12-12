package vn.techzen.academy_12.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.JsonResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.entity.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final List<Department> departments = new ArrayList<>(
            Arrays.asList(
                    new Department(1,"Quản lý"),
                    new Department(2, "Kế toán"),
                    new Department(3, "Marketing"),
                    new Department(4, "Sản xuất")
            )
    );
    @GetMapping
    public ResponseEntity<?> getDepartments() {
        return JsonResponse.ok(departments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") int id) {
        return  departments.stream()
                .filter(d->d.getId() == id)
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXITS));
    }
    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        department.setId((int)(Math.random()*1000));
        departments.add(department);
        return JsonResponse.created(departments);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable("id") int id, @RequestBody Department department) {
        return  departments.stream()
                .filter(d->d.getId() == id)
                .findFirst()
                .map(d->{
                    d.setName(department.getName());
                    return JsonResponse.ok(departments);
                }
                )
                .orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXITS));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") int id) {
        return  departments.stream()
                .filter(d->d.getId() == id)
                .findFirst()
                .map(d->{
                        departments.remove(d);
                        return JsonResponse.noContent();
                    }
                )
                .orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXITS));
    }

}
