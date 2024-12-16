package vn.techzen.academy_12.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.JsonResponse;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;
import vn.techzen.academy_12.entity.Student;
import vn.techzen.academy_12.service.impl.EmployeeService;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("employees")
public class ManageEmployeeController {

    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "dobFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
            @RequestParam(value = "dobTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
            @RequestParam(value = "gender", required = false) Gender gender,
            @RequestParam(value = "salaryRange", required = false) Integer salaryRange,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "departmentId", required = false) Integer departmentId
    ) {
        try {
            List<Employee> filteredEmployees = employeeService.findAll(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
            return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
                    .data(filteredEmployees)
                    .build());
        } catch (Exception e) {
            throw new AppException(ErrorCode.CANNOT_CALL_API);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw  new AppException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(ApiResponse.<Employee>builder()
                .data(employee)
                .build());
    }
    // API to add a new employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return JsonResponse.created(employee);
    }



    // API to update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.update(employee,id);
        return JsonResponse.ok(employee);
    }

    // API to delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        List<Employee> remainingEmployees = employeeService.findAll(null, null, null, null, null, null, null);

        return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
                .data(remainingEmployees)
                .build());
    }


}