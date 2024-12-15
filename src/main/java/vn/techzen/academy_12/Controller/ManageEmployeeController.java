package vn.techzen.academy_12.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.JsonResponse;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;
import vn.techzen.academy_12.service.impl.EmployeeService;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("employees")
public class ManageEmployeeController {
    @Autowired
    private EmployeeService employeeService;

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
            throw  new AppException(ErrorCode.CANNOT_CALL_API);
        }
    }


//    // API to find employee by ID
    @GetMapping({"/{id}"})
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
        }
        return ResponseEntity.ok(ApiResponse.<Employee>builder().data(employee).build());

    }

    // API to add a new employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return JsonResponse.created(employee);
    }



    // API to update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        employeeService.update(employee);
        return JsonResponse.ok(employee);
    }

    // API to delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        List<Employee> remainingEmployees = employeeService.findAll(null, null, null, null, null, null, null);

        return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
                .data(remainingEmployees)
                .build());
    }


}
